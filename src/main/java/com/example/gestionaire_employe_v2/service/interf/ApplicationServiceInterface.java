package com.example.gestionaire_employe_v2.service.interf;

import com.example.gestionaire_employe_v2.model.Application;

import java.util.List;

public interface ApplicationServiceInterface {

    void saveApplication(Application application);
    List<Application> filterApplicationsBySkills(List<String> skills);
    List<Application> getAllApplications();
}
