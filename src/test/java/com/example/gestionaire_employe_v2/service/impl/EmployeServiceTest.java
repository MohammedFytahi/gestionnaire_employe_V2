package com.example.gestionaire_employe_v2.service.impl;

import com.example.gestionaire_employe_v2.model.Employe;
import com.example.gestionaire_employe_v2.model.FamilyAllowance;
import com.example.gestionaire_employe_v2.repository.impl.EmployeRepository;
import com.example.gestionaire_employe_v2.repository.impl.FamilyAllowanceRepository;
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
import static org.junit.Assert.assertNull;
import static org.mockito.Mockito.*;

@RunWith(MockitoJUnitRunner.class)
public class EmployeServiceTest {

    @Mock
    private EmployeRepository employeRepository;

    @Mock
    private FamilyAllowanceRepository familyAllowanceRepository;

    @InjectMocks
    private EmployeService employeService;

    private Employe employe;

    @Before
    public void setUp() {
        employe = new Employe();
        employe.setId(1);
        employe.setChildNbr(2);
        employe.setSalary(550L);
    }

    @Test
    public void testAddEmploye() {
        Employe employe = new Employe();
        employeService.addEmploye(employe);
        verify(employeRepository, times(1)).addEmploye(employe);
    }

    @Test
    public void testFindEmployeById() {
        when(employeRepository.findEmployeById(1)).thenReturn(employe);

        Employe result = employeService.trouverParId(1);
        assertEquals(1, result.getId());
        verify(employeRepository, times(1)).findEmployeById(1);
    }

    @Test
    public void testDeleteEmploye() {
        employeService.deleteEmploye(1);
        verify(employeRepository, times(1)).deleteEmploye(1);
    }

    @Test
    public void testFindAllEmployes() {
        List<Employe> employes = Arrays.asList(new Employe(), new Employe());
        when(employeRepository.findall()).thenReturn(employes);

        List<Employe> result = employeService.findAllEmployes();
        assertEquals(2, result.size());
        verify(employeRepository, times(1)).findall();
    }

    @Test
    public void testFindEmployeByIdNotFound() {
        when(employeRepository.findEmployeById(2)).thenReturn(null);
        Employe result = employeService.trouverParId(2);
        assertNull(result);
        verify(employeRepository, times(1)).findEmployeById(2);
    }

    @Test
    public void testCalculateFamilyAllowance_Success() {
        when(employeRepository.findEmployeById(1)).thenReturn(employe);

        Double calculatedAllowance = employeService.calculateFamilyAllowance(1);

        assertEquals(600.0, calculatedAllowance, 0.01);
        verify(familyAllowanceRepository, times(1)).addFamilyAllowance(any(FamilyAllowance.class));
    }

    @Test
    public void testCalculateFamilyAllowance_EmployeeNotFound() {
        when(employeRepository.findEmployeById(2)).thenReturn(null);

        Double calculatedAllowance = employeService.calculateFamilyAllowance(2);

        assertEquals(0.0, calculatedAllowance, 0.01);
        verify(familyAllowanceRepository, times(0)).addFamilyAllowance(any(FamilyAllowance.class));
    }
}
