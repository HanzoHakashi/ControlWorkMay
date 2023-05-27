package com.example.controlWorkMay.services;

import com.example.controlWorkMay.repositories.WorkLogRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class WorkLogService {
    private final WorkLogRepository workLogRepository;

}
