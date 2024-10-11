package com.example.gestionaire_employe_v2.service.impl;

import com.example.gestionaire_employe_v2.model.Offre;
import com.example.gestionaire_employe_v2.repository.impl.OffreRepository;
import com.example.gestionaire_employe_v2.service.interf.OffreServiceInterface;

import java.util.List;

public class OffreService implements OffreServiceInterface {

    private final OffreRepository offreRepository = new OffreRepository();


    @Override
    public void addOffre(Offre offre){
        offreRepository.addOffre(offre);

    }

    @Override
    public List<Offre> findAll(){
      return  offreRepository.findAll();
    }

}
