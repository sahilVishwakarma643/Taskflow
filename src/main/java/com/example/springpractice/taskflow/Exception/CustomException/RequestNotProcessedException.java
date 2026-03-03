package com.example.springpractice.taskflow.Exception.CustomException;

public class RequestNotProcessedException extends RuntimeException {

    public RequestNotProcessedException(String msg)
    {
super(msg);
    }
    
}
