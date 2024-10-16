package com.example.gestionaire_employe_v2.repository.impl;

import com.example.gestionaire_employe_v2.model.FamilyAllowance;
import com.example.gestionaire_employe_v2.repository.interfaces.FamilyAllowanceRepositoryInterface;
import com.example.gestionaire_employe_v2.util.JPAUtil;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.TypedQuery;

import java.util.ArrayList;
import java.util.List;

public class FamilyAllowanceRepository implements FamilyAllowanceRepositoryInterface {

    @Override
    public void addFamilyAllowance(FamilyAllowance familyAllowance) {
        EntityManager entityManager = JPAUtil.getEntityManager();
        EntityTransaction transaction = entityManager.getTransaction();

        try {
            transaction.begin();
            entityManager.persist(familyAllowance);
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
    public FamilyAllowance findFamilyAllowanceById(int familyId) {
        EntityManager entityManager = JPAUtil.getEntityManager();
        try {
            return entityManager.find(FamilyAllowance.class, familyId);
        } finally {
            entityManager.close();
        }
    }

    @Override
    public List<FamilyAllowance> findAllFamilyAllowances() {
        List<FamilyAllowance> allowances = new ArrayList<>();
        EntityManager entityManager = JPAUtil.getEntityManager();
        EntityTransaction transaction = entityManager.getTransaction();

        try {
            transaction.begin();
            TypedQuery<FamilyAllowance> query = entityManager.createQuery("SELECT f FROM FamilyAllowance f", FamilyAllowance.class);
            allowances = query.getResultList();
            transaction.commit();
        } catch (Exception e) {
            if (transaction.isActive()) {
                transaction.rollback();
            }
            e.printStackTrace();
        } finally {
            entityManager.close();
        }
        return allowances;
    }

    @Override
    public void updateFamilyAllowance(FamilyAllowance familyAllowance) {
        EntityManager entityManager = JPAUtil.getEntityManager();
        EntityTransaction transaction = entityManager.getTransaction();

        try {
            transaction.begin();
            entityManager.merge(familyAllowance);
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
    public void deleteFamilyAllowance(int familyId) {
        EntityManager entityManager = JPAUtil.getEntityManager();
        EntityTransaction transaction = entityManager.getTransaction();

        try {
            transaction.begin();
            FamilyAllowance familyAllowance = entityManager.find(FamilyAllowance.class, familyId);
            if (familyAllowance != null) {
                entityManager.remove(familyAllowance);
            }
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
}
