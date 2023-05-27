package com.example.controlWorkMay.repositories;

import com.example.controlWorkMay.entity.Task;
import com.example.controlWorkMay.entity.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

public interface TaskRepository extends CrudRepository<Task, Long> {
    Page<Task> findAll(Pageable pageable);
    @Query("SELECT t FROM Task t WHERE t.developerId = :developer")
    Page<Task> getTasksByDeveloper(@Param("developer") User developer, Pageable pageable);



}
