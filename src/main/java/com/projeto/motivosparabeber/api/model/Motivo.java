package com.projeto.motivosparabeber.api.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;

import java.time.LocalDate;

@Entity
@Table(name = "motivos")
public class Motivo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "data")
    private LocalDate dataEfemeride;

    private Integer ano;

    @Column(nullable = false, length = 100)
    private String titulo;

    @Column(nullable = false, length = 255)
    private String descricao;

    @Column(nullable = false)
    private Integer categoria;

    @Column(name = "nivel_bebedeira")
    @Min(1)
    @Max(5)
    private Integer nivelBebedeira;

    public Motivo(LocalDate dataEfemeride, Integer ano, String titulo, String descricao, Integer categoria, Integer nivelBebedeira) {
        this.dataEfemeride = dataEfemeride;
        this.ano = ano;
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

    @Override
    public String toString() {
        return "\nMotivo{" +
                "id=" + id +
                "\ndataEfemeride=" + dataEfemeride +
                "\nano=" + ano +
                "\ntitulo='" + titulo + '\'' +
                "\ndescricao='" + descricao + '\'' +
                "\ncategoria=" + categoria +
                "\nnivelBebedeira=" + nivelBebedeira +
                "}\n";
    }
}
