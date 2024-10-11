package com.example.gestionaire_employe_v2.repository.impl;

import com.example.gestionaire_employe_v2.model.User;
import com.example.gestionaire_employe_v2.repository.interfaces.UserRepositoryInterface;
import com.example.gestionaire_employe_v2.util.JPAUtil;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;

public class UserRepository implements UserRepositoryInterface {

    @Override
    public User findByEmail(String email) {
        EntityManager entityManager = JPAUtil.getEntityManager();
        try {
            TypedQuery<User> query = entityManager.createQuery("SELECT u FROM User u WHERE u.email = :email", User.class);
            query.setParameter("email", email);
            return query.getSingleResult();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            entityManager.close();
        }
        return null;
    }

    @Override
    public User authenticate(String email, String password) {
        User user = findByEmail(email);


        if (user != null && user.getPassword().equals(password)) {
            return user;
        }

        return null;
    }
}
