package com.tradexa.gpt.dto;

import com.tradexa.gpt.entity.TradeSide;
import jakarta.validation.constraints.*;

import java.math.BigDecimal;
import java.time.LocalDateTime;


public class TradeRequest {

    @NotBlank(message = "Symbol is required")
    private String symbol;
    @NotNull(message = "Trade side is required")
    private TradeSide side;
    @Positive(message = "Quantity must be greater than 0")
    private Integer quantity;
    @NotNull(message = "Entry price is required")
    @DecimalMin(value = "0.0",
    inclusive = false,
    message = "Entry price should be greater than 0")
    private BigDecimal entryPrice;
    @NotNull(message = "Exit price is required")
    @DecimalMin(value = "0.0",
    inclusive = false,
    message = "Exit price should be greater than 0")
    private BigDecimal exitPrice;
    @NotNull(message = "Entry time is required")
    private LocalDateTime entryTime;
    @NotNull(message = "Exit price is required")
    private LocalDateTime exitTime;
    @NotNull(message = "PnL is required")
    private BigDecimal pnl;


    public String getSymbol() {
        return symbol;
    }

    public void setSymbol(String symbol) {
        this.symbol = symbol;
    }

    public TradeSide getSide() {
        return side;
    }

    public void setSide(TradeSide side) {
        this.side = side;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }
    public BigDecimal getEntryPrice() {
        return entryPrice;
    }

    public void setEntryPrice(BigDecimal entryPrice) {
        this.entryPrice = entryPrice;
    }

    public BigDecimal getExitPrice() {
        return exitPrice;
    }

    public void setExitPrice(BigDecimal exitPrice) {
        this.exitPrice = exitPrice;
    }

    public LocalDateTime getEntryTime() {
        return entryTime;
    }

    public void setEntryTime(LocalDateTime entryTime) {
        this.entryTime = entryTime;
    }

    public LocalDateTime getExitTime() {
        return exitTime;
    }

    public void setExitTime(LocalDateTime exitTime) {
        this.exitTime = exitTime;
    }

    public BigDecimal getPnl() {
        return pnl;
    }

    public void setPnl(BigDecimal pnl) {
        this.pnl = pnl;
    }

}
