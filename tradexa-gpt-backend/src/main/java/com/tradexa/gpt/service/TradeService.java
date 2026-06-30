package com.tradexa.gpt.service;

import com.tradexa.gpt.entity.Trade;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class TradeService {

    private final List<Trade> trades = new ArrayList<>();
    private Integer nextId = 1;

    public Trade addTrade(Trade trade){
        trade.setId(nextId);
        nextId++;
        trades.add(trade);
        return trade;
    }
    public List<Trade> getAllTrades(){
        return trades;
    }
}
