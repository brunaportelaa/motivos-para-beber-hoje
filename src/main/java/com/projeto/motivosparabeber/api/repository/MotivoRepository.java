package com.projeto.motivosparabeber.api.repository;

import com.projeto.motivosparabeber.api.model.Motivo;
import jakarta.inject.Inject;
import jakarta.inject.Singleton;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.TypedQuery;

import java.util.List;

@Singleton
public class MotivoRepository {

    private EntityManagerFactory emf;

    @Inject
    public MotivoRepository(EntityManagerFactory emf) {
        this.emf = emf;
    }

    public List<Motivo> listar() {
         try (EntityManager em = emf.createEntityManager()) {
             TypedQuery<Motivo> query = em.createQuery("SELECT m FROM Motivo m", Motivo.class);
             return query.getResultList();
         } catch (Exception e) {
             throw new RuntimeException(e);
         }
    }

    public Motivo encontrarPorId(Long id) {
        try (EntityManager em = emf.createEntityManager()) {
            return em.find(Motivo.class, id);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public void criar(Motivo motivo){
        try (EntityManager em = emf.createEntityManager()) {
            EntityTransaction transaction = em.getTransaction();
            transaction.begin();
            em.persist(motivo);
            transaction.commit();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    };

    public void deletarPorId(Long id){
        try (EntityManager em = emf.createEntityManager()) {
            Motivo motivo = em.find(Motivo.class, id);
            EntityTransaction transaction = em.getTransaction();
            transaction.begin();
            em.remove(motivo);
            transaction.commit();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
