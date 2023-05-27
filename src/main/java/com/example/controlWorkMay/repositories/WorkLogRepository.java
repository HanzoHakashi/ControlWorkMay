package com.example.controlWorkMay.repositories;

import com.example.controlWorkMay.entity.WorkLog;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface WorkLogRepository extends CrudRepository<WorkLog,Long> {
    List<WorkLog> findByTaskId(Long task_id);
}
