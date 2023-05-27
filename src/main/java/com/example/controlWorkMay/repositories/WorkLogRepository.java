package com.example.controlWorkMay.repositories;

import com.example.controlWorkMay.entity.WorkLog;
import org.springframework.data.repository.CrudRepository;

public interface WorkLogRepository extends CrudRepository<WorkLog,Long> {
}
