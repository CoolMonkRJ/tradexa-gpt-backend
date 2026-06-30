package com.tradexa.gpt.service;

import org.springframework.stereotype.Service;
import com.tradexa.gpt.common.ApiResponse;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

@Service
public class HealthService {
    public ApiResponse<Map<String,String>> getHealthStatus(){

        Map<String,String> healthData = new HashMap<>();
        healthData.put("status","UP");
        return  new ApiResponse<>(
                true,
                "Tradexa GPT backend is running successfully",
                healthData,
                LocalDateTime.now());
    }
}
