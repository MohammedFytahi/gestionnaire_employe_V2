package com.example.gestionaire_employe_v2.model;

import jakarta.persistence.*;


import java.time.LocalDate;

@Entity
@Table(name = "family_allowances")
public class FamilyAllowance {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int familyId;

    private int childrenCount;

    private Double allowanceAmount;
    private Double salaryAmount;

    private LocalDate dateCalculated;

    public FamilyAllowance() {}


    public int getFamilyId() {
        return familyId;
    }
    public void setFamilyId(int familyId) {
        this.familyId = familyId;
    }
    public int getChildrenCount() {
        return childrenCount;
    }
    public void setChildrenCount(int childrenCount) {
        this.childrenCount = childrenCount;
    }
    public Double getAllowanceAmount() {
        return allowanceAmount;
    }
    public void setAllowanceAmount(Double allowanceAmount) {
        this.allowanceAmount = allowanceAmount;
    }
    public Double getSalaryAmount() {
        return salaryAmount;
    }
    public void setSalaryAmount(Double salaryAmount) {
        this.salaryAmount = salaryAmount;
    }
    public LocalDate getDateCalculated() {
        return dateCalculated;
    }
    public void setDateCalculated(LocalDate dateCalculated) {
        this.dateCalculated = dateCalculated;
    }
}