package com.projeto.motivosparabeber.api.mapper;

import com.projeto.motivosparabeber.api.exception.BusinessException;
import com.projeto.motivosparabeber.api.exception.NotFoundException;
import com.projeto.motivosparabeber.api.exception.ValidationException;
import jakarta.ws.rs.core.Response;
import jakarta.ws.rs.ext.ExceptionMapper;
import jakarta.ws.rs.ext.Provider;

@Provider
public class BusinessExceptionMapper implements ExceptionMapper<BusinessException> {

    @Override
    public Response toResponse(BusinessException e) {

        if (e instanceof NotFoundException) {
            return Response.status(Response.Status.NOT_FOUND).build();
        }

        if (e instanceof ValidationException) {
            return Response.status(Response.Status.BAD_REQUEST).build();
        }

        return Response.status(Response.Status.INTERNAL_SERVER_ERROR).build();
    }
}
