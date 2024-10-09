package com.example.gestionaire_employe_v2.service.impl;

import com.example.gestionaire_employe_v2.model.Employe;
import com.example.gestionaire_employe_v2.repository.impl.EmployeRepository;
import com.example.gestionaire_employe_v2.service.interf.EmployeServiceInterface;

public class EmployeService implements EmployeServiceInterface {

    private EmployeRepository employeRepository;

    public EmployeService(){
        this.employeRepository = new EmployeRepository();
    }

    @Override
    public void addEmploye(Employe employe){
        employeRepository.addEmploye(employe);

    }
}
