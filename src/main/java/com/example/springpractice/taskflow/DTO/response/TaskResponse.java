package com.example.springpractice.taskflow.DTO.response;

import java.time.LocalDateTime;

import com.example.springpractice.taskflow.Enums.TaskStatus;

public class TaskResponse {
    Long id;
    String title;
    TaskStatus status;
    String description;
    private LocalDateTime updatedAt;
    

    
    public TaskResponse(Long id, String title, TaskStatus status,String description, LocalDateTime updatedAt) {
        this.id = id;
        this.title = title;
        this.status = status;
        this.description=description;
        this.updatedAt=updatedAt;

    }

    public TaskResponse() {
    }


    public Long getId() {
        return id;
    }


    public void setId(Long id) {
        this.id = id;
    }


    public String getTitle() {
        return title;
    }


    public void setTitle(String title) {
        this.title = title;
    }


    public TaskStatus getStatus() {
        return status;
    }


    public void setStatus(TaskStatus status) {
        this.status = status;
    }

    public String getDescription() {
        return description;
    }

    

    public void setDescription(String description) {
        this.description = description;
    }

    public LocalDateTime getUpdatedAt() {
        return updatedAt;
    }
}
