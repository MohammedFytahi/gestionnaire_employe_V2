package com.example.gestionaire_employe_v2.repository.impl;

import com.example.gestionaire_employe_v2.model.Employe;
import com.example.gestionaire_employe_v2.repository.interfaces.EmployeRepositoryInterface;
import com.example.gestionaire_employe_v2.util.JPAUtil;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;

public class EmployeRepository implements EmployeRepositoryInterface {

    @Override
    public void addEmploye(Employe employe){
        EntityManager entityManager = JPAUtil.getEntityManager();
        EntityTransaction transaction = entityManager.getTransaction();

        try {
            transaction.begin();
            entityManager.persist(employe);
            transaction.commit();
        }catch (Exception e){
            if (transaction.isActive()){
                transaction.rollback();
            }
            e.printStackTrace();
        } finally {
            entityManager.close();
        }
        }
    }

