package com.projeto.motivosparabeber.test;

import com.projeto.motivosparabeber.api.config.JaxRsConfig;
import com.projeto.motivosparabeber.api.mapper.MotivoMapper;
import com.projeto.motivosparabeber.api.model.Motivo;
import com.projeto.motivosparabeber.api.repository.MotivoRepository;
import com.projeto.motivosparabeber.api.service.MotivoService;
import jakarta.inject.Inject;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import jakarta.persistence.TypedQuery;
import org.glassfish.grizzly.http.server.HttpServer;
import org.glassfish.jersey.grizzly2.httpserver.GrizzlyHttpServerFactory;

import java.io.IOException;
import java.net.URI;
import java.time.LocalDate;

public class Test {

    private static final String BASE_URI = "http://localhost:8080/api/";



    public static void main(String[] args) throws IOException {


//        JaxRsConfig jaxConfig = new JaxRsConfig();
//        HttpServer server = GrizzlyHttpServerFactory.createHttpServer(URI.create(BASE_URI), jaxConfig);
//
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("motivos_para_beber");
        MotivoRepository rep = new MotivoRepository(emf);
        MotivoService service = new MotivoService(rep, new MotivoMapper());
//
//        System.out.println("Servidor JAX-RS rodando em " + BASE_URI);
//        System.out.println("Pressione Ctrl+C para encerrar...");




//        System.in.read();
//        server.shutdownNow();

    }
}
