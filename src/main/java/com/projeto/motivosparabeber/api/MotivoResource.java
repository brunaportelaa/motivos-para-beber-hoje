package com.projeto.motivosparabeber.api;

import com.projeto.motivosparabeber.api.model.Motivo;
import com.projeto.motivosparabeber.api.service.MotivoService;
import jakarta.inject.Inject;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

import java.util.List;

@Path("/motivos")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class MotivoResource {

    private final MotivoService service;

    @Inject
    public MotivoResource(MotivoService service) {
        this.service = service;
    }

    @GET
    public Response listar() {
        List<Motivo> motivoList = service.listar();
        return Response.ok(motivoList).build();
    }

    @GET
    @Path("{id}")
    public Response encontrarPorId(@PathParam("id") Long id) {
        Motivo motivo = service.encontrarPorId(id);
        return Response.ok(motivo).build();
    }

    @POST
    public Response criar(List<Motivo> motivos) {
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
