package com.programacion2.mancusoaugusto.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.programacion2.mancusoaugusto.utils.HttpRequestClientImpl;
import com.programacion2.mancusoaugusto.web.rest.dto.request.AutenticarUsuarioCatedra;
import org.springframework.http.ResponseEntity;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import jakarta.annotation.PostConstruct;

@Component
public class DeviceScheduler {

    private static final Logger log = LoggerFactory.getLogger(DeviceScheduler.class);
    private final RedisService redisService;
    private final HttpRequestClientImpl httpRequestClient;
    private String bearerToken;

    public DeviceScheduler(RedisService redisService, HttpRequestClientImpl httpRequestClient) {
        this.redisService = redisService;
        this.httpRequestClient = httpRequestClient;
    }


    @PostConstruct
    public void init() {
        try {
            log.info("Initializing DeviceScheduler");
            this.bearerToken = this.httpRequestClient.obtainBearerToken();
            log.info("Bearer token obtained: {}", this.bearerToken);
            refreshDeviceList();
        } catch (Exception e) {
            log.error("Error during initialization", e);
            throw e;
        }
    }

    @Scheduled(cron = "0 */10 * * * *") // Runs every 10 minutes
    public void refreshDeviceList() {
        log.info("Refreshing device list");
        try {
            httpRequestClient.setBearerToken(this.bearerToken);
            ResponseEntity<String> response = httpRequestClient.get("http://192.168.194.254:8080/api/dispositivos");
            String deviceListJson = response.getBody();
            redisService.saveDeviceList(deviceListJson);
        } catch (Exception e) {
            log.error("Error refreshing device list", e);
        }
    }
}
