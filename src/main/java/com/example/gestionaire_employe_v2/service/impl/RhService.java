package com.example.gestionaire_employe_v2.service.impl;

import com.example.gestionaire_employe_v2.model.Rh;
import com.example.gestionaire_employe_v2.repository.impl.RhRepository;
import com.example.gestionaire_employe_v2.service.interf.RhServiceInterface;

public class RhService implements RhServiceInterface {
    private RhRepository rhRepository;

    public RhService() {
        this.rhRepository = new RhRepository();
    }

    @Override
    public void ajouterRh(Rh rh) {
        rhRepository.ajouterRh(rh);
    }
}
