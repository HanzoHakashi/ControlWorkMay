package com.example.controlWorkMay.services;

import com.example.controlWorkMay.dto.TaskDto;
import com.example.controlWorkMay.entity.Task;
import com.example.controlWorkMay.entity.User;
import com.example.controlWorkMay.entity.WorkLog;
import com.example.controlWorkMay.mapper.TaskMapper;
import com.example.controlWorkMay.repositories.TaskRepository;
import com.example.controlWorkMay.repositories.WorkLogRepository;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@AllArgsConstructor
public class TaskService {
    private final WorkLogRepository workLogRepository;
    private final TaskRepository taskRepository;
    public final TaskMapper taskMapper;
    public Page<Task> getAllTasks(int page, int size){
        Page<Task> tasks = taskRepository.findAll(PageRequest.of(page, size));
        return tasks;
    }
    public void createTask(TaskDto task){
        taskRepository.save(taskMapper.fromDto(task));
    }


    public Page<Task> getTasksByDeveloper(User developer, int page, int size) {
        Pageable pageable = PageRequest.of(page, size);
        Page<Task> tasks = taskRepository.getTasksByDeveloper(developer, pageable);
        return tasks;
    }

    public Task getTaskById(Long taskId) {
        return taskRepository.findById(taskId).orElse(null);
    }
    public void updateTask(Task task) {
        taskRepository.save(task);
    }
    public void createWorkLog(WorkLog workLog){
        workLogRepository.save(workLog);
    }

    public List<WorkLog> getWorkLogsForTask(Long taskId) {
        return workLogRepository.findByTaskId(taskId);
    }
}
