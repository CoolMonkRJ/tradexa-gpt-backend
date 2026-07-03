package com.tradexa.gpt.service;

import com.tradexa.gpt.dto.TradeRequest;
import com.tradexa.gpt.dto.TradeResponse;
import com.tradexa.gpt.entity.Trade;
import com.tradexa.gpt.exception.TradeNotFoundException;
import com.tradexa.gpt.mapper.TradeMapper;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Iterator;

@Service
public class TradeService {

    private final List<Trade> trades = new ArrayList<>();
    private int nextId = 1;


    public TradeResponse addTrade(TradeRequest request){
        Trade trade =  TradeMapper.toEntity(request);
        trade.setId(nextId++);
        trades.add(trade);
        return TradeMapper.toResponse(trade);
    }
    public List<TradeResponse> getAllTrades() {
        List<TradeResponse> responses = new ArrayList<>();

        for (Trade trade : trades) {
            responses.add(TradeMapper.toResponse(trade));
        }
        return responses;
    }

    public TradeResponse getTradeById(Integer id) {

        for (Trade trade : trades) {

            if (trade.getId().equals(id)) {
                return TradeMapper.toResponse(trade);
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
    public TradeResponse updateTrade(Integer id, TradeRequest request) {

        for (Trade trade : trades) {

            if (trade.getId().equals(id)) {

                trade.setSymbol(request.getSymbol());
                trade.setSide(request.getSide());
                trade.setQuantity(request.getQuantity());
                trade.setEntryPrice(request.getEntryPrice());
                trade.setExitPrice(request.getExitPrice());
                trade.setEntryTime(request.getEntryTime());
                trade.setExitTime(request.getExitTime());
                trade.setPnl(request.getPnl());

                return TradeMapper.toResponse(trade);
            }
        }

        throw new TradeNotFoundException(id);
    }

}
