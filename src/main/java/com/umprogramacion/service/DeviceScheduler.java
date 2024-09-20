package com.umprogramacion.service;

import com.umprogramacion.utils.HttpRequestClientImpl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
public class DeviceScheduler {

    private static final Logger log = LoggerFactory.getLogger(DeviceScheduler.class);
    private final RedisService redisService;
    private final HttpRequestClientImpl httpRequestClient;

    public DeviceScheduler(RedisService redisService, HttpRequestClientImpl httpRequestClient) {
        this.redisService = redisService;
        this.httpRequestClient = httpRequestClient;
    }

    //@Scheduled(cron = "0 0 * * * *") // Runs every hour
    @Scheduled(cron = "*/15 * * * * *") // Runs every hour
    public void refreshDeviceList() {
        log.info("Refresacando la lista de dispositivos");
        // TODO Mejorar
        httpRequestClient.setBearerToken(
            "eyJhbGciOiJIUzUxMiJ9.eyJzdWIiOiJhdWd1c3RlbGxpIiwiZXhwIjoxNzM1MjQ3MDI3LCJhdXRoIjoiUk9MRV9VU0VSIiwiaWF0IjoxNzI2NjA3MDI3fQ.w_TcVJ6uxbq3Z3brM8Q6SP_iwlrukv1-qa_jAELKDIzpKfGCmaQG1VK5JssHFSyuGioYpvjwAFaBnpxmVxoJ1g"
        );
        ResponseEntity<String> response = httpRequestClient.get("http://192.168.194.254:8080/api/dispositivos");
        String deviceListJson = response.getBody();
        redisService.saveDeviceList(deviceListJson);
    }
}
