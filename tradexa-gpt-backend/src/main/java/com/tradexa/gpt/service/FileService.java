package com.tradexa.gpt.service;

import com.tradexa.gpt.dto.UploadResponseDTO;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

@Service
public class FileService {

    public UploadResponseDTO uploadFile(MultipartFile file) {

        UploadResponseDTO response = new UploadResponseDTO();

        response.setFileName(file.getOriginalFilename());
        response.setFileType(file.getContentType());
        response.setFileSize(file.getSize());

        return response;
    }
}