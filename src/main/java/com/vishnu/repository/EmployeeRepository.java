package com.vishnu.repository;


import org.springframework.data.jpa.repository.JpaRepository;

import com.vishnu.entity.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, Long> {
}
