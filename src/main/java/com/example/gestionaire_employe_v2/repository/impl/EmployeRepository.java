package com.example.gestionaire_employe_v2.repository.impl;

import com.example.gestionaire_employe_v2.model.Employe;
import com.example.gestionaire_employe_v2.repository.interfaces.EmployeRepositoryInterface;
import com.example.gestionaire_employe_v2.util.JPAUtil;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.TypedQuery;

import java.util.ArrayList;
import java.util.List;

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



    @Override
    public List<Employe> findall(){
        List<Employe> employes = new ArrayList<>();
        EntityManager entityManager = JPAUtil.getEntityManager();
        EntityTransaction transaction = entityManager.getTransaction();


        try {
            transaction.begin();
            TypedQuery<Employe> query = entityManager.createQuery("SELECT e FROM Employe  e", Employe.class);
            employes = query.getResultList();
            transaction.commit();

        }catch (Exception e){
            if (transaction.isActive()){
                transaction.rollback();
            }
            e.printStackTrace();
        }finally {
            entityManager.close();
        }
        return employes;
    }


        @Override
        public Employe findEmployeById(long id) {
            EntityManager entityManager = JPAUtil.getEntityManager();
            try {
                return entityManager.find(Employe.class, id);
            } finally {
                entityManager.close();
            }
        }


    @Override
    public void updateEmploye(Employe employe){
        EntityManager entityManager = JPAUtil.getEntityManager();
        EntityTransaction transaction = entityManager.getTransaction();

        try {
            transaction.begin();
            entityManager.merge(employe);
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

        @Override
        public void deleteEmploye(int id){
        EntityManager entityManager = JPAUtil.getEntityManager();
        EntityTransaction transaction = entityManager.getTransaction();

        try {
            transaction.begin();
            Employe employe = entityManager.find(Employe.class,id);
            if (employe != null){
                entityManager.remove(employe);
            }
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

