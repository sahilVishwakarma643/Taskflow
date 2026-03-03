package com.example.springpractice.taskflow.Controller;

import com.example.springpractice.taskflow.DTO.request.TaskCreateRequest;
import com.example.springpractice.taskflow.DTO.request.TaskUpdateRequest;
import com.example.springpractice.taskflow.DTO.response.TaskResponse;
import com.example.springpractice.taskflow.Enums.TaskStatus;
import com.example.springpractice.taskflow.Service.TaskService;

import jakarta.validation.Valid;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/tasks")
public class TaskController {

    private final TaskService taskService;

    public TaskController(TaskService taskService) {
        this.taskService = taskService;
    }

    @GetMapping
    public List<TaskResponse> getAllTasks() {

        return taskService.getAllTasks();
    }

    @GetMapping("/{id}")
    public TaskResponse getTasksById(@PathVariable Long id) {
        return taskService.getTasksById(id);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)

    public TaskResponse createTask(
            @Valid @RequestBody TaskCreateRequest request) {
        return taskService.createTask(request);
    }

    @PatchMapping("/update/{id}")
    public TaskResponse updateTask(@Valid @RequestBody TaskUpdateRequest uRequest, @PathVariable Long id) {

        return taskService.updateTask(uRequest, id);
    }

    @DeleteMapping("/delete/{id}")
    public void deleteTask(@PathVariable Long id) {
        taskService.delTask(id);
    }

    @GetMapping("/page")
    public Page<TaskResponse> getResult(@RequestParam(required = false) TaskStatus status,
            @RequestParam(required = false) String search,
            @PageableDefault(size = 20) Pageable pageable) {
        return taskService.getTasks(pageable, status, search);
    }

   

}
