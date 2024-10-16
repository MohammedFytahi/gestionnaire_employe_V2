package com.example.gestionaire_employe_v2.service.impl;

import com.example.gestionaire_employe_v2.model.Application;
import com.example.gestionaire_employe_v2.repository.impl.ApplicationRepository;
import com.example.gestionaire_employe_v2.service.interf.ApplicationServiceInterface;

import java.util.List;

public class ApplicationService implements ApplicationServiceInterface {
    private final ApplicationRepository applicationRepository;

    public ApplicationService() {
        this.applicationRepository = new ApplicationRepository();
    }

    @Override
    public void saveApplication(Application application) {
        applicationRepository.saveApplication(application);
    }

    @Override
    public List<Application> filterApplicationsBySkills(List<String> skills) {
        return applicationRepository.findApplicationsBySkills(skills);
    }

    @Override
    public List<Application> getAllApplications() {
        return applicationRepository.findAllApplications();
    }
}
