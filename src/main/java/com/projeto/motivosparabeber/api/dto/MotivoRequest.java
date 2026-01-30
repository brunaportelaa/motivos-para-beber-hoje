package com.projeto.motivosparabeber.api.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.Column;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.*;

import java.time.LocalDate;

public class MotivoRequest {

    @NotNull
    private LocalDate dataEfemeride;

    private Integer ano;

    @NotBlank
    @Size(min = 0, max = 100)
    private String titulo;

    @NotBlank
    @Size(min = 0, max = 255)
    private String descricao;

    @Min(1)
    @Max(4)
    @NotNull
    private Integer categoria;

    @NotNull
    private Integer nivelBebedeira;

    public MotivoRequest(LocalDate dataEfemeride, Integer ano, String titulo, String descricao, Integer categoria, Integer nivelBebedeira) {
        this.dataEfemeride = dataEfemeride;
        this.ano = ano;
        this.titulo = titulo;
        this.descricao = descricao;
        this.categoria = categoria;
        this.nivelBebedeira = nivelBebedeira;
    }

    public LocalDate getDataEfemeride() {
        return dataEfemeride;
    }

    public void setDataEfemeride(LocalDate dataEfemeride) {
        this.dataEfemeride = dataEfemeride;
    }

    public Integer getAno() {
        return ano;
    }

    public void setAno(Integer ano) {
        this.ano = ano;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public Integer getCategoria() {
        return categoria;
    }

    public void setCategoria(Integer categoria) {
        this.categoria = categoria;
    }

    public Integer getNivelBebedeira() {
        return nivelBebedeira;
    }

    public void setNivelBebedeira(Integer nivelBebedeira) {
        this.nivelBebedeira = nivelBebedeira;
    }
}
