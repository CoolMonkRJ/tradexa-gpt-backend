package com.tradexa.gpt.mapper;

import com.tradexa.gpt.dto.TradeRequest;
import com.tradexa.gpt.dto.TradeResponse;
import com.tradexa.gpt.entity.Trade;

public class TradeMapper {

    public static Trade toEntity(TradeRequest request) {

        Trade trade = new Trade();

        trade.setSymbol(request.getSymbol());
        trade.setSide(request.getSide());
        trade.setQuantity(request.getQuantity());
        trade.setEntryPrice(request.getEntryPrice());
        trade.setExitPrice(request.getExitPrice());
        trade.setEntryTime(request.getEntryTime());
        trade.setExitTime(request.getExitTime());
        trade.setPnl(request.getPnl());

        return trade;
    }

    public static TradeResponse toResponse(Trade trade) {

        TradeResponse response = new TradeResponse();

        response.setId(trade.getId());
        response.setSymbol(trade.getSymbol());
        response.setSide(trade.getSide());
        response.setQuantity(trade.getQuantity());
        response.setEntryPrice(trade.getEntryPrice());
        response.setExitPrice(trade.getExitPrice());
        response.setEntryTime(trade.getEntryTime());
        response.setExitTime(trade.getExitTime());
        response.setPnl(trade.getPnl());

        return response;
    }
}