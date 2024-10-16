package com.example.gestionaire_employe_v2.service.impl;

import com.example.gestionaire_employe_v2.model.Employe;
import com.example.gestionaire_employe_v2.model.FamilyAllowance;
import com.example.gestionaire_employe_v2.repository.impl.EmployeRepository;
import com.example.gestionaire_employe_v2.repository.impl.FamilyAllowanceRepository;
import com.example.gestionaire_employe_v2.service.interf.EmployeServiceInterface;

import java.time.LocalDate;
import java.util.List;

public class EmployeService implements EmployeServiceInterface {

    private EmployeRepository employeRepository;
    private FamilyAllowanceRepository familyAllowanceRepository;

    public EmployeService(){
        this.employeRepository = new EmployeRepository();
        this.familyAllowanceRepository = new FamilyAllowanceRepository();
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

    public Double calculateFamilyAllowance(int employeId) {
        Employe employe = employeRepository.findEmployeById(employeId);
        if (employe != null) {
            FamilyAllowance allowance = new FamilyAllowance();
            Double calculatedAllowance = allowance.calculateAllowance(employe.getChildNbr(), employe.getSalary().doubleValue());


            allowance.setChildrenCount(employe.getChildNbr());
            allowance.setSalaryAmount(employe.getSalary().doubleValue());
            allowance.setAllowanceAmount(calculatedAllowance);
            allowance.setDateCalculated(LocalDate.now());
            allowance.setEmploye(employe);
            familyAllowanceRepository.addFamilyAllowance(allowance);

            return calculatedAllowance;
        }
        return 0.0;
    }
}