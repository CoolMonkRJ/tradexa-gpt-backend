package com.tradexa.gpt.analytics;


import com.tradexa.gpt.dto.AnalyticsSummaryResponse;
import com.tradexa.gpt.entity.Trade;
import com.tradexa.gpt.repository.TradeRepository;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.List;

@Service
public class AnalyticsService {

    private final TradeRepository tradeRepository;

    public AnalyticsService(TradeRepository tradeRepository) {
        this.tradeRepository = tradeRepository;
    }

    public AnalyticsSummaryResponse getSummary() {

        List<Trade> trades = tradeRepository.findAll();

        long totalTrades = trades.size();
        long winningTrades = 0;
        long losingTrades = 0;

        BigDecimal totalPnl = BigDecimal.ZERO;
        BigDecimal totalProfit = BigDecimal.ZERO;
        BigDecimal totalLoss = BigDecimal.ZERO;

        for (Trade trade : trades) {

            BigDecimal pnl = trade.getPnl();

           totalPnl = totalPnl.add(pnl);

            // Handle null PnL
            if (pnl == null) {
                pnl = BigDecimal.ZERO;
            }


            // Winning Trade
            if (pnl.compareTo(BigDecimal.ZERO) > 0) {
                winningTrades++;
                totalProfit = totalProfit.add(pnl);
            }

            // Losing Trade
            else if (pnl.compareTo(BigDecimal.ZERO) < 0) {
                losingTrades++;
                totalLoss = totalLoss.add(pnl);
            }
        }

        // Win Rate
        double winRate = 0.0;

        if (totalTrades > 0) {
            winRate = (winningTrades * 100.0) / totalTrades;
        }

        // Average Profit
        BigDecimal averageProfit = BigDecimal.ZERO;

        if (winningTrades > 0) {
            averageProfit = totalProfit.divide(
                    BigDecimal.valueOf(winningTrades),
                    2,
                    RoundingMode.HALF_UP
            );
        }

        // Average Loss
        BigDecimal averageLoss = BigDecimal.ZERO;

        if (losingTrades > 0) {
            averageLoss = totalLoss.divide(
                    BigDecimal.valueOf(losingTrades),
                    2,
                    RoundingMode.HALF_UP
            );
        }

        AnalyticsSummaryResponse response = new AnalyticsSummaryResponse();

        response.setTotalTrades(totalTrades);
        response.setWinningTrades(winningTrades);
        response.setLosingTrades(losingTrades);
        response.setTotalPnL(totalPnl);
        response.setWinRate(winRate);
        response.setAverageProfit(averageProfit);
        response.setAverageLoss(averageLoss);

        return response;
    }
}