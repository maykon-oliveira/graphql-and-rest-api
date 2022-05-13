package com.github.maykonoliveira.graphqlandrestapi.application.repository;

import com.github.maykonoliveira.graphqlandrestapi.application.domain.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeRepository extends JpaRepository<Employee, Long> {
}
