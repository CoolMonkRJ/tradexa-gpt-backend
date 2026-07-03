package com.tradexa.gpt.validation;

import com.tradexa.gpt.dto.TradeRequest;

public class TradeValidator {
    public static void validate(TradeRequest request) {
        if(request.getSymbol()==null || request.getSymbol().isBlank()) {
            throw new IllegalArgumentException("Symbol cannot be empty ");
        }

        if (request.getQuantity() <= 0) {
            throw new IllegalArgumentException("Quantity must be greater than zero.");
        }

        if (request.getEntryPrice().signum() <= 0) {
            throw new IllegalArgumentException("Entry Price must be greater than zero.");
        }

        if (request.getExitPrice().signum() <= 0) {
            throw new IllegalArgumentException("Exit Price must be greater than zero.");
        }
    }
}
