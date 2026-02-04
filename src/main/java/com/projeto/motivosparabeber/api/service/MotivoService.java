package com.projeto.motivosparabeber.api.service;

import com.projeto.motivosparabeber.api.dto.MotivoRequest;
import com.projeto.motivosparabeber.api.exception.NotFoundException;
import com.projeto.motivosparabeber.api.mapper.MotivoMapper;
import com.projeto.motivosparabeber.api.model.Motivo;
import com.projeto.motivosparabeber.api.repository.MotivoRepository;
import com.projeto.motivosparabeber.api.validation.MotivoValidator;
import jakarta.inject.Inject;
import jakarta.inject.Singleton;
import jakarta.persistence.EntityManagerFactory;
import jakarta.validation.Valid;

import java.util.List;
import java.util.function.Consumer;
import java.util.stream.Collectors;

@Singleton
public class MotivoService {

    private final MotivoRepository rep;
    private final MotivoMapper mapper;

    @Inject
    public MotivoService(MotivoRepository rep, MotivoMapper mapper) {
        this.rep = rep;
        this.mapper = mapper;
    }

    public List<Motivo> listar() {
        return rep.listar();
    }

    public Motivo encontrarPorId(Long id) {
        Motivo motivoEncontrado = rep.encontrarPorId(id);
        if (motivoEncontrado == null) {
            throw new NotFoundException("Não encontramos o seu motivo para beber hoje.");
        }

        return motivoEncontrado;
    }

    public Motivo criar(@Valid MotivoRequest motivoRequest){
        Motivo motivo = mapper.toEntity(motivoRequest);
        MotivoValidator.validarNovoMotivo(motivo);
        return rep.criar(motivo);
    };

    public void criarEmLote(List<MotivoRequest> motivosRequests) {
        List<Motivo> motivos = motivosRequests.stream()
                .map(mapper::toEntity)
                .collect(Collectors.toList());

        motivos.forEach(MotivoValidator::validarNovoMotivo);
        rep.criarVarios(motivos);
    }

    public void deletarPorId(Long id){
        Motivo motivo = encontrarPorId(id);
        rep.deletarPorId(id);

    }


}
