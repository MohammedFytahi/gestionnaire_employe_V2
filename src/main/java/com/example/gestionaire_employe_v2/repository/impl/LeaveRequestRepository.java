package com.example.gestionaire_employe_v2.repository.impl;

import com.example.gestionaire_employe_v2.enums.Statut;
import com.example.gestionaire_employe_v2.model.Employe;
import com.example.gestionaire_employe_v2.model.LeaveRequest;
import com.example.gestionaire_employe_v2.util.JPAUtil;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.persistence.*;

import java.util.List;

@ApplicationScoped
public class LeaveRequestRepository {

    public void save(LeaveRequest leaveRequest) {
        EntityManager entityManager = JPAUtil.getEntityManager();
        EntityTransaction transaction = entityManager.getTransaction();
        try {
            transaction.begin();
            entityManager.persist(leaveRequest);
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

    public List<LeaveRequest> findAll() {
        EntityManager entityManager = JPAUtil.getEntityManager();
        try {
            TypedQuery<LeaveRequest> query = entityManager.createQuery("SELECT lr FROM LeaveRequest lr", LeaveRequest.class);
            return query.getResultList();
        }finally {
            entityManager.close();
        }

    }

                                                                                                                                                                                                                                            public void updateStatus(int requestId, Statut status) {
                                                                                                                                                                                                                                                EntityManager entityManager = JPAUtil.getEntityManager();
                                                                                                                                                                                                                                                EntityTransaction transaction = entityManager.getTransaction();
                                                                                                                                                                                                                                                try {
                                                                                                                                                                                                                                                    transaction.begin();
                                                                                                                                                                                                                                                    LeaveRequest leaveRequest = entityManager.find(LeaveRequest.class, requestId);
                                                                                                                                                                                                                                                    if (leaveRequest != null) {
                                                                                                                                                                                                                                                        leaveRequest.setStatus(status);
                                                                                                                                                                                                                                                        transaction.commit();
                                                                                                                                                                                                                                                    }
                                                                                                                                                                                                                                                } catch (Exception e) {
                                                                                                                                                                                                                                                    if (transaction.isActive()) {
                                                                                                                                                                                                                                                        transaction.rollback();
                                                                                                                                                                                                                                                    }
                                                                                                                                                                                                                                                    e.printStackTrace();
                                                                                                                                                                                                                                                } finally {
                                                                                                                                                                                                                                                    entityManager.close();
                                                                                                                                                                                                                                                }
                                                                                                                                                                                                                                            }

    public LeaveRequest findById(int requestId) {
        EntityManager entityManager = JPAUtil.getEntityManager();
        try {
            return entityManager.find(LeaveRequest.class, requestId);
        } finally {
            entityManager.close();
        }
    }

    public boolean approveLeaveRequestIfSufficientBalance(int requestId) {
        EntityManager entityManager = JPAUtil.getEntityManager();
        EntityTransaction transaction = entityManager.getTransaction();
        try {
            transaction.begin();


            LeaveRequest leaveRequest = entityManager.find(LeaveRequest.class, requestId);


            if (leaveRequest != null) {
                int employeeId = leaveRequest.getEmployeeId();


                Employe employe = entityManager.find(Employe.class, employeeId);

                long numberOfLeaveDays = leaveRequest.getEndDate().toEpochDay() - leaveRequest.getStartDate().toEpochDay();


                if (employe.getLeaveBalance() >= numberOfLeaveDays) {

                    employe.setLeaveBalance(employe.getLeaveBalance() - (int) numberOfLeaveDays);


                    leaveRequest.setStatus(Statut.ACCEPTE);


                    entityManager.merge(employe);
                    entityManager.merge(leaveRequest);

                    transaction.commit();

                    return true;
                } else {
                    transaction.rollback();
                    return false;
                }
            }

        } catch (Exception e) {
            if (transaction.isActive()) {
                transaction.rollback();
            }
            e.printStackTrace();
        } finally {
            entityManager.close();
        }
        return false;
    }

}
