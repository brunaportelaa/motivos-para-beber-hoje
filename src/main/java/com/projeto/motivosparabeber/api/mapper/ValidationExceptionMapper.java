package com.projeto.motivosparabeber.api.mapper;

import com.projeto.motivosparabeber.api.exception.NotFoundException;
import com.projeto.motivosparabeber.api.exception.ValidationException;
import jakarta.ws.rs.core.Response;
import jakarta.ws.rs.ext.ExceptionMapper;
import jakarta.ws.rs.ext.Provider;

@Provider
public class ValidationExceptionMapper implements ExceptionMapper<ValidationException> {

    @Override
    public Response toResponse(ValidationException e) {
        return Response.status(Response.Status.BAD_REQUEST).build();
    }
}
