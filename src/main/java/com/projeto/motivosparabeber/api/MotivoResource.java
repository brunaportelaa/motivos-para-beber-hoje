package com.projeto.motivosparabeber.api;

import com.projeto.motivosparabeber.api.dto.MotivoRequest;
import com.projeto.motivosparabeber.api.dto.MotivoResponse;
import com.projeto.motivosparabeber.api.mapper.MotivoMapper;
import com.projeto.motivosparabeber.api.model.Motivo;
import com.projeto.motivosparabeber.api.service.MotivoService;
import jakarta.inject.Inject;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.*;

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
        return Response.ok(mapper.toResponse(motivo)).build();
    }

    @GET
    @Path("/aleatorio")
    public Response buscarMotivoAleatorioDeHoje() {
        Motivo motivoAleatorio = service.buscarMotivoAleatorioDeHoje();
        return Response.ok(mapper.toResponse(motivoAleatorio)).build();
    }

    @POST
    public Response criar(MotivoRequest motivoRequest, @Context UriInfo uriInfo) {
        Motivo novoMotivo = service.criar(motivoRequest);
        UriBuilder builder = uriInfo.getAbsolutePathBuilder();
        builder.path(Long.toString(novoMotivo.getId()));
        return Response.created(builder.build()).build();
    }

    @POST
    @Path("/lote")
    public Response criarEmLote(List<MotivoRequest> motivosRequests) {
        service.criarEmLote(motivosRequests);
        return Response.status(Response.Status.CREATED).build();
    }

    @DELETE
    @Path("{id}")
    public Response deletar(@PathParam("id") Long id) {
        service.deletarPorId(id);
        return Response.noContent().build();
    }
}
