package com.umprogramacion.web.rest;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.umprogramacion.utils.HttpRequestClientImpl;
import com.umprogramacion.web.rest.dto.request.LoginUser;
import com.umprogramacion.web.rest.dto.request.RegisterUser;
import java.util.HashMap;
import java.util.Map;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(("api/user"))
public class UserController {

    private final HttpRequestClientImpl httpRequestClient;
    private final ObjectMapper objectMapper;

    private static final Logger log = LoggerFactory.getLogger(UserController.class);

    public UserController(HttpRequestClientImpl httpRequestClient, ObjectMapper objectMapper) {
        this.httpRequestClient = httpRequestClient;
        this.objectMapper = objectMapper;
    }

    private String url = "http://192.168.194.254:8080/api";

    @PostMapping(value = "/register")
    public ResponseEntity registerAccount(@RequestBody RegisterUser registerUser) throws JsonProcessingException {
        log.info("Registrando usuario: {}", registerUser.getLogin());
        Map<String, String> bodyRegister = new HashMap<>();
        bodyRegister.put("login", registerUser.getLogin().toLowerCase());
        bodyRegister.put("email", registerUser.getEmail());
        bodyRegister.put("password", registerUser.getPassword());
        bodyRegister.put("langKey", registerUser.getLangKey());
        String bodyRegisterJson = objectMapper.writeValueAsString(bodyRegister);
        log.info("Body para registrar usuario: " + bodyRegisterJson.toString());
        ResponseEntity reqRegister = httpRequestClient.post(url + "/register", bodyRegisterJson);
        log.info("REGISTER STATUS CODE: " + reqRegister.getStatusCode());

        log.info("Usuario registrado: {} | Continua la activación", registerUser.getLogin());

        Map<String, String> bodyActivar = new HashMap<>();
        bodyActivar.put("login", registerUser.getLogin().toLowerCase());
        bodyActivar.put("email", registerUser.getEmail());
        bodyActivar.put("nombres", registerUser.getNombres());
        bodyActivar.put("descripcion", registerUser.getDescripcion());
        String bodyActivarJson = objectMapper.writeValueAsString(bodyActivar);
        log.info("Body para activar usuario: " + bodyActivarJson.toString());
        log.info("Activando usuario: {}", registerUser.getLogin());
        return httpRequestClient.post(url + "/activar", bodyActivarJson);
    }

    @PostMapping(value = "/login")
    public ResponseEntity login(@RequestBody LoginUser loginUser) {
        log.info("Autenticando usuario: {}", loginUser.getUsername());
        return httpRequestClient.post(url + "/authenticate", loginUser);
    }
}
