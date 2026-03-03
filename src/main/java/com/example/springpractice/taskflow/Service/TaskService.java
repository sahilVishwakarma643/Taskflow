package com.example.springpractice.taskflow.Service;

import com.example.springpractice.taskflow.DTO.request.TaskCreateRequest;
import com.example.springpractice.taskflow.DTO.request.TaskUpdateRequest;
import com.example.springpractice.taskflow.DTO.response.TaskResponse;
import com.example.springpractice.taskflow.Enums.TaskStatus;

import java.util.List;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;


public interface TaskService {

    List<TaskResponse> getAllTasks();

    TaskResponse getTasksById(Long id);

    TaskResponse createTask(TaskCreateRequest request);

    TaskResponse updateTask(TaskUpdateRequest uRequest,Long id);

    void delTask(Long id);

     Page<TaskResponse> getTasks(Pageable pageable,TaskStatus status, String search);




    
}
