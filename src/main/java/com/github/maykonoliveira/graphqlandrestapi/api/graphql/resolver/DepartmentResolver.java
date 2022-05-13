package com.github.maykonoliveira.graphqlandrestapi.api.graphql.resolver;

import com.github.maykonoliveira.graphqlandrestapi.api.graphql.specification.SpecificationUtils;
import com.github.maykonoliveira.graphqlandrestapi.application.domain.Department;
import com.github.maykonoliveira.graphqlandrestapi.application.repository.DepartmentRepository;
import graphql.kickstart.tools.GraphQLQueryResolver;
import graphql.schema.DataFetchingEnvironment;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.List;
import java.util.NoSuchElementException;

@Component
public class DepartmentResolver implements GraphQLQueryResolver {

  private final DepartmentRepository departmentRepository;
  private final List<String> FETCHABLE_ATTRIBUTES = Arrays.asList("employees", "organization");

  public DepartmentResolver(DepartmentRepository departmentRepository) {
    this.departmentRepository = departmentRepository;
  }

  public Department department(Integer id, DataFetchingEnvironment environment) {
    var spec =
        SpecificationUtils.<Department>createSpecificationByFieldSelection(
                environment.getSelectionSet(), FETCHABLE_ATTRIBUTES)
            .and(SpecificationUtils.byId(id));

    return departmentRepository.findOne(spec).orElseThrow(NoSuchElementException::new);
  }

  public List<Department> departments(DataFetchingEnvironment environment) {
    var spec =
        SpecificationUtils.<Department>createSpecificationByFieldSelection(
            environment.getSelectionSet(), FETCHABLE_ATTRIBUTES);

    return departmentRepository.findAll(spec);
  }
}
