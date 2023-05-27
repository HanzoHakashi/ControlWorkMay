package com.example.controlWorkMay.repositories;

import com.example.controlWorkMay.entity.Task;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.CrudRepository;

public interface TaskRepository extends CrudRepository<Task, Long> {
    Page<Task> findAll(Pageable pageable);

}
