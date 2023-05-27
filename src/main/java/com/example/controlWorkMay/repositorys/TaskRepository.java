package com.example.controlWorkMay.repositorys;

import com.example.controlWorkMay.entity.Task;
import org.springframework.data.repository.CrudRepository;

public interface TaskRepository extends CrudRepository<Task, Long> {
}
