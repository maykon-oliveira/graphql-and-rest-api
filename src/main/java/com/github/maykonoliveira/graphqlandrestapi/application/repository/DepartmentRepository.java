package com.github.maykonoliveira.graphqlandrestapi.application.repository;

import com.github.maykonoliveira.graphqlandrestapi.application.domain.Department;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import java.util.List;

public interface DepartmentRepository
    extends JpaRepository<Department, Long>, JpaSpecificationExecutor<Department> {

  @Override
  @EntityGraph(value = "department-entity-graph", type = EntityGraph.EntityGraphType.LOAD)
  List<Department> findAll();
}
