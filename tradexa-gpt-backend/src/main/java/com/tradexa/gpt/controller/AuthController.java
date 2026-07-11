package com.tradexa.gpt.controller;

import com.tradexa.gpt.common.ApiResponse;
import com.tradexa.gpt.dto.RegisterRequest;
import com.tradexa.gpt.dto.RegisterResponse;
import com.tradexa.gpt.service.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;

@RestController
@RequestMapping("/api/v1/auth")
public class AuthController {
    private final UserService userService;

    public AuthController(UserService userService) {
        this.userService=userService;
    }

    @PostMapping("/register")
    public ResponseEntity<ApiResponse<RegisterResponse>> register(
            @RequestBody RegisterRequest request
    ) {
        RegisterResponse registerResponse = userService.register(request);

        ApiResponse<RegisterResponse> response = new ApiResponse<>();

        response.setSuccess(true);
        response.setMessage("User Registered Successfully");
        response.setData(registerResponse);
        response.setTimestamp(LocalDateTime.now());

        return new ResponseEntity<>(response,HttpStatus.CREATED);
    }
}
