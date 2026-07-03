package com.tradexa.gpt.util;

import com.tradexa.gpt.entity.TradeSide;
import java.math.BigDecimal;
import java.time.LocalDateTime;

public class ParserUtil {

        public static String parseString(String value){

            if(value == null){
                return "";
            }

            return value.trim();
        }

        public static int parseInteger(String value){

            try{
                return Integer.parseInt(value.trim());
            }catch(Exception e){
                return 0;
            }

        }

        public static BigDecimal parseBigDecimal(String value){

            try{
                return new BigDecimal(value.trim());
            }catch(Exception e){
                return BigDecimal.ZERO;
            }

        }

        public static LocalDateTime parseDate(String value){

            try{
                return LocalDateTime.parse(value.trim());
            }catch(Exception e){
                return null;
            }

        }

        public static TradeSide parseTradeSide(String value){

            try{
                return TradeSide.valueOf(value.trim().toUpperCase());
            }catch(Exception e){
                return null;
            }

        }

    }

