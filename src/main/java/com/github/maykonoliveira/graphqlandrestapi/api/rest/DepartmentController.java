package com.github.maykonoliveira.graphqlandrestapi.api.rest;

import com.github.maykonoliveira.graphqlandrestapi.application.domain.Department;
import com.github.maykonoliveira.graphqlandrestapi.application.repository.DepartmentRepository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

import static com.github.maykonoliveira.graphqlandrestapi.api.Constants.API_VERSION;

@RestController
@RequestMapping(API_VERSION + "/departments")
public class DepartmentController {
  private final DepartmentRepository departmentRepository;

  public DepartmentController(DepartmentRepository departmentRepository) {
    this.departmentRepository = departmentRepository;
  }

  @GetMapping
  public List<Department> findAll() {
    return departmentRepository.findAll();
  }

  @GetMapping("{id}")
  public Department findById(@PathVariable Long id) {
    return departmentRepository.findById(id).get();
  }
}
