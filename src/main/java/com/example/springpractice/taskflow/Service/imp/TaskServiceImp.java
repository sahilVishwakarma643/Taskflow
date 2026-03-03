package com.example.springpractice.taskflow.Service.imp;

import com.example.springpractice.taskflow.DTO.request.TaskCreateRequest;
import com.example.springpractice.taskflow.DTO.request.TaskUpdateRequest;
import com.example.springpractice.taskflow.DTO.response.TaskResponse;
import com.example.springpractice.taskflow.Domain.Entity.Task;
import com.example.springpractice.taskflow.Enums.TaskStatus;
import com.example.springpractice.taskflow.Exception.CustomException.RequestNotProcessedException;
import com.example.springpractice.taskflow.Exception.CustomException.ResourceNotFoundException;
import com.example.springpractice.taskflow.Repository.TaskRepository;
import com.example.springpractice.taskflow.Service.TaskService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class TaskServiceImp implements TaskService {

    private final TaskRepository taskRepository;

    public TaskServiceImp(TaskRepository taskRepository) {
        this.taskRepository = taskRepository;
    }

    @Override
    public List<TaskResponse> getAllTasks() {
        List<Task> tasks = taskRepository.findAll();

        return tasks.stream()
                .map(this::mapToResponse)
                .collect(Collectors.toList());
    }

    @Override
    public TaskResponse getTasksById(Long id) {
        Task task = taskRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("task not Found"));
        return mapToResponse(task);
    }

    private TaskResponse mapToResponse(Task task) {

        return new TaskResponse(
                task.getId(),
                task.getTitle(),
                task.getStatus(),
                task.getDescription(),
                task.getupdatedAt());
    }

    @Override
    @Transactional
    public TaskResponse createTask(TaskCreateRequest request) {
        Task task = new Task(
                request.getTitle(),
                request.getDescription());
        Task savedTask = taskRepository.save(task);

        return mapToResponse(savedTask);

    }

    @Override
    @Transactional

    public TaskResponse updateTask(TaskUpdateRequest uRequest, Long id) {
        Task task = taskRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("task not Found"));

        if (uRequest.getTitle() != null) {
            task.updateTitle(uRequest.getTitle());
        }

        if (uRequest.getDescription() != null) {
            task.updateDescription(uRequest.getDescription());
        }

        if (uRequest.getAction() != null) {
            switch (uRequest.getAction()) {
                case START:
                    task.startTask();
                    break;
                case COMPLETE:
                    task.completedTask();
                    break;

            }
            
        }
            Task updtask = taskRepository.save(task);

            return mapToResponse(updtask);
        
    }

    @Override
    @Transactional
    public void delTask(Long id) {
        Task task = taskRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("task not Found this task"));

        if (task.getStatus() != TaskStatus.DONE) {
            taskRepository.delete(task);
        } else {
            throw new RequestNotProcessedException("Your Request cannot be Processed for this task");
        }

    }

    @Override
    public Page<TaskResponse> getTasks(Pageable pageable, TaskStatus status, String search) {
        if (status == null) {
            Page<Task> pages = taskRepository.findAll(pageable);
            return pages.map(this::mapToResponse);
        } else {
            Page<Task> pagesS = taskRepository.findByStatus(status, pageable);
            System.out.println("Filtering by status");
            return pagesS.map(this::mapToResponse);
        }

    }

}
