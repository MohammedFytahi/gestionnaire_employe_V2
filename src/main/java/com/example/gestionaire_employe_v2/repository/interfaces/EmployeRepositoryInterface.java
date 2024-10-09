package com.example.gestionaire_employe_v2.repository.interfaces;

import com.example.gestionaire_employe_v2.model.Employe;

import java.util.List;

public interface EmployeRepositoryInterface {
    void addEmploye(Employe employe);
    void updateEmploye(Employe employe);

    Employe findEmployeById(long id);
    List<Employe> findall();
}
