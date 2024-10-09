package com.example.gestionaire_employe_v2.util;

import jakarta.persistence.*;


public class JPAUtil {

    private static EntityManagerFactory entityManagerFactory;

    static {
        try {
            System.out.println("Initializing JPA EntityManagerFactory...");
            entityManagerFactory = Persistence.createEntityManagerFactory("employe_management_v2");
            System.out.println("EntityManagerFactory created successfully.");
        } catch (Throwable ex) {
            ex.printStackTrace();
            throw new ExceptionInInitializerError(ex);
        }
    }


    public static EntityManager getEntityManager() {
        return entityManagerFactory.createEntityManager();
    }



    public static void shutdown() {
        if (entityManagerFactory != null) {
            entityManagerFactory.close();
        }
    }
}
