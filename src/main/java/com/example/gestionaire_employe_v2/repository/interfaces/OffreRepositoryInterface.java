package com.example.gestionaire_employe_v2.repository.interfaces;

import com.example.gestionaire_employe_v2.model.Offre;

import java.util.List;

public interface OffreRepositoryInterface {

    void addOffre(Offre offre);
    List<Offre> findAll();
}
