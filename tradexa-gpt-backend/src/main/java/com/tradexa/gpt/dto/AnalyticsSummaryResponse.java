package com.tradexa.gpt.dto;

import java.math.BigDecimal;

public class AnalyticsSummaryResponse {

    private long totalTrades;
    private long winningTrades;
    private long losingTrades;

    private BigDecimal totalPnl;

    private double winRate;

    private BigDecimal averageProfit;
    private BigDecimal averageLoss;

    public long getTotalTrades() {
        return totalTrades;
    }

    public void setTotalTrades(long totalTrades) {
        this.totalTrades = totalTrades;
    }

    public long getWinningTrades() {
        return winningTrades;
    }

    public void setWinningTrades(long winningTrades) {
        this.winningTrades = winningTrades;
    }

    public long getLosingTrades() {
        return losingTrades;
    }

    public void setLosingTrades(long losingTrades) {
        this.losingTrades = losingTrades;
    }

    public BigDecimal getTotalPnl() {
        return totalPnl;
    }

    public void setTotalPnl(BigDecimal totalPnl) {
        this.totalPnl = totalPnl;
    }

    public double getWinRate() {
        return winRate;
    }

    public void setWinRate(double winRate) {
        this.winRate = winRate;
    }

    public BigDecimal getAverageProfit() {
        return averageProfit;
    }

    public void setAverageProfit(BigDecimal averageProfit) {
        this.averageProfit = averageProfit;
    }

    public BigDecimal getAverageLoss() {
        return averageLoss;
    }

    public void setAverageLoss(BigDecimal averageLoss) {
        this.averageLoss = averageLoss;
    }
}