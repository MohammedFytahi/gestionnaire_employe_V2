package com.example.gestionaire_employe_v2.service.impl;

import com.example.gestionaire_employe_v2.model.User;
import com.example.gestionaire_employe_v2.repository.impl.UserRepository;
import com.example.gestionaire_employe_v2.service.interf.UserServiceInterface;


public class UserService implements UserServiceInterface {
    private final UserRepository userRepository;

    public UserService() {
        this.userRepository = new UserRepository(); // Initialiser le UserRepository
    }

    @Override
    public User authenticate(String email, String password) {
        // Appel à la méthode d'authentification du UserRepository
        User user = userRepository.authenticate(email, password);
        return user; // Retourner l'utilisateur ou null si non trouvé
    }
}
