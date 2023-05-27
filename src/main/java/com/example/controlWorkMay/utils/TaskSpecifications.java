package com.example.controlWorkMay.utils;

import com.example.controlWorkMay.entity.Task;
import com.example.controlWorkMay.entity.TaskStatus;
import com.example.controlWorkMay.entity.User;
import org.springframework.data.jpa.domain.Specification;

public class TaskSpecifications {
    public static Specification<Task> nameContains(String name) {
        return (root, query, cb) -> cb.like(cb.lower(root.get("name")), "%" + name.toLowerCase() + "%");
    }

    public static Specification<Task> statusEquals(TaskStatus status) {
        return (root, query, cb) -> cb.equal(root.get("status"), status);
    }

    public static Specification<Task> developerEquals(User developer) {
        return (root, query, cb) -> cb.equal(root.get("developer"), developer);
    }
}
