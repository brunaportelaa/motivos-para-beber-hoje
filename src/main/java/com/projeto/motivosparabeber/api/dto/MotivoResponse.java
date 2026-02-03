package com.projeto.motivosparabeber.api.dto;

import java.time.LocalDate;

public class MotivoResponse {
    private Long id;

    private LocalDate dataEfemeride;

    private Integer ano;

    private String titulo;

    private String descricao;

    private Integer categoria;

    public MotivoResponse(Long id, LocalDate dataEfemeride, Integer ano, String titulo, String descricao, Integer categoria) {
        this.id = id;
        this.dataEfemeride = dataEfemeride;
        this.ano = ano;
        this.titulo = titulo;
        this.descricao = descricao;
        this.categoria = categoria;
    }

    public MotivoResponse() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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
}
