package com.tradexa.gpt.controller;

import com.tradexa.gpt.common.ApiResponse;
import com.tradexa.gpt.service.HealthService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@RequestMapping("/api/v1")
public class HealthController {
    private final HealthService healthService;
    public HealthController(HealthService healthService){
        this.healthService =healthService;
    }

    @GetMapping("/health")
    public ApiResponse<Map<String, String>> health(){
        return healthService.getHealthStatus();
    }


}
