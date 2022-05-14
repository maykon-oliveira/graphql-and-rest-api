package com.github.maykonoliveira.graphqlandrestapi.application.domain;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import javax.persistence.*;
import java.util.Set;

@Entity
@NamedEntityGraph(
    name = "department-entity-graph",
    attributeNodes = {
      @NamedAttributeNode("organization"),
      @NamedAttributeNode("employees"),
    })
public class Department {
  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private Long id;

  private String name;

  @JsonManagedReference
  @OneToMany(mappedBy = "department")
  private Set<Employee> employees;

  @ManyToOne(fetch = FetchType.LAZY)
  private Organization organization;

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public Set<Employee> getEmployees() {
    return employees;
  }

  public void setEmployees(Set<Employee> employees) {
    this.employees = employees;
  }

  public Organization getOrganization() {
    return organization;
  }

  public void setOrganization(Organization organization) {
    this.organization = organization;
  }
}
