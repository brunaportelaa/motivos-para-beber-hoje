package com.projeto.motivosparabeber.test;

import com.projeto.motivosparabeber.api.model.Motivo;
import com.projeto.motivosparabeber.api.MotivoResource;
import com.projeto.motivosparabeber.api.config.JaxRsConfig;
import com.projeto.motivosparabeber.api.repository.MotivoRepository;
import com.projeto.motivosparabeber.api.util.Categoria;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import org.glassfish.grizzly.http.server.HttpServer;
import org.glassfish.jersey.grizzly2.httpserver.GrizzlyHttpServerFactory;

import java.io.IOException;
import java.net.URI;
import java.time.LocalDate;
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

        MotivoRepository repository = new MotivoRepository(emf);

        repository.deletarPorId(Long.parseLong("3"));
        repository.deletarPorId(Long.parseLong("4"));

        List<Motivo> motivosEncontrados = repository.listar();
        System.out.println("\n-----------LISTA DE MOTIVOS------------");
        motivosEncontrados.stream().forEach(System.out::println);


        System.out.println("Servidor JAX-RS rodando em " + BASE_URI);
        System.out.println("Pressione Ctrl+C para encerrar...");

        System.in.read();
        server.shutdownNow();
        emf.close();

    }
}
