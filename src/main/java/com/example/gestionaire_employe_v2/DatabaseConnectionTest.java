package com.example.gestionaire_employe_v2;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class DatabaseConnectionTest {

    public static void main(String[] args) {

        EntityManagerFactory entityManagerFactory = null;
        EntityManager entityManager = null;

        try {

            entityManagerFactory = Persistence.createEntityManagerFactory("employe_management_v2");


            entityManager = entityManagerFactory.createEntityManager();


            entityManager.getTransaction().begin();
            System.out.println("Connexion réussie à la base de données !");
            entityManager.getTransaction().commit();

        } catch (Exception e) {

            System.err.println("La connexion a échoué : " + e.getMessage());
            e.printStackTrace();

        } finally {

            if (entityManager != null) {
                entityManager.close();
            }
            if (entityManagerFactory != null) {
                entityManagerFactory.close();
            }
        }
    }
}
