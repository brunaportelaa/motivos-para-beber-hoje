package com.projeto.motivosparabeber;

import jakarta.persistence.*;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;

import java.time.LocalDate;

@Entity
@Table(name = "motivo")
public class Motivo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "data")
    private LocalDate dataEfemeride;

    @Column(nullable = false, length = 100)
    private String titulo;

    @Column(nullable = false, length = 100)
    private String descricao;

    @Column(nullable = false, length = 15)
    private String categoria;

    @Column(name = "nivel_bebedeira")
    @Min(1)
    @Max(5)
    private Integer nivelBebedeira;

    public Motivo(LocalDate dataEfemeride, String titulo, String descricao, String categoria, Integer nivelBebedeira) {
        this.dataEfemeride = dataEfemeride;
        this.titulo = titulo;
        this.descricao = descricao;
        this.categoria = categoria;
        this.nivelBebedeira = nivelBebedeira;
    }

    public Motivo() {
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

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public Integer getNivelBebedeira() {
        return nivelBebedeira;
    }

    public void setNivelBebedeira(Integer nivelBebedeira) {
        this.nivelBebedeira = nivelBebedeira;
    }
}
