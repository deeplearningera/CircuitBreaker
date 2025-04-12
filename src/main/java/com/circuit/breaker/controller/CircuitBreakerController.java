package com.circuit.breaker.controller;

import com.circuit.breaker.service.ExternalService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CircuitBreakerController {

    private final ExternalService externalService;

    public CircuitBreakerController(ExternalService externalService) {
        this.externalService = externalService;
    }

    @GetMapping("/external")
    public String callExternal() {
        return externalService.callExternalService();
    }
}
