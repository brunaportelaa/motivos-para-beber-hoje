package com.projeto.motivosparabeber.api.mapper;

import com.projeto.motivosparabeber.api.dto.ErrorResponse;
import com.projeto.motivosparabeber.api.exception.DescriptionTooLongException;
import com.projeto.motivosparabeber.api.exception.NotFoundException;
import jakarta.ws.rs.core.Response;
import jakarta.ws.rs.ext.ExceptionMapper;
import jakarta.ws.rs.ext.Provider;

@Provider
public class DescriptionTooLongExceptionMapper implements ExceptionMapper<DescriptionTooLongException> {

    @Override
    public Response toResponse(DescriptionTooLongException e) {
        return Response
                .status(Response.Status.BAD_REQUEST)
                .entity(new ErrorResponse("Descrição precisa ter menos que 275 caracteres.", e.getMessage()))
                .build();
    }
}
