package com.example.gestionaire_employe_v2.service.impl;

import com.example.gestionaire_employe_v2.model.User;
import com.example.gestionaire_employe_v2.repository.impl.UserRepository;
import com.example.gestionaire_employe_v2.service.interf.UserServiceInterface;


public class UserService implements UserServiceInterface {
    private final UserRepository userRepository;

    public UserService() {
        this.userRepository = new UserRepository();
    }

    @Override
    public User authenticate(String email, String password) {
        User user = userRepository.findByEmail(email);
        if (user != null && user.getPassword().equals(password)) {
            return user;
        }
        return null;
    }
}
