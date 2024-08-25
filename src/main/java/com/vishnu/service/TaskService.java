package com.vishnu.service;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.vishnu.entity.EmployeeTask;
import com.vishnu.repository.TaskRepository;

@Service
public class TaskService {

    @Autowired
    private TaskRepository taskRepository;

    public List<EmployeeTask> findAll() {
        return taskRepository.findAll();
    }

    public List<EmployeeTask> findByEmployeeId(Long employeeId) {
        return taskRepository.findByEmployeeId(employeeId);
    }

    public EmployeeTask save(EmployeeTask employeeTask) {
        return taskRepository.save(employeeTask);
    }

    public EmployeeTask findById(Long id) {
        return taskRepository.findById(id).orElse(null);
    }

    public void delete(Long id) {
        taskRepository.deleteById(id);
    }
}
