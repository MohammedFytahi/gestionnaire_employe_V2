package com.example.gestionaire_employe_v2.service.impl;

import com.example.gestionaire_employe_v2.model.Application;
import com.example.gestionaire_employe_v2.model.Offre;
import com.example.gestionaire_employe_v2.repository.impl.ApplicationRepository;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class ApplicationServiceTest {

    @Mock
    private ApplicationRepository applicationRepository;

    @InjectMocks
    private ApplicationService applicationService;

    private List<Application> applications;

    @Before
    public void setUp() {
        MockitoAnnotations.initMocks(this); // Initialize mocks
        Offre offre1 = new Offre();
        Offre offre2 = new Offre();

        Application app1 = new Application("John Doe", "john.doe@example.com", Arrays.asList("Java", "Spring"), offre1);
        Application app2 = new Application("Jane Smith", "jane.smith@example.com", Arrays.asList("SQL", "Java"), offre2);
        Application app3 = new Application("Emily Davis", "emily.davis@example.com", Arrays.asList("Python", "Django"), offre2);

        applications = Arrays.asList(app1, app2, app3);
    }

    @Test
    public void testSaveApplication() {
        Application application = new Application();
        application.setId(1);
        application.setCandidateName("John Doe");
        application.setEmail("Software@gmail.com");

        applicationService.saveApplication(application);
        verify(applicationRepository).saveApplication(application);
    }

    @Test
    public void testFilterApplicationsBySkills() {
        List<String> requiredSkills = Arrays.asList("Java");
        when(applicationRepository.findApplicationsBySkills(requiredSkills)).thenReturn(applications);

        List<Application> filteredApplications = applicationService.filterApplicationsBySkills(requiredSkills);
        verify(applicationRepository).findApplicationsBySkills(requiredSkills);

        assertEquals(3, filteredApplications.size());
        assertEquals("John Doe", filteredApplications.get(0).getCandidateName());
        assertEquals("Jane Smith", filteredApplications.get(1).getCandidateName());
        assertEquals("Emily Davis", filteredApplications.get(2).getCandidateName());
    }

    @Test
    public void testGetAllApplications() {
        when(applicationRepository.findAllApplications()).thenReturn(applications);

        List<Application> allApplications = applicationService.getAllApplications();

        assertEquals(3, allApplications.size());
        assertEquals("John Doe", allApplications.get(0).getCandidateName());
        assertEquals("Jane Smith", allApplications.get(1).getCandidateName());
        assertEquals("Emily Davis", allApplications.get(2).getCandidateName());
    }
}
