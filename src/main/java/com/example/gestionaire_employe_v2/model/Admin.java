package com.example.gestionaire_employe_v2.model;

import com.example.gestionaire_employe_v2.enums.Role;
import jakarta.persistence.*;

@Entity
@Table(name = "admin")
public class Admin extends User {

    public Admin() {
    }

    public Admin(int id, String username, String email, String password, Role role) {
        super(id, username, email, password, role);
    }

}
