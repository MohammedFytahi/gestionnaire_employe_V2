package com.example.gestionaire_employe_v2.service.interf;

import com.example.gestionaire_employe_v2.model.Offre;

import java.util.List;

public interface OffreServiceInterface {
    void addOffre(Offre offre);

    List<Offre> findAll();
}
