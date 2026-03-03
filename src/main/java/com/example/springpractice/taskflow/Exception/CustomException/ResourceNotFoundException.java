package com.example.springpractice.taskflow.Exception.CustomException;

public class ResourceNotFoundException extends RuntimeException {
 
    public ResourceNotFoundException(String message)
    {
 super(message);
    }
    
}
