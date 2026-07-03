package com.tradexa.gpt.service;

import com.tradexa.gpt.dto.UploadResponseDTO;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import com.tradexa.gpt.entity.Trade;
import com.tradexa.gpt.parser.CsvTradeParser;

import java.util.List;

@Service
public class FileService {
    private final CsvTradeParser csvTradeParser;

    public FileService(CsvTradeParser csvTradeParser) {
        this.csvTradeParser=csvTradeParser;
    }

    public UploadResponseDTO uploadFile(MultipartFile file) {
        List<Trade> trades = csvTradeParser.parse(file);
        UploadResponseDTO response = new UploadResponseDTO();

        response.setFileName(file.getOriginalFilename());
        response.setFileType(file.getContentType());
        response.setFileSize(file.getSize());

        return response;
    }
}