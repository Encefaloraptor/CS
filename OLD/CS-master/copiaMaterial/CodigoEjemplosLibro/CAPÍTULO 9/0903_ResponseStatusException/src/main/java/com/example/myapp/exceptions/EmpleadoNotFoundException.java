package com.example.myapp.exceptions;

//@ResponseStatus(HttpStatus.NOT_FOUND)
public class EmpleadoNotFoundException extends RuntimeException {

    // private static final long serialVersionUID = 43876691117560211L;

    public EmpleadoNotFoundException(Long id) {
        super("No se puede encontrar empleado con ID: " + id);
    }
}
