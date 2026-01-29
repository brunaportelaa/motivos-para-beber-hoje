package com.projeto.motivosparabeber.api;

import com.projeto.motivosparabeber.api.config.JaxRsConfig;
import com.projeto.motivosparabeber.test.MotivosFactory;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import org.glassfish.grizzly.http.server.HttpServer;
import org.glassfish.jersey.grizzly2.httpserver.GrizzlyHttpServerFactory;

import java.io.IOException;
import java.net.URI;
import java.util.List;


public class Main {

    private static final String BASE_URI = "http://localhost:8080/api/";

    public static void main(String[] args) throws IOException {

        EntityManagerFactory emf = Persistence.createEntityManagerFactory("motivos_para_beber");

        JaxRsConfig jaxConfig = new JaxRsConfig();
        HttpServer server = GrizzlyHttpServerFactory.createHttpServer(URI.create(BASE_URI), jaxConfig);

        System.out.println("Servidor JAX-RS rodando em " + BASE_URI);
        System.out.println("Pressione Ctrl+C para encerrar...");

        System.in.read();
        server.shutdownNow();
        emf.close();



    }
}
