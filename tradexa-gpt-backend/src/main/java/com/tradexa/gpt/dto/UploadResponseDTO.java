package com.tradexa.gpt.dto;

public class UploadResponseDTO {
    private  String fileName;
    private long fileSize;
    private String fileType;

    public void setFileName(String fileName) {
        this.fileName =fileName;
    }

    public String getFileType() {
        return fileType;
    }

    public void setFileType(String fileType) {
        this.fileType=fileType;
    }

    public long getFileSize() {
        return fileSize;
    }

    public void setFileSize(long fileSize) {
        this.fileSize = fileSize;
    }
}
