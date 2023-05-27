package com.example.controlWorkMay.controller;

import com.example.controlWorkMay.dto.TaskDto;
import com.example.controlWorkMay.entity.Task;
import com.example.controlWorkMay.entity.User;
import com.example.controlWorkMay.entity.UserRole;
import com.example.controlWorkMay.mapper.TaskMapper;
import com.example.controlWorkMay.services.TaskService;
import com.example.controlWorkMay.services.UserService;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.security.Principal;
import java.sql.Date;
import java.time.LocalDate;
import java.util.List;

@Controller
@AllArgsConstructor
public class TaskController {
    private final TaskService taskService;
    private final UserService userService;
    @GetMapping("/")
    public String getTasks(@RequestParam(defaultValue = "0") int page,
                           @RequestParam(defaultValue = "10") int size,
                           ModelMap model,
                           Principal principal) {
        Page<Task> list = taskService.getAllTasks(page, size);
        Page<TaskDto> tasks = list.map(TaskMapper::fromTask);

        model.put("tasks", tasks);
        boolean isAuthenticated = principal != null;
        model.addAttribute("isAuthenticated", isAuthenticated);

        if (isAuthenticated) {
            String username = principal.getName();
            User user = userService.getUserByUsername(username);
            boolean isManager = false;
            if (user != null && user.getRole() == UserRole.MANAGER) {
                isManager = true;
            }
            model.addAttribute("isManager", isManager);
        }

        return "task-list";
    }

    @GetMapping("/tasks/new")
    public String createTask( ModelMap model){
        List<User> developers = userService.findByRole(UserRole.DEVELOPER);
        System.out.println(developers.toString());
        model.addAttribute("developers", developers);
        return "task-create";
    }

    @PostMapping("/tasks/new")
    public String createTaskPost(TaskDto taskDto){
        taskDto.setCreationDate(Date.valueOf(LocalDate.now()));
        taskService.createTask(taskDto);
        return "redirect:/";
    }
}

