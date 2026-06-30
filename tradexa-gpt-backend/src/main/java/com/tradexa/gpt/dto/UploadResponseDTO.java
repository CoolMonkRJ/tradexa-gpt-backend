package com.tradexa.gpt.dto;

public class UploadResponseDTO {
    private  String fileName;
    private long fileSize;
    private String message;

    public UploadResponseDTO(String fileName,
                             long fileSize,
                             String message){
        this.fileName=fileName;
        this.fileSize=fileSize;
        this.message=message;
    }

    public  String getFileName(){
        return fileName;
    }
    public long getFileSize(){
        return  fileSize;
    }
    public  String getMessage(){
        return message;
    }
}
