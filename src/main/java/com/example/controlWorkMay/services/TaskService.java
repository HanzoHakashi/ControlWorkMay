package com.example.controlWorkMay.services;

import com.example.controlWorkMay.entity.Task;
import com.example.controlWorkMay.repositories.TaskRepository;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@AllArgsConstructor
public class TaskService {
    private final TaskRepository taskRepository;
    public Page<Task> getAllTasks(int page, int size){
        Page<Task> tasks = taskRepository.findAll(PageRequest.of(page, size));
        return tasks;
    }
}
