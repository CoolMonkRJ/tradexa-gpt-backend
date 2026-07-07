package com.tradexa.gpt.dto;

import java.math.BigDecimal;

public class SymbolAnalyticsResponse {

    private String symbol;
    private long totalTrades;
    private BigDecimal totalPnl;
    private double winRate;
    private long winningTrades;
    private long losingTrades;


    public String getSymbol() {
        return symbol;
    }

    public  void  setSymbol(String symbol) {
        this.symbol=symbol;
    }

    public long getTotalTrades() {
        return  totalTrades;
    }

    public void setTotalTrades(long totalTrades) {
        this.totalTrades=totalTrades;
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
}
