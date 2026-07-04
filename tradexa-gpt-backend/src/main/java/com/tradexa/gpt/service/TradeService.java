package com.tradexa.gpt.service;

import com.tradexa.gpt.dto.TradeRequest;
import com.tradexa.gpt.dto.TradeResponse;
import com.tradexa.gpt.entity.Trade;
import com.tradexa.gpt.exception.TradeNotFoundException;
import com.tradexa.gpt.mapper.TradeMapper;
import com.tradexa.gpt.repository.TradeRepository;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class TradeService {

    private final TradeRepository tradeRepository;

    public TradeService(TradeRepository tradeRepository) {
        this.tradeRepository = tradeRepository;
    }


    public TradeResponse addTrade(TradeRequest request){
        Trade trade =  TradeMapper.toEntity(request);
        Trade savedTrade = tradeRepository.save(trade);
        return TradeMapper.toResponse(savedTrade);
    }
    public List<TradeResponse> getAllTrades() {
        List<Trade> trades = tradeRepository.findAll();
        return trades.stream().map(TradeMapper::toResponse).toList();
    }

    public TradeResponse getTradeById(Integer id) {

        Trade trade = tradeRepository.findById(id)
                .orElseThrow(() -> new TradeNotFoundException(id));

        return TradeMapper.toResponse(trade);
    }

    public void deleteTrade(Integer id) {

        if (!tradeRepository.existsById(id)) {
            throw new TradeNotFoundException(id);
        }

        tradeRepository.deleteById(id);
    }

    public TradeResponse updateTrade(Integer id, TradeRequest request) {

        Trade trade = tradeRepository.findById(id)
                .orElseThrow(() -> new TradeNotFoundException(id));

        trade.setSymbol(request.getSymbol());
        trade.setSide(request.getSide());
        trade.setQuantity(request.getQuantity());
        trade.setEntryPrice(request.getEntryPrice());
        trade.setExitPrice(request.getExitPrice());
        trade.setEntryTime(request.getEntryTime());
        trade.setExitTime(request.getExitTime());
        trade.setPnl(request.getPnl());

        Trade updatedTrade = tradeRepository.save(trade);

        return TradeMapper.toResponse(updatedTrade);
    }

}
