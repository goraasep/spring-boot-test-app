package com.goraaa.test_app.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/ping")
public class PingController {
    @GetMapping
    public ResponseEntity<String> getPing() {
        long requestTime = System.currentTimeMillis();
        // Simulate processing time
        try {
            Thread.sleep(100); // Example delay of 100ms
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        long responseTime = System.currentTimeMillis();
        String response = "pong, Response Time: " + (responseTime - requestTime) + " ms";
        return new ResponseEntity<>(response, HttpStatus.OK);
    }
}
