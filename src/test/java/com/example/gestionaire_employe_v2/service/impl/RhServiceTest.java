package com.example.gestionaire_employe_v2.service.impl;

import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.times;

import com.example.gestionaire_employe_v2.model.Rh;
import com.example.gestionaire_employe_v2.repository.impl.RhRepository;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

public class RhServiceTest {

    @Mock
    private RhRepository rhRepository;

    @InjectMocks
    private RhService rhService;

    @Before
    public void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void testAjouterRh() {
        Rh rh = new Rh();
        rhService.ajouterRh(rh);
        verify(rhRepository, times(1)).ajouterRh(rh);
    }
}
