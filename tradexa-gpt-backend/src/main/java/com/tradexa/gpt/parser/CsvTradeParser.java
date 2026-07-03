package com.tradexa.gpt.parser;

import com.tradexa.gpt.entity.Trade;
import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVRecord;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

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
                System.out.println(record);
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        return trades;
    }
}
