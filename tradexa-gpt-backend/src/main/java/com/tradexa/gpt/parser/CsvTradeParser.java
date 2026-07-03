package com.tradexa.gpt.parser;

import com.tradexa.gpt.entity.Trade;
import com.tradexa.gpt.entity.TradeSide;
import com.tradexa.gpt.exception.CsvParsingException;
import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVRecord;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.time.LocalDateTime;
import java.math.BigDecimal;

@Component
public class CsvTradeParser {

    public List<Trade> parse(MultipartFile file) {
        List<Trade> trades = new ArrayList<>();
        try{
            BufferedReader reader = new BufferedReader(
                    new InputStreamReader(file.getInputStream())
            );

            CSVParser csvParser= CSVFormat.DEFAULT.builder().setHeader()
                    .setSkipHeaderRecord(true)
                    .build()
                    .parse(reader);

            for(CSVRecord record : csvParser) {
                Trade trade = new Trade();
                trade.setSymbol(record.get("Symbol"));

                trade.setSide(TradeSide.valueOf(record.get("Side").toUpperCase()));
                trade.setQuantity(Integer.parseInt(record.get("Quantity")));
                trade.setEntryPrice(
                        new BigDecimal(record.get("EntryPrice"))
                );

                trade.setExitPrice(
                        new BigDecimal(record.get("ExitPrice"))
                );

                trade.setEntryTime(
                        LocalDateTime.parse(
                                record.get("EntryTime")
                        )
                );

                trade.setExitTime(
                        LocalDateTime.parse(
                                record.get("ExitTime")
                        )
                );

                trade.setPnl(
                        new BigDecimal(record.get("Pnl"))
                );

                trades.add(trade);
            }
        } catch (Exception e) {
            throw new CsvParsingException("Unable to parse CSV file");
        }
        return trades;
    }
}
