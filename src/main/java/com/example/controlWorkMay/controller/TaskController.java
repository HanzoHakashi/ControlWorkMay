package com.example.controlWorkMay.controller;

import com.example.controlWorkMay.dto.TaskDto;
import com.example.controlWorkMay.entity.*;
import com.example.controlWorkMay.mapper.TaskMapper;
import com.example.controlWorkMay.services.TaskService;
import com.example.controlWorkMay.services.UserService;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.security.Principal;
import java.sql.Date;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
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

        model.put("tasks", list);
        boolean isAuthenticated = principal != null;
        model.addAttribute("isAuthenticated", isAuthenticated);

        if (isAuthenticated) {
            String username = principal.getName();
            User user = userService.getUserByUsername(username);
            boolean isManager = false;
            if (user != null && user.getRole() == UserRole.MANAGER) {
                isManager = true;
            }else if (user!= null && user.getRole() == UserRole.DEVELOPER ) {
                Page<Task> list2 = taskService.getTasksByDeveloper(user, page, size);;
                model.addAttribute("tasks", list2);
            }
            model.addAttribute("isManager", isManager);
        }

        return "task-list";
    }

    @GetMapping("/tasks/new")
    public String createTask( ModelMap model){
        List<User> developers = userService.findByRole(UserRole.DEVELOPER);
        model.addAttribute("developers", developers);
        return "task-create";
    }

    @PostMapping("/tasks/new")
    public String createTaskPost(TaskDto taskDto){
        taskDto.setCreationDate(Date.valueOf(LocalDate.now()));
        taskService.createTask(taskDto);
        return "redirect:/";
    }

    @GetMapping("/tasks/edit")
    public String editTask(@RequestParam("taskId") Long taskId, ModelMap model) {
        Task task = taskService.getTaskById(taskId);
        if (task == null) {
            return "redirect:/tasks";
        }
        List<TaskStatus> taskStatusList = new ArrayList<>();
        taskStatusList.add(TaskStatus.FAILED);
        switch (task.getStatus()) {
            case CREATED:
                taskStatusList.add(TaskStatus.IN_PROGRESS);
                taskStatusList.add(TaskStatus.CREATED);
                break;
            case IN_PROGRESS:
                taskStatusList.add(TaskStatus.COMPLETED);
                taskStatusList.add(TaskStatus.IN_PROGRESS);
                break;
            case COMPLETED:
                taskStatusList.clear();
                taskStatusList.add(TaskStatus.COMPLETED);
                break;
        }


        List<WorkLog> workLogs = taskService.getWorkLogsForTask(taskId);

        model.addAttribute("task", task);
        model.addAttribute("taskStatusList", taskStatusList);
        model.addAttribute("workLogs", workLogs);

        return "task-edit";
    }

    @PostMapping("/tasks/update")
    public String updateTask(@ModelAttribute("task") Task task,
                             @RequestParam("newLogDescription") String newLogDescription) {
        Task existingTask = taskService.getTaskById(task.getId());
        if (existingTask == null) {
            return "redirect:/";
        }



        existingTask.setStatus(task.getStatus());




        WorkLog newWorkLog = new WorkLog();
        newWorkLog.setTask(task);
        newWorkLog.setTime(Date.valueOf(LocalDate.now()));
        newWorkLog.setDescription(newLogDescription);
        newWorkLog.setTask(existingTask);
        taskService.createWorkLog(newWorkLog);

        taskService.updateTask(existingTask);

        return "redirect:/";
    }



}

