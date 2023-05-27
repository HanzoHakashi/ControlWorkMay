package com.example.controlWorkMay.dto;

import com.example.controlWorkMay.entity.TaskStatus;
import com.example.controlWorkMay.entity.User;
import lombok.Builder;
import lombok.Data;

import java.util.Date;

@Builder
@Data
public class TaskDto {
    private String name;
    private Date creationDate;
    private User developerId;
    private TaskStatus status;

}
