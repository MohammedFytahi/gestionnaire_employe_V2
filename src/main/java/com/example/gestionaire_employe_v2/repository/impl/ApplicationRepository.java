package com.example.gestionaire_employe_v2.repository.impl;

import com.example.gestionaire_employe_v2.model.Application;
import com.example.gestionaire_employe_v2.repository.interfaces.ApplicationRepositoryInterface;
import com.example.gestionaire_employe_v2.util.JPAUtil;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.TypedQuery;

import java.util.List;

public class ApplicationRepository implements ApplicationRepositoryInterface {

    @Override
    public void saveApplication(Application application) {
        EntityManager entityManager = JPAUtil.getEntityManager();
        EntityTransaction transaction = entityManager.getTransaction();

        try {
            transaction.begin();
            entityManager.persist(application);
            transaction.commit();
        } catch (Exception e) {
            if (transaction.isActive()) {
                transaction.rollback();
            }
            e.printStackTrace();
        } finally {
            entityManager.close();
        }
    }

    @Override
    public List<Application> findApplicationsBySkills(List<String> skills) {
        EntityManager entityManager = JPAUtil.getEntityManager();
        try {
            String jpql = "SELECT DISTINCT a FROM Application a JOIN a.skills s WHERE s IN :skills";
            TypedQuery<Application> query = entityManager.createQuery(jpql, Application.class);
            query.setParameter("skills", skills);
            return query.getResultList();
        } finally {
            entityManager.close();
        }
    }

    @Override
    public List<Application> findAllApplications() {
        EntityManager entityManager = JPAUtil.getEntityManager();
        try {
            TypedQuery<Application> query = entityManager.createQuery(
                    "SELECT a FROM Application a LEFT JOIN FETCH a.skills", Application.class);
            return query.getResultList();
        } finally {
            entityManager.close();
        }
    }

}
