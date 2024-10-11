package com.example.gestionaire_employe_v2.repository.impl;

import com.example.gestionaire_employe_v2.model.Application;
import com.example.gestionaire_employe_v2.repository.interfaces.ApplicationRepositoryInterface;
import com.example.gestionaire_employe_v2.util.JPAUtil;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;

public class ApplicationRepository implements ApplicationRepositoryInterface {

    @Override
    public void saveApplication(Application application){
        EntityManager entityManager = JPAUtil.getEntityManager();
        EntityTransaction transaction = entityManager.getTransaction();

        try {
            transaction.begin();
            entityManager.persist(application);
            transaction.commit();
        }catch (Exception e){
            if (transaction.isActive()){
                transaction.rollback();
            }
            e.printStackTrace();

        }finally {
            entityManager.close();
        }
    }
}
