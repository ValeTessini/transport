package com.vtessini.transport_backend.exception;

public class ResourceNotFoundException extends RuntimeException {

    public ResourceNotFoundException(String resourceName, Long id) {
        super(resourceName + " con id " + id + " no encontrado");
    }
}
