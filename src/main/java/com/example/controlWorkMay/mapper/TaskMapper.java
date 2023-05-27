package com.example.controlWorkMay.mapper;

import com.example.controlWorkMay.dto.TaskDto;
import com.example.controlWorkMay.entity.Task;
import org.springframework.stereotype.Component;

@Component
public class TaskMapper {
    public static TaskDto fromTask(Task task){
        return TaskDto.builder()
                .name(task.getName())
                .creationDate(task.getCreationDate())
                .developerId(task.getDeveloperId())
                .status(task.getStatus())
                .build();
    }

    public static Task fromDto(TaskDto task){
        return Task.builder()
                .name(task.getName())
                .creationDate(task.getCreationDate())
                .developerId(task.getDeveloperId())
                .status(task.getStatus())
                .build();
    }
}
