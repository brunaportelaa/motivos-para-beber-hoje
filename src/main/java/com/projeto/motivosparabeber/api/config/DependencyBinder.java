package com.projeto.motivosparabeber.api.config;

import com.projeto.motivosparabeber.api.mapper.MotivoMapper;
import com.projeto.motivosparabeber.api.repository.MotivoRepository;
import com.projeto.motivosparabeber.api.service.MotivoService;
import jakarta.inject.Singleton;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import org.glassfish.jersey.internal.inject.AbstractBinder;

public class DependencyBinder extends AbstractBinder {

    @Override
    protected void configure() {

        EntityManagerFactory emf = Persistence.createEntityManagerFactory("motivos_para_beber");

        bind(MotivoService.class)
                .to(MotivoService.class)
                .in(Singleton.class);

        bind(MotivoMapper.class)
                .to(MotivoMapper.class)
                .in(Singleton.class);

        bind(MotivoRepository.class)
                .to(MotivoRepository.class)
                .in(Singleton.class);

        bind(emf)
                .to(EntityManagerFactory.class)
                .in(Singleton.class);
    }
}
