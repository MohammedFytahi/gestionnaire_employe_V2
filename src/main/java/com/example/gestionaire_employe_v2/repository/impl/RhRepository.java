package com.example.gestionaire_employe_v2.repository.impl;

import com.example.gestionaire_employe_v2.model.Rh;
import com.example.gestionaire_employe_v2.repository.interfaces.RhRepositoryInterface;
import com.example.gestionaire_employe_v2.util.JPAUtil;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;

public class RhRepository implements RhRepositoryInterface {

    @Override
    public void ajouterRh(Rh rh) {
        if (rh.getUsername() == null || rh.getEmail() == null || rh.getPassword() == null) {
            throw new IllegalArgumentException("Les champs username, email et password ne doivent pas être null");
        }

        EntityManager entityManager = JPAUtil.getEntityManager();
        EntityTransaction transaction = entityManager.getTransaction();

        try {
            transaction.begin();
            entityManager.persist(rh);
            transaction.commit();
        } catch (Exception e) {
            if (transaction.isActive()) {
                transaction.rollback();
            }
            System.out.println("Erreur lors de l'ajout de RH : " + e.getMessage());
        } finally {
            entityManager.close();
        }
    }

}
