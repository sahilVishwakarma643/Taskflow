package com.example.springpractice.taskflow.DTO.request;

import java.time.LocalDateTime;

import com.example.springpractice.taskflow.Enums.TaskActions;
import com.example.springpractice.taskflow.Enums.TaskStatus;

import jakarta.validation.constraints.Size;


public class TaskUpdateRequest {

    
    String title;
    TaskStatus status;

     @Size(min=3, max=100)
    String description;
    
    private TaskActions action;
    
    
    public String getTitle() {
        return title;
    }
    
    public String getDescription() {
        return description;
    }
    public TaskActions getAction() {
        return action;
    }
   



}
