package com.example.gestionaire_employe_v2.service.impl;

import com.example.gestionaire_employe_v2.enums.Statut;
import com.example.gestionaire_employe_v2.model.Offre;
import com.example.gestionaire_employe_v2.repository.impl.OffreRepository;
import com.example.gestionaire_employe_v2.service.interf.OffreServiceInterface;
import jakarta.inject.Inject;

import java.time.LocalDate;
import java.util.List;

public class OffreService implements OffreServiceInterface {

    @Inject
    private  OffreRepository offreRepository;



    @Override
    public void addOffre(Offre offre) {
        offreRepository.addOffre(offre);
    }

    @Override
    public List<Offre> findAll() {
        List<Offre> offres = offreRepository.findAll();


        LocalDate today = LocalDate.now();
        for (Offre offre : offres) {
            if (offre.getValidityPeriode().isBefore(today) && offre.getStatut() != Statut.INACTIVE) {
                offre.setStatut(Statut.INACTIVE);
                offreRepository.updateOffre(offre);
            }
        }
        return offres;
    }

    @Override
    public Offre findById(long id) {
        Offre offre = offreRepository.findById(id);
        LocalDate today = LocalDate.now();


        if (offre.getValidityPeriode().isBefore(today) && offre.getStatut() != Statut.INACTIVE) {
            offre.setStatut(Statut.INACTIVE);
            offreRepository.updateOffre(offre);
        }

        return offre;
    }


}
