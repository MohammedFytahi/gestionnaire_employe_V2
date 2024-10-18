package com.example.gestionaire_employe_v2.service.impl;

import com.example.gestionaire_employe_v2.enums.Statut;
import com.example.gestionaire_employe_v2.model.Offre;
import com.example.gestionaire_employe_v2.repository.impl.OffreRepository;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.MockitoJUnitRunner;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.*;

@RunWith(MockitoJUnitRunner.class)
public class OffreServiceTest {

  @Mock
  private OffreRepository offreRepository;

  @InjectMocks
  private OffreService offreService;

  @Before
  public void setUp() {
    MockitoAnnotations.initMocks(this);
  }

  @Test
  public void addOffre() {
    Offre offre = new Offre();
    offre.setTitle("youcode");
    offre.setDatePosted(LocalDate.now());
    offre.setValidityPeriode(LocalDate.now().plusDays(7));
    offre.setRequirements("html");
    offre.setDescription("fghgf");
    offre.setStatut(Statut.EN_COURS);
    offre.setId(1);

    offreService.addOffre(offre);

    verify(offreRepository).addOffre(offre);
  }

  @Test
  public void testFindByIdWhenOffreIsValid() {
    LocalDate validDate = LocalDate.now().plusDays(1);
    Offre offre = new Offre();
    offre.setId(1);
    offre.setValidityPeriode(validDate);
    offre.setStatut(Statut.EN_COURS);

    when(offreRepository.findById(1)).thenReturn(offre);

    Offre result = offreService.findById(1);

    assertEquals(Statut.EN_COURS, result.getStatut());
    verify(offreRepository, never()).updateOffre(any(Offre.class));
  }

  @Test
  public void testFindByIdWhenOffreIsInactive() {
    LocalDate pastDate = LocalDate.now().minusDays(1);
    Offre offre = new Offre();
    offre.setId(1);
    offre.setValidityPeriode(pastDate);
    offre.setStatut(Statut.EN_COURS);

    when(offreRepository.findById(1)).thenReturn(offre);

    Offre result = offreService.findById(1);

    assertEquals(Statut.INACTIVE, result.getStatut());
    verify(offreRepository).updateOffre(offre);
  }

  @Test
  public void testFindAllWithValidAndExpiredOffres() {
    LocalDate validDate = LocalDate.now().plusDays(1);
    LocalDate expiredDate = LocalDate.now().minusDays(1);

    Offre validateOffre = new Offre();
    validateOffre.setId(1);
    validateOffre.setValidityPeriode(validDate);
    validateOffre.setStatut(Statut.EN_COURS);

    Offre expiredOffre = new Offre();
    expiredOffre.setId(2);
    expiredOffre.setValidityPeriode(expiredDate);
    expiredOffre.setStatut(Statut.EN_COURS);
  }

  @Test
  public void testFindAll() {
    Offre offreActive = new Offre();
    offreActive.setStatut(Statut.EN_COURS);
    offreActive.setValidityPeriode(LocalDate.now().plusDays(5));

    Offre offreExpirée = new Offre();
    offreExpirée.setStatut(Statut.EN_COURS);
    offreExpirée.setValidityPeriode(LocalDate.now().minusDays(1));

    List<Offre> mockOffres = Arrays.asList(offreActive, offreExpirée);

    when(offreRepository.findAll()).thenReturn(mockOffres);

    List<Offre> result = offreService.findAll();

    assertEquals(Statut.INACTIVE, offreExpirée.getStatut());
    assertEquals(mockOffres, result);
    verify(offreRepository).updateOffre(offreExpirée);
    verify(offreRepository).findAll();
  }
}
