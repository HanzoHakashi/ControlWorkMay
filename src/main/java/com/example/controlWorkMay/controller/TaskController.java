package com.example.controlWorkMay.controller;

import com.example.controlWorkMay.dto.TaskDto;
import com.example.controlWorkMay.entity.Task;
import com.example.controlWorkMay.mapper.TaskMapper;
import com.example.controlWorkMay.services.TaskService;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.security.Principal;
import java.util.List;

@Controller
@AllArgsConstructor
public class TaskController {
    private final TaskService taskService;

    @GetMapping("/")
    public String getProducts(@RequestParam(defaultValue = "0") int page,
                              @RequestParam(defaultValue = "10") int size, ModelMap model, Principal principal) {
        Page<Task> list = taskService.getAllTasks(page, size);
        Page<TaskDto> tasks = list.map(TaskMapper::fromTask);

        model.put("tasks", tasks);
        boolean isAuthenticated = principal != null;
        model.addAttribute("isAuthenticated", isAuthenticated);

        return "task-list";
    }
}

