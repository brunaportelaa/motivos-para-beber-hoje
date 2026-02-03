package com.projeto.motivosparabeber.api.mapper;

import com.projeto.motivosparabeber.api.dto.MotivoRequest;
import com.projeto.motivosparabeber.api.dto.MotivoResponse;
import com.projeto.motivosparabeber.api.model.Motivo;
import jakarta.inject.Singleton;

@Singleton
public class MotivoMapper {

    public Motivo toEntity(MotivoRequest req) {
        return new Motivo(
                req.getDataEfemeride(),
                req.getAno(),
                req.getTitulo(),
                req.getDescricao(),
                req.getCategoria(),
                req.getNivelBebedeira());
     }

     public MotivoResponse toResponse(Motivo motivo) {
        return new MotivoResponse(
                motivo.getId(),
                motivo.getDataEfemeride(),
                motivo.getAno(),
                motivo.getTitulo(),
                motivo.getDescricao(),
                motivo.getCategoria()
        );
    }
}
