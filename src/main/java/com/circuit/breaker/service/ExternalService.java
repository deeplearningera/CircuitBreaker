package com.circuit.breaker.service;

import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import org.springframework.stereotype.Service;

import java.util.Random;

@Service
public class ExternalService {

    private static final String CIRCUIT_BREAKER_NAME = "externalServiceCB";

    @CircuitBreaker(name = CIRCUIT_BREAKER_NAME, fallbackMethod = "fallback")
    public String callExternalService() {

        if (new Random().nextInt(10) < 7) {
            throw new RuntimeException("External service failed");
        }

        return "External service response";
    }

    public String fallback(Throwable ex) {
        return "Fallback response due to error: " + ex.getMessage();
    }
}