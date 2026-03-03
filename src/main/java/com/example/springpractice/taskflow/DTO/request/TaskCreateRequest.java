package com.example.springpractice.taskflow.DTO.request;

import com.example.springpractice.taskflow.Enums.TaskStatus;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

public class TaskCreateRequest {
    @NotBlank
    @NotNull
    String title;
  

    @Size(min=3, max=100)
    String description;

    
    TaskStatus status;
    
    public String getTitle() { return title; }
    public String getDescription() { return description; }
    

    

    
}
