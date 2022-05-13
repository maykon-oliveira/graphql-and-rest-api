package com.github.maykonoliveira.graphqlandrestapi.api.graphql.resolver;

import com.github.maykonoliveira.graphqlandrestapi.api.graphql.specification.SpecificationUtils;
import com.github.maykonoliveira.graphqlandrestapi.application.domain.Organization;
import com.github.maykonoliveira.graphqlandrestapi.application.repository.OrganizationRepository;
import graphql.kickstart.tools.GraphQLQueryResolver;
import graphql.schema.DataFetchingEnvironment;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.List;
import java.util.NoSuchElementException;

@Component
public class OrganizationResolver implements GraphQLQueryResolver {
  private final OrganizationRepository organizationRepository;
  private final List<String> FETCHABLE_ATTRIBUTES = Arrays.asList("employees", "organization");

  public OrganizationResolver(OrganizationRepository organizationRepository) {
    this.organizationRepository = organizationRepository;
  }

  public Organization organization(Integer id, DataFetchingEnvironment environment) {
    var spec =
        SpecificationUtils.<Organization>createSpecificationByFieldSelection(
                environment.getSelectionSet(), FETCHABLE_ATTRIBUTES)
            .and(SpecificationUtils.byId(id));

    return organizationRepository.findOne(spec).orElseThrow(NoSuchElementException::new);
  }

  public List<Organization> organizations(DataFetchingEnvironment environment) {
    var spec =
        SpecificationUtils.<Organization>createSpecificationByFieldSelection(
            environment.getSelectionSet(), FETCHABLE_ATTRIBUTES);

    return organizationRepository.findAll(spec);
  }
}
