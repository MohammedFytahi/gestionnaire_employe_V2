package com.example.gestionaire_employe_v2.repository.interfaces;

import com.example.gestionaire_employe_v2.model.User;

public interface UserRepositoryInterface {
    User findByEmail(String email);
    User authenticate(String email, String password); // Ajout de la méthode d'authentification
}
