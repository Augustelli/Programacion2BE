package com.umprogramacion.web.rest;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.umprogramacion.service.RedisService;
import com.umprogramacion.utils.HttpRequestClientImpl;
import com.umprogramacion.web.rest.dto.request.InformSell;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/device")
public class DeviceController {

    private static final Logger log = LoggerFactory.getLogger(DeviceController.class);
    private final HttpRequestClientImpl httpRequestClient;
    private final ObjectMapper objectMapper;
    private RedisService redisService;
    private final String url = "http://192.168.194.25/8080/api";

    public DeviceController(HttpRequestClientImpl httpRequestClient, ObjectMapper objectMapper, RedisService redisService) {
        this.httpRequestClient = httpRequestClient;
        this.objectMapper = objectMapper;
        this.redisService = redisService;
    }

    @GetMapping
    public String getDeviceList() {
        log.info("Obteniendo lista de dispositivos");
        return redisService.getDeviceList();
    }

    @PostMapping("/inform-sell")
    public ResponseEntity informSell(@RequestHeader("Authorization") String bearerToken, @RequestBody InformSell informSell) {
        log.info("Informando venta de dispositivo");
        httpRequestClient.setBearerToken(bearerToken);
        return httpRequestClient.post(url + "/vender", informSell);
    }
}
