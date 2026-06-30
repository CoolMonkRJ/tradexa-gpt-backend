package com.tradexa.gpt.controller;

import com.tradexa.gpt.dto.UploadResponseDTO;
import com.tradexa.gpt.service.FileService;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

@RestController
@RequestMapping("/api/v1/files")
public class FileController {

    private final FileService fileService;
    public FileController(FileService fileService){
        this.fileService=fileService;
    }

    @PostMapping("/upload")
    public UploadResponseDTO upload(
            @RequestParam("file")MultipartFile file
    ){
        return fileService.uploadFile(file);
    }
}
