package com.github.maykonoliveira.graphqlandrestapi.api.graphql.specification;

import graphql.schema.DataFetchingFieldSelectionSet;
import org.springframework.data.jpa.domain.Specification;

import javax.persistence.criteria.Fetch;
import javax.persistence.criteria.Join;
import javax.persistence.criteria.JoinType;
import java.util.List;

public final class SpecificationUtils {
  private SpecificationUtils() {}

  public static <T> Specification<T> createSpecificationByFieldSelection(
      DataFetchingFieldSelectionSet fieldSelectionSet, List<String> attributes) {
    Specification<T> spec = Specification.where(null);

    for (String attribute : attributes) {
      if (fieldSelectionSet.contains(attribute)) spec = spec.and(fetch(attribute));
    }

    return spec;
  }

  public static <T> Specification<T> byId(Integer id) {
    return (root, query, builder) -> builder.equal(root.get("id"), id);
  }

  public static <T, U> Specification<T> fetch(String attribute) {
    return (root, query, builder) -> {
      Fetch<T, U> f = root.fetch(attribute, JoinType.INNER);
      var join = (Join<T, U>) f;
      return join.getOn();
    };
  }
}
