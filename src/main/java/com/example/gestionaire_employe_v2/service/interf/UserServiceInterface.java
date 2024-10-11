package com.example.gestionaire_employe_v2.service.interf;

import com.example.gestionaire_employe_v2.model.User;

public interface UserServiceInterface {
    /**
     * Authentifier un utilisateur avec son email et son mot de passe.
     *
     * @param email    L'email de l'utilisateur
     * @param password Le mot de passe de l'utilisateur
     * @return L'utilisateur authentifié si les informations sont correctes, sinon null
     */
    User authenticate(String email, String password);
}
