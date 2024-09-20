package com.umprogramacion.utils;

import org.springframework.http.ResponseEntity;

public interface HttpRequestClient {
    public ResponseEntity get(String url);

    public ResponseEntity post(String url, Object requestBody);
}
