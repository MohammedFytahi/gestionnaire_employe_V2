package com.example.gestionaire_employe_v2.service.impl;

import com.example.gestionaire_employe_v2.enums.Statut;
import com.example.gestionaire_employe_v2.model.Offre;
import com.example.gestionaire_employe_v2.repository.impl.OffreRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class OffreServiceTest {

  @Mock
  private OffreRepository offreRepository;

  @InjectMocks
  private OffreService offreService;

  @BeforeEach
  public void setUp() {

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

    LocalDate validDate = LocalDate.now().plusDays(1); // Future date
    Offre offre = new Offre();
    offre.setId(1);
    offre.setValidityPeriode(validDate);
    offre.setStatut(Statut.EN_COURS);

    when(offreRepository.findById(1)).thenReturn(offre);


    Offre result = offreService.findById(1);


    assertEquals(Statut.EN_COURS, result.getStatut());
    verify(offreRepository, never()).updateOffre(any(Offre.class)); // No update should happen
  }

  @Test
  public void testFindByIdWhenOffreIsInactive() {

    LocalDate pastDate = LocalDate.now().minusDays(1); // Past date
    Offre offre = new Offre();
    offre.setId(1);
    offre.setValidityPeriode(pastDate);
    offre.setStatut(Statut.EN_COURS);

    when(offreRepository.findById(1)).thenReturn(offre);


    Offre result = offreService.findById(1);


    assertEquals(Statut.INACTIVE, result.getStatut());
    verify(offreRepository).updateOffre(offre); // Update should be called
  }

  @Test
  public void testFindAllWithValidAndExpiredOffres(){

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
}
