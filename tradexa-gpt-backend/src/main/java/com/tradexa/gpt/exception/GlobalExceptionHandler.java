package com.tradexa.gpt.exception;

import com.tradexa.gpt.common.ApiResponse;
import com.tradexa.gpt.entity.Trade;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.time.LocalDateTime;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(TradeNotFoundException.class)
    public ResponseEntity<ApiResponse<Object>> handleTradeNotFoundException(
            TradeNotFoundException exception
    ){
        ApiResponse<Object> response = new ApiResponse<>();
        response.setSuccess(false);
        response.setMessage(exception.getMessage());
        response.setData(null);
        response.setTimestamp(LocalDateTime.now());
        return  ResponseEntity.status(HttpStatus.NOT_FOUND)
                .body(response);
    }
}
