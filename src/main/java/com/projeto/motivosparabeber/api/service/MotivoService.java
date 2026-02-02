package com.projeto.motivosparabeber.api.service;

import com.projeto.motivosparabeber.api.exception.NotFoundException;
import com.projeto.motivosparabeber.api.model.Motivo;
import com.projeto.motivosparabeber.api.repository.MotivoRepository;
import jakarta.inject.Inject;
import jakarta.inject.Singleton;
import jakarta.persistence.EntityManagerFactory;

import java.util.List;
import java.util.function.Consumer;

@Singleton
public class MotivoService {

    private final MotivoRepository rep;

    @Inject
    public MotivoService(MotivoRepository rep) {
        this.rep = rep;
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

    public void criar(Motivo motivo){
        rep.criar(motivo);
    };

    public void criar(List<Motivo> motivos){
        for (Motivo motivo : motivos) {
            criar(motivo);
        }
    };

    public void deletarPorId(Long id){
        Motivo motivo = encontrarPorId(id);
        rep.deletarPorId(id);
    }
}
