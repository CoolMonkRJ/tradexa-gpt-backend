package com.tradexa.gpt.service;

import com.tradexa.gpt.dto.UploadResponseDTO;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

@Service
public class FileService {

    public UploadResponseDTO uploadFile(MultipartFile file){
        String fileName = file.getOriginalFilename();
        long fileSize = file.getSize();

        return new UploadResponseDTO(
                fileName,
                fileSize,
                "File uploaded successfully"
        );
    }
}
