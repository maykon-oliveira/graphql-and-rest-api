package com.github.maykonoliveira.graphqlandrestapi.application.repository;

import com.github.maykonoliveira.graphqlandrestapi.application.domain.Organization;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface OrganizationRepository
    extends JpaRepository<Organization, Long>, JpaSpecificationExecutor<Organization> {}
