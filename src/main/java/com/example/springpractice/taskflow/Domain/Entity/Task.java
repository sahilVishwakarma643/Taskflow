package com.example.springpractice.taskflow.Domain.Entity;

import com.example.springpractice.taskflow.Enums.TaskStatus;
import com.example.springpractice.taskflow.Exception.CustomException.RequestNotProcessedException;

import java.time.LocalDateTime;

import jakarta.persistence.*;

@Entity
public class Task {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;
    String title;

    @Enumerated(EnumType.STRING)
    private TaskStatus status;
    String description;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;

    protected Task() {

    }

    public Task(String title, String description) {
        this.title = title;
        this.status = TaskStatus.TODO;
        this.description = description;
        this.createdAt = LocalDateTime.now();
        this.updatedAt = createdAt;
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

    public TaskStatus getStatus() {
        return status;
    }

    public String getDescription() {
        return description;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }
    public LocalDateTime getupdatedAt()
    {
        return updatedAt;
    }

    public void updateTitle(String title) {
        this.title = title;
        touch();
    }

    public void updateDescription(String description) {
        this.description = description;
        touch();
    }

    public void startTask() {
        if (status == TaskStatus.TODO) {
            status = TaskStatus.IN_PROGRESS;
            touch();
        } else {
            throw new RequestNotProcessedException("your Task is in invalid state to start");
        }

    }

    public void completedTask() {
        if (status == TaskStatus.IN_PROGRESS) {
            status = TaskStatus.DONE;
            touch();
        } else {
            throw new RequestNotProcessedException("your Task is in invalid state to complete");

        }
    }

    private void touch() {
        this.updatedAt = LocalDateTime.now();
    }

    public LocalDateTime getUpdatedAt() {
        return updatedAt;
    }

}
