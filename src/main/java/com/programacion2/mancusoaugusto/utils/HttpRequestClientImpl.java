package com.programacion2.mancusoaugusto.utils;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.programacion2.mancusoaugusto.web.rest.dto.request.AutenticarUsuarioCatedra;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
public class HttpRequestClientImpl implements HttpRequestClient {
    private static final Logger log = LoggerFactory.getLogger(HttpRequestClientImpl.class);
    private final RestTemplate restTemplate;

    private String bearerToken;

    public HttpRequestClientImpl(RestTemplate getRestTemplate) {
        this.restTemplate = getRestTemplate;
    }

    public void setBearerToken(String bearerToken) {
        this.bearerToken = bearerToken;
    }

    @Override
    public ResponseEntity get(String url) {
        return sendRequest(HttpMethod.GET, url, null);
    }

    @Override
    public ResponseEntity post(String url, Object requestBody) {
        return sendRequest(HttpMethod.POST, url, requestBody);
    }

    private ResponseEntity sendRequest(HttpMethod method, String url, Object requestBody) {
        HttpHeaders headers = new HttpHeaders();
        headers.set("Content-Type", "application/json");
        if (bearerToken != null) {
            headers.set("Authorization", "Bearer " + bearerToken);
        }
        HttpEntity<Object> requestEntity = new HttpEntity<>(requestBody, headers);
        return restTemplate.exchange(url, method, requestEntity, String.class);
    }

    public String obtainBearerToken() {
        try {
            log.info("Obtaining bearer token");
            AutenticarUsuarioCatedra authRequest = new AutenticarUsuarioCatedra();
            ResponseEntity request =post("http://192.168.194.254:8080/api/authenticate", authRequest);
            log.info("Request to obtain bearer token: {}", request);
            String token = request.getBody().toString();
            log.info("Bearer token response: {}", token);
            ObjectMapper mapper = new ObjectMapper();
            log.info("Bearer token: {}", mapper.readTree(token).get("id_token").asText());
            return mapper.readTree(token).get("id_token").asText();
        } catch (JsonProcessingException e) {
            log.error("Error obtaining bearer token", e);
            throw new RuntimeException("Bearer token not found", e);
        }
    }
}
