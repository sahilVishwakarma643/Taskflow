package com.example.springpractice.taskflow.DTO.request;

public class TaskDeleteRequest {

    Long id;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public TaskDeleteRequest() {
    }

    public TaskDeleteRequest(Long id) {
        this.id = id;
    }

    
}