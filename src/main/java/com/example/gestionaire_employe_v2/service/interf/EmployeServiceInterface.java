package com.example.gestionaire_employe_v2.service.interf;

import com.example.gestionaire_employe_v2.model.Employe;
import com.example.gestionaire_employe_v2.service.impl.EmployeService;

import java.util.List;

public interface EmployeServiceInterface {
    void addEmploye(Employe employe);

    void updateEmploye(Employe employe);

    Employe trouverParId(long id);

    List<Employe> findAllEmployes();
}
