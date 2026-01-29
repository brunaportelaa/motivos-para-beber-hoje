package com.projeto.motivosparabeber.test;

import com.projeto.motivosparabeber.api.Motivo;
import com.projeto.motivosparabeber.api.MotivoResource;
import com.projeto.motivosparabeber.api.config.JaxRsConfig;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;
import org.glassfish.grizzly.http.server.HttpServer;
import org.glassfish.jersey.grizzly2.httpserver.GrizzlyHttpServerFactory;

import java.io.IOException;
import java.net.URI;
import java.util.List;

public class Test {

    private static final String BASE_URI = "http://localhost:8080/api/";

    public static void main(String[] args) throws IOException {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("motivos_para_beber");

        MotivoResource motivoResource = new MotivoResource();

        List<Motivo> motivos = MotivosFactory.criarMotivos29DeJaneiro();

        JaxRsConfig jaxConfig = new JaxRsConfig();
        HttpServer server = GrizzlyHttpServerFactory.createHttpServer(URI.create(BASE_URI), jaxConfig);

        EntityManager em = emf.createEntityManager();

//        try {
//            EntityTransaction transaction = em.getTransaction();
//            transaction.begin();
//            em.persist(motivos.get(0));
//            transaction.commit();
//        } catch (Exception e) {
//            throw new RuntimeException(e);
//        }

        System.out.println(em.find(Motivo.class, 2).getTitulo());

        System.out.println("Servidor JAX-RS rodando em " + BASE_URI);
        System.out.println("Pressione Ctrl+C para encerrar...");

        System.in.read();
        server.shutdownNow();
        emf.close();

    }
}
