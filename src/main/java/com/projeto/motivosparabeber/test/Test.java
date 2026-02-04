package com.projeto.motivosparabeber.test;

import com.projeto.motivosparabeber.api.config.JaxRsConfig;
import org.glassfish.grizzly.http.server.HttpServer;
import org.glassfish.jersey.grizzly2.httpserver.GrizzlyHttpServerFactory;

import java.io.IOException;
import java.net.URI;

public class Test {

    private static final String BASE_URI = "http://localhost:8080/api/";

    public static void main(String[] args) throws IOException {

        JaxRsConfig jaxConfig = new JaxRsConfig();
        HttpServer server = GrizzlyHttpServerFactory.createHttpServer(URI.create(BASE_URI), jaxConfig);


        System.out.println("Servidor JAX-RS rodando em " + BASE_URI);
        System.out.println("Pressione Ctrl+C para encerrar...");

        System.in.read();
        server.shutdownNow();

    }
}
