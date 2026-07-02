package com.tradexa.gpt.service;

import com.tradexa.gpt.controller.TradeController;
import com.tradexa.gpt.dto.TradeRequest;
import com.tradexa.gpt.dto.TradeResponse;
import com.tradexa.gpt.entity.Trade;
import com.tradexa.gpt.exception.TradeNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Iterator;

@Service
public class TradeService {

    private final List<Trade> trades = new ArrayList<>();
    private int nextId = 1;


    public TradeResponse addTrade(TradeRequest request){
        Trade trade = new Trade();

        trade.setId(nextId++);
        trade.setSymbol(request.getSymbol());
        trade.setSide(request.getSide());
        trade.setQuantity(request.getQuantity());
        trade.setEntryPrice(request.getEntryPrice());
        trade.setExitPrice(request.getExitPrice());
        trade.setEntryTime(request.getEntryTime());
        trade.setExitTime(request.getExitTime());
        trade.setPnl(request.getPnl());

        trades.add(trade);

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
    public List<Trade> getAllTrades(){
        return trades;
    }

    public Trade getTradeById(Integer id){
        for(Trade trade : trades){
            if(trade.getId().equals(id)){
                return trade;
            }
        }
        throw new TradeNotFoundException(id);
    }

    public  void deleteTrade(Integer id) {

        Iterator<Trade> iterator = trades.iterator();
        while(iterator.hasNext()) {
            Trade trade = iterator.next();
            if(trade.getId().equals(id)) {
                iterator.remove();
                return;
            }
        }
        throw new TradeNotFoundException(id);
    }

    public Trade updateTrade(Integer id, Trade updatedTrade) {

        for( Trade trade : trades) {
            if(trade.getId().equals(id)) {
                trade.setSymbol(updatedTrade.getSymbol());
                trade.setSide(updatedTrade.getSide());
                trade.setQuantity(updatedTrade.getQuantity());
                trade.setEntryPrice(updatedTrade.getEntryPrice());
                trade.setExitPrice(updatedTrade.getExitPrice());
                trade.setEntryTime(updatedTrade.getEntryTime());
                trade.setExitTime(updatedTrade.getExitTime());
                trade.setPnl(updatedTrade.getPnl());

                return trade;
            }
        }
        throw new TradeNotFoundException(id);
    }
}
