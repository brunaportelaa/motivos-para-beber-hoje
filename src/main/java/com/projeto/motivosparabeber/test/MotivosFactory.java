package com.projeto.motivosparabeber.test;

import com.projeto.motivosparabeber.api.Motivo;
import com.projeto.motivosparabeber.api.util.Categoria;

import java.time.LocalDate;
import java.util.List;

public class MotivosFactory {

    public static List<Motivo> criarMotivos29DeJaneiro() {

        return List.of(

                new Motivo(
                        LocalDate.of(1954, 1, 29),
                        1954,
                        "Aniversário da Oprah",
                        "Se a Oprah nasceu hoje, é praticamente feriado moral. Uma mulher que distribuiu carros, dinheiro e traumas emocionais na TV merece um brinde. E se ela pode, a gente também pode.",
                        Categoria.ANIVERSARIO.getCategoria(),
                        4
                ),

                new Motivo(
                        LocalDate.of(2004, 1, 29),
                        2004,
                        "Dia da Visibilidade Trans",
                        "Dia de brindar à diversidade, à coragem de ser quem se é e à resistência diária. E nada simboliza melhor união e respeito do que juntar os amigos pra beber e conversar besteira.",
                        Categoria.RELEVANTE.getCategoria(),
                        3
                ),

                new Motivo(
                        LocalDate.of(1, 1, 29),
                        null,
                        "Dia do Salgadinho de Milho",
                        "Se existe um dia dedicado ao salgadinho que deixa a mão laranja, então claramente existe motivo pra abrir uma cerveja. Um não sobrevive sem o outro.",
                        Categoria.INUTIL.getCategoria(),
                        5
                ),

                new Motivo(
                        LocalDate.of(1, 1, 29),
                        null,
                        "Dia Nacional do Quebra-Cabeça",
                        "Nada representa melhor a vida adulta do que tentar encaixar peças que não fazem sentido. Beber ajuda a aceitar que a peça que falta talvez nunca apareça.",
                        Categoria.INUTIL.getCategoria(),
                        3
                ),

                new Motivo(
                        LocalDate.of(1959, 1, 29),
                        1959,
                        "Estreia de A Bela Adormecida",
                        "Um filme inteiro sobre alguém dormindo profundamente enquanto tudo se resolve sozinho. Se isso não é um convite pra beber e desligar o cérebro, nada mais é.",
                        Categoria.EVENTO_HISTORICO.getCategoria(),
                        4
                )
        );
    }
}
