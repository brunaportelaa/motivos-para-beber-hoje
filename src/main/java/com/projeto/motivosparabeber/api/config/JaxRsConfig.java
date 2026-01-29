package com.projeto.motivosparabeber.api.config;

import org.glassfish.jersey.server.ResourceConfig;

public class JaxRsConfig extends ResourceConfig {

    public JaxRsConfig() {
        packages("com.projeto.motivosparabeber.api");
        System.out.println("Configurações JAX-RS carregadas");
    }
}
