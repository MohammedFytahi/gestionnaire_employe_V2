package com.example.gestionaire_employe_v2.model;

import com.example.gestionaire_employe_v2.enums.Role;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Table(name = "rh")
public class Rh extends User {

    public Rh() {
        // Appelle le constructeur par défaut de User
    }

    public Rh(int id, String username, String email, String password) {
        // Utilisez super() pour transmettre les paramètres à la classe parente User
        super(id, username, email, password, Role.RH);
    }
}
