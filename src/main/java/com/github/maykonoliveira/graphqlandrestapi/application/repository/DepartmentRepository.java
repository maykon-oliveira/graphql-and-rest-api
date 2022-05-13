package com.github.maykonoliveira.graphqlandrestapi.application.repository;

import com.github.maykonoliveira.graphqlandrestapi.application.domain.Department;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface DepartmentRepository extends JpaRepository<Department, Long>, JpaSpecificationExecutor<Department> {
}
