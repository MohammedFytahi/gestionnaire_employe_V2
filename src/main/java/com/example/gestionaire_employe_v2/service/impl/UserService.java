package com.example.gestionaire_employe_v2.service.impl;

import com.example.gestionaire_employe_v2.model.User;
import com.example.gestionaire_employe_v2.repository.impl.UserRepository;
import com.example.gestionaire_employe_v2.service.interf.UserServiceInterface;
import jakarta.inject.Inject;


public class UserService implements UserServiceInterface {

    @Inject
    private  UserRepository userRepository;



    @Override
    public User authenticate(String email, String password) {
        User user = userRepository.findByEmail(email);
        if (user != null && user.getPassword().equals(password)) {
            return user;
        }
        return null;
    }
}
