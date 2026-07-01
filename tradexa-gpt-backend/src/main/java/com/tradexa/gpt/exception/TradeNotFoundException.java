package com.tradexa.gpt.exception;

public class TradeNotFoundException  extends  RuntimeException{

    public  TradeNotFoundException(Integer id){
        super("Trade with id "+id +" not found");
    }
}
