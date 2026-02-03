package com.projeto.motivosparabeber.api;

import com.projeto.motivosparabeber.api.dto.MotivoRequest;
import com.projeto.motivosparabeber.api.dto.MotivoResponse;
import com.projeto.motivosparabeber.api.mapper.MotivoMapper;
import com.projeto.motivosparabeber.api.model.Motivo;
import com.projeto.motivosparabeber.api.service.MotivoService;
import jakarta.inject.Inject;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

import java.util.List;
import java.util.stream.Collectors;

@Path("/motivos")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class MotivoResource {

    private final MotivoService service;

    private final MotivoMapper mapper;

    @Inject
    public MotivoResource(MotivoService service, MotivoMapper mapper) {
        this.service = service;
        this.mapper = mapper;
    }

    @GET
    public Response listar() {
        List<MotivoResponse> motivoList =
                service.listar()
                        .stream()
                        .map(mapper::toResponse)
                        .collect(Collectors.toList());
        return Response
                .ok(motivoList)
                .build();
    }

    @GET
    @Path("{id}")
    public Response encontrarPorId(@PathParam("id") Long id) {
        Motivo motivo = service.encontrarPorId(id);
        return Response.ok(motivo).build();
    }

    @POST
    public Response criar(List<MotivoRequest> motivos) {
        service.criar(motivos);
        return Response.noContent().build();
    }

    @DELETE
    @Path("{id}")
    public Response deletar(@PathParam("id") Long id) {
        service.deletarPorId(id);
        return Response.noContent().build();
    }
}
