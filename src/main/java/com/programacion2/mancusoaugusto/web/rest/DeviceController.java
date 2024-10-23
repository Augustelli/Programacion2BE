package com.programacion2.mancusoaugusto.web.rest;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.programacion2.mancusoaugusto.domain.User;
import com.programacion2.mancusoaugusto.service.RedisService;
import com.programacion2.mancusoaugusto.service.UserService;
import com.programacion2.mancusoaugusto.utils.HttpRequestClientImpl;
import com.programacion2.mancusoaugusto.web.rest.dto.request.InformSell;
import com.programacion2.mancusoaugusto.web.rest.dto.response.InformSellResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/device")
public class DeviceController {

    private static final Logger log = LoggerFactory.getLogger(DeviceController.class);
    private final HttpRequestClientImpl httpRequestClient;
    private final ObjectMapper objectMapper;
    private final UserService userService;
    private RedisService redisService;
    private final String url = "http://192.168.194.25/8080/api";
    private final String backendToken;

    public DeviceController(
        HttpRequestClientImpl httpRequestClient,
        ObjectMapper objectMapper,
        RedisService redisService,
        UserService userService) {
        this.httpRequestClient = httpRequestClient;
        this.objectMapper = objectMapper;
        this.redisService = redisService;
        this.userService = userService;
        this.backendToken = httpRequestClient.obtainBearerToken();
    }

    @GetMapping
    public String getDeviceList() {
        log.info("Obteniendo lista de dispositivos");
        return redisService.getDeviceList();
    }

    @PostMapping("/inform-sell")
    public ResponseEntity informSell(@RequestBody InformSell informSell) {
        log.info("Informando venta de dispositivo: {}", informSell);
        httpRequestClient.setBearerToken(backendToken);
        ResponseEntity<String> requestResponse = httpRequestClient.post(url + "catedra/vender", informSell);
        if (requestResponse.getStatusCode().is2xxSuccessful()) {
            try {
                InformSellResponse informSellResponse = objectMapper.readValue(requestResponse.getBody(), InformSellResponse.class);
                Integer saleId = informSellResponse.getIdVenta();
                log.info("Venta ID: {}", saleId);

                Optional<User> user = userService.getUserWithAuthorities();
                if (user.isPresent()) {
                    User currentUser = user.get();
                    // TODO AÑADIR TABLA Y ESTABLECER REGISTRO
                }
            } catch (JsonProcessingException e) {
                log.error("Error parsing response", e);
                return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
            }
        } else {
            return requestResponse;
        }

        return ResponseEntity.ok().build();
    }

    @GetMapping("/sells")
    public ResponseEntity getUserSells() {
        log.info("Obteniendo ventas");
        httpRequestClient.setBearerToken(backendToken);
        ResponseEntity<String> requestResponse = httpRequestClient.get(url + "catedra/ventas");
        Optional<User> user = userService.getUserWithAuthorities();
        if (user.isPresent()) {
            User currentUser = user.get();
            try {
                List<InformSellResponse> sales = objectMapper.readValue(requestResponse.getBody(), objectMapper.getTypeFactory().constructCollectionType(List.class, InformSellResponse.class));
                //List<Integer> userSalesId = this.saleService.getUserSalesId(currentUser.getId());
                List<Integer> userSalesId = new ArrayList<>();
                List<InformSellResponse> userSales = sales.stream()
                    .filter(sale -> userSalesId.contains(sale.getIdVenta()))
                    .collect(Collectors.toList());
                return ResponseEntity.ok(userSales);
            } catch (JsonProcessingException e) {
                log.error("Error parsing sales response", e);
                return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
            }
        }
        return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
    }
}
