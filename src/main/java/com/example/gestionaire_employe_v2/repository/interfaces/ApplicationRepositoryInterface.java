package com.example.gestionaire_employe_v2.repository.interfaces;

import com.example.gestionaire_employe_v2.model.Application;

import java.util.List;

public interface ApplicationRepositoryInterface {
    void saveApplication(Application application);
    List<Application> findApplicationsBySkills(List<String> skills);
    List<Application> findAllApplications();
}
