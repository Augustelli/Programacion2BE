package com.umprogramacion.utils;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
public class HttpRequestClientImpl implements HttpRequestClient {

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
}
