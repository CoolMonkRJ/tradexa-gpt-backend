package com.tradexa.gpt.common;

import java.time.LocalDateTime;

public class ApiResponse<T> {

    private  boolean success;
    private String message;
    private T data;
    private LocalDateTime timestamp;

    public ApiResponse(){
    }

    public ApiResponse(boolean success ,
                       String message ,
                       T data,
                       LocalDateTime timestamp){
        this.success=success;
        this.message=message;
        this.data=data;
        this.timestamp=timestamp;
    }

    public boolean isSuccess(){
        return  success;
    }
    public String getMessage(){
        return  message;
    }
    public T getData(){
        return data;
    }
    public  LocalDateTime getTimestamp(){
        return timestamp;
    }

    public  void setSuccess(boolean success){
        this.success=success;
    }
    public void setMessage(String message){
        this.message=message;
    }
    public  void setData(T data){
        this.data=data;
    }
    public  void setTimestamp(LocalDateTime timestamp){
        this.timestamp=timestamp;
    }
}
