package com.example.gestionaire_employe_v2.model;

import com.example.gestionaire_employe_v2.enums.Role;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Table(name = "rh")
public class Rh extends User {

    public Rh() {
    super();
    }

    public Rh(int id, String username, String email, String password) {

        super(id, username, email, password, Role.RH);
    }


}
