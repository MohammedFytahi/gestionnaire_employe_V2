package com.example.gestionaire_employe_v2.repository.interfaces;

import com.example.gestionaire_employe_v2.model.FamilyAllowance;

import java.util.List;

public interface FamilyAllowanceRepositoryInterface {

    void addFamilyAllowance(FamilyAllowance familyAllowance);

    FamilyAllowance findFamilyAllowanceById(int familyId);

    List<FamilyAllowance> findAllFamilyAllowances();

    void updateFamilyAllowance(FamilyAllowance familyAllowance);

    void deleteFamilyAllowance(int familyId);
}
