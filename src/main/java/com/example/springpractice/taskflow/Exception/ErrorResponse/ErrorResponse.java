package com.example.springpractice.taskflow.Exception.ErrorResponse;

import java.time.LocalDateTime;

import org.springframework.stereotype.Component;

public class ErrorResponse {

    LocalDateTime timestamp;
    int status;
    String error;
    String path;
    String message;
    public ErrorResponse(LocalDateTime timestamp, int status, String error, String path, String message) {
        this.timestamp = timestamp;
        this.status = status;
        this.error = error;
        this.path = path;
        this.message = message;
    }
    public ErrorResponse() {
    }
    public LocalDateTime getTimestamp() {
        return timestamp;
    }
    public int getStatus() {
        return status;
    }
    public String getError() {
        return error;
    }
    public String getPath() {
        return path;
    }
    public String getMessage() {
        return message;
    }

}