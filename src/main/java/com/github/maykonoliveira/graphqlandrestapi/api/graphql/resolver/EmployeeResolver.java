package com.github.maykonoliveira.graphqlandrestapi.api.graphql.resolver;

import com.github.maykonoliveira.graphqlandrestapi.application.domain.Employee;
import com.github.maykonoliveira.graphqlandrestapi.application.repository.EmployeeRepository;
import graphql.kickstart.tools.GraphQLQueryResolver;
import graphql.schema.DataFetchingEnvironment;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class EmployeeResolver implements GraphQLQueryResolver {
  private final EmployeeRepository employeeRepository;

  public EmployeeResolver(EmployeeRepository employeeRepository) {
    this.employeeRepository = employeeRepository;
  }

  public List<Employee> employees(DataFetchingEnvironment environment) {
    return employeeRepository.findAll();
  }
}
