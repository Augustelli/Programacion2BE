package com.programacion2.mancusoaugusto.web.rest;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.programacion2.mancusoaugusto.domain.User;
import com.programacion2.mancusoaugusto.service.RedisService;
import com.programacion2.mancusoaugusto.service.UserService;
import com.programacion2.mancusoaugusto.utils.HttpRequestClientImpl;
import com.programacion2.mancusoaugusto.web.rest.dto.request.InformSell;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/api/device")
public class DeviceController {

    private static final Logger log = LoggerFactory.getLogger(DeviceController.class);
    private final HttpRequestClientImpl httpRequestClient;
    private final ObjectMapper objectMapper;
    private final UserService userService;
    private RedisService redisService;
    private final String url = "http://192.168.194.25/8080/api";

    public DeviceController(
        HttpRequestClientImpl httpRequestClient,
        ObjectMapper objectMapper,
        RedisService redisService,
        UserService userService) {
        this.httpRequestClient = httpRequestClient;
        this.objectMapper = objectMapper;
        this.redisService = redisService;
        this.userService = userService;
    }

    @GetMapping
    public String getDeviceList() {
        log.info("Obteniendo lista de dispositivos");
        return redisService.getDeviceList();
    }

    @PostMapping("/inform-sell")
    public ResponseEntity informSell(@RequestHeader("Authorization") String bearerToken, @RequestBody InformSell informSell) {
        log.info("Informando venta de dispositivo: {}", informSell);
        httpRequestClient.setBearerToken(bearerToken);

        Optional<User> user = userService.getUserWithAuthorities();
        if (user.isPresent()) {
            log.info("Usuario ID: {}", user.get().getId());
        } else {
            log.warn("Usuario no encontrado");
        }

        return ResponseEntity.ok().build();
    }
}
