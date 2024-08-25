package com.vishnu.repository;



import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.vishnu.entity.EmployeeTask;

public interface TaskRepository extends JpaRepository<EmployeeTask, Long> {
    List<EmployeeTask> findByEmployeeId(Long employeeId);
}
