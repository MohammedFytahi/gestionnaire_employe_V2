package com.example.gestionaire_employe_v2.service.impl;

import com.example.gestionaire_employe_v2.model.Employe;
import com.example.gestionaire_employe_v2.repository.impl.EmployeRepository;
import com.example.gestionaire_employe_v2.service.interf.EmployeServiceInterface;

import java.util.List;

public class EmployeService implements EmployeServiceInterface {

    private EmployeRepository employeRepository;

    public EmployeService(){
        this.employeRepository = new EmployeRepository();
    }

    @Override
    public void addEmploye(Employe employe){
        employeRepository.addEmploye(employe);

    }

    public Employe trouverParId(long id){
        return employeRepository.findEmployeById(id);
    }
    @Override
    public void updateEmploye(Employe employe){
        employeRepository.updateEmploye(employe);
    }

    @Override
    public List<Employe> findAllEmployes(){
        return  employeRepository.findall();
    }

    @Override
    public void deleteEmploye(int id){
        employeRepository.deleteEmploye(id);
    }
}