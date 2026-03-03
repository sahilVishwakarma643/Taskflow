package com.example.springpractice.taskflow.Repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.springpractice.taskflow.Domain.Entity.Task;
import com.example.springpractice.taskflow.Enums.TaskStatus;

public interface TaskRepository extends JpaRepository<Task, Long> {
    Page<Task> findByStatus(TaskStatus status, Pageable pageable);
}
