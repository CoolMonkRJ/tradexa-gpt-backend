package com.tradexa.gpt.controller;

import com.tradexa.gpt.entity.Trade;
import com.tradexa.gpt.service.TradeService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/trades")
public class TradeController {
    private final TradeService tradeService;
    public TradeController(TradeService tradeService){
        this.tradeService = tradeService;
    }

    @PostMapping
    public ResponseEntity<Trade> addTrade(
            @RequestBody Trade trade
    ){

        Trade savedTrade = tradeService.addTrade(trade);

        return new ResponseEntity<>(savedTrade,HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<Trade>> getAllTrades(){
        List<Trade> trades = tradeService.getAllTrades();
        return ResponseEntity.ok(trades);
    }
}
