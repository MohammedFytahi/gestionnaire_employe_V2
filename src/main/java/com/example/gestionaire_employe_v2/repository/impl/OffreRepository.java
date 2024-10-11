package com.example.gestionaire_employe_v2.repository.impl;

import com.example.gestionaire_employe_v2.model.Offre;
import com.example.gestionaire_employe_v2.repository.interfaces.OffreRepositoryInterface;
import com.example.gestionaire_employe_v2.util.JPAUtil;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.TypedQuery;

import java.util.ArrayList;
import java.util.List;

public class OffreRepository implements OffreRepositoryInterface {

    @Override
    public void addOffre(Offre offre) {
        EntityManager entityManager = JPAUtil.getEntityManager();
        EntityTransaction transaction = entityManager.getTransaction();

        try {
            transaction.begin();
            System.out.println("Beginning transaction");

            entityManager.persist(offre);
            System.out.println("Offer persisted");

            transaction.commit();
            System.out.println("Transaction committed");
        } catch (Exception e) {
            System.out.println("Error occurred: " + e.getMessage());
            if (transaction.isActive()) {
                transaction.rollback();
                System.out.println("Transaction rolled back");
            }
            e.printStackTrace();  // Print detailed error information
        } finally {
            entityManager.close();
        }
    }


    @Override
    public List<Offre> findAll(){
        EntityManager entityManager = JPAUtil.getEntityManager();
        EntityTransaction transaction = entityManager.getTransaction();
        List<Offre> offres = new ArrayList<>();

        try {
            transaction.begin();
            TypedQuery<Offre> query = entityManager.createQuery("SELECT o FROM Offre o", Offre.class);
            offres = query.getResultList();
            transaction.commit();
        }catch (Exception e){
            if (transaction.isActive()){
                transaction.rollback();
            }
            e.printStackTrace();
        }finally {
            entityManager.close();
        }
        return offres;
    }
}
