package com.projeto.motivosparabeber.api.util;

public enum Categoria {
    ANIVERSARIO(1),
    EVENTO_HISTORICO(2),
    RELEVANTE(3),
    INUTIL(4);

    private int categoria;

    Categoria(int categoria) {
        this.categoria = categoria;
    }

    public int getCategoria() {
        return categoria;
    }
}
