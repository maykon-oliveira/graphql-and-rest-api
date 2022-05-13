package com.github.maykonoliveira.graphqlandrestapi.application.exception;

public class OrganizationNotFoundException extends RuntimeException {
    public OrganizationNotFoundException() {
        super("Organization not found");
    }
}
