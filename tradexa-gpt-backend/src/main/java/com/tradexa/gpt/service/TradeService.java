package com.tradexa.gpt.service;

import com.tradexa.gpt.controller.TradeController;
import com.tradexa.gpt.entity.Trade;
import com.tradexa.gpt.exception.TradeNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Iterator;

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
