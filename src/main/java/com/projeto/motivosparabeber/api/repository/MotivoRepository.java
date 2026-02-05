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

    public List<Motivo> listarPorData(int dia, int mes) {
        try (EntityManager em = emf.createEntityManager()) {
            TypedQuery<Motivo> query = em.createQuery(
                    "SELECT m FROM Motivo m\n" +
                    "WHERE DAY(m.dataEfemeride) = :dia\n" +
                    "AND MONTH(m.dataEfemeride) = :mes\n", Motivo.class);

            query.setParameter("dia", dia);
            query.setParameter("mes", mes);
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

    public Motivo criar(Motivo motivo){
        try (EntityManager em = emf.createEntityManager()) {
            EntityTransaction transaction = em.getTransaction();
            transaction.begin();
            em.persist(motivo);
            transaction.commit();
            return motivo;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    };

    public void criarVarios(List<Motivo> motivos) {
        EntityManager em = emf.createEntityManager();
        EntityTransaction transaction = em.getTransaction();
        try {
            transaction.begin();
            for (Motivo motivo : motivos) {
                em.persist(motivo);
            }
            transaction.commit();
        } catch (Exception e) {
            if (transaction.isActive()) {
                transaction.rollback();
            }
            throw new RuntimeException(e);
        }
    }

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
