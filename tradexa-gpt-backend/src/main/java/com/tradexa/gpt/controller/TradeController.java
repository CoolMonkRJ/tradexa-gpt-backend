package com.tradexa.gpt.controller;

import com.tradexa.gpt.common.ApiResponse;
import com.tradexa.gpt.dto.TradeRequest;
import com.tradexa.gpt.dto.TradeResponse;
import com.tradexa.gpt.entity.Trade;
import com.tradexa.gpt.service.TradeService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import jakarta.validation.Valid;

import java.util.List;
import java.time.LocalDateTime;

@RestController
@RequestMapping("/api/v1/trades")
public class TradeController {
    private final TradeService tradeService;
    public TradeController(TradeService tradeService){
        this.tradeService = tradeService;
    }

    @PostMapping
    public ResponseEntity<ApiResponse<TradeResponse>> addTrade(
            @Valid
            @RequestBody TradeRequest request
            ){

        TradeResponse savedTrade = tradeService.addTrade(request);

        ApiResponse<TradeResponse> response = new ApiResponse<>();
        response.setSuccess(true);
        response.setMessage("Trade created successfully");
        response.setData(savedTrade);
        response.setTimestamp(LocalDateTime.now());

        return new ResponseEntity<>(response,HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<ApiResponse<List<Trade>>> getAllTrades(){
        List<Trade> trades = tradeService.getAllTrades();

        ApiResponse<List<Trade>> response = new ApiResponse<>();
        response.setSuccess(true);
        response.setMessage("Trades Fetched successfully");
        response.setData(trades);
        response.setTimestamp(LocalDateTime.now());
        return ResponseEntity.ok(response);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ApiResponse<Trade>> getTradeById(
            @PathVariable Integer id
    ){
        Trade trade = tradeService.getTradeById(id);

        ApiResponse<Trade> response = new ApiResponse<>();

        response.setSuccess(true);
        response.setMessage("Trade fetched succesfully");
        response.setData(trade);
        response.setTimestamp(LocalDateTime.now());
        return ResponseEntity.ok(response);
        }
        @DeleteMapping("/{id}")
    public ResponseEntity<ApiResponse<Void>> deleteTrade(
            @PathVariable Integer id
        ) {
        tradeService.deleteTrade(id);
        ApiResponse<Void> response = new ApiResponse<>();
        response.setSuccess(true);
        response.setMessage("Trade deleted successfully");
        response.setData(null);
        response.setTimestamp(LocalDateTime.now());
        return ResponseEntity.ok(response);
    }

    @PutMapping("/{id}")
    public ResponseEntity<ApiResponse<Trade>> updateTrade(
            @PathVariable Integer id,
            @RequestBody Trade updatedTrade
    ) {
        Trade trade = tradeService.updateTrade(id,updatedTrade);

        ApiResponse<Trade> response = new ApiResponse<>();
        response.setSuccess(true);
        response.setMessage("Trade updated successfully");
        response.setData(trade);
        response.setTimestamp(LocalDateTime.now());
        return ResponseEntity.ok(response);
    }
}
