package com.example.gestionaire_employe_v2.service.impl;

import com.example.gestionaire_employe_v2.enums.Statut;
import com.example.gestionaire_employe_v2.model.LeaveRequest;
import com.example.gestionaire_employe_v2.repository.impl.LeaveRequestRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class LeaveRequestServiceTest {

    @Mock
    private LeaveRequestRepository leaveRequestRepository;

    @InjectMocks
    private LeaveRequestService leaveRequestService;

    @BeforeEach
    public void setUp() {

    }

    @Test
    public void testCreateLeaveRequest() {

        LeaveRequest leaveRequest = new LeaveRequest();
        leaveRequest.setLeaveRequestId(1);
        leaveRequest.setStartDate(LocalDate.now());
        leaveRequest.setEndDate(LocalDate.now().plusDays(5));
        leaveRequest.setLeaveReason("Vacances");
        leaveRequest.setSupportingDocs("document.pdf");
        leaveRequest.setStatus(Statut.RECU);
        leaveRequest.setEmployeeId(152);


        leaveRequestService.createLeaveRequest(leaveRequest);


        verify(leaveRequestRepository).save(leaveRequest);
    }


    @Test
    public void testGetAllLeaveRequests() {

        LeaveRequest leaveRequest1 = new LeaveRequest();
        leaveRequest1.setLeaveRequestId(1);
        leaveRequest1.setStartDate(LocalDate.now());
        leaveRequest1.setEndDate(LocalDate.now().plusDays(5));
        leaveRequest1.setLeaveReason("Vacances");
        leaveRequest1.setSupportingDocs("document1.pdf");
        leaveRequest1.setStatus(Statut.RECU);
        leaveRequest1.setEmployeeId(152);

        LeaveRequest leaveRequest2 = new LeaveRequest();
        leaveRequest2.setLeaveRequestId(2);
        leaveRequest2.setStartDate(LocalDate.now().plusDays(1));
        leaveRequest2.setEndDate(LocalDate.now().plusDays(3));
        leaveRequest2.setLeaveReason("Maladie");
        leaveRequest2.setSupportingDocs("document2.pdf");
        leaveRequest2.setStatus(Statut.RECU);
        leaveRequest2.setEmployeeId(153);

        List<LeaveRequest> mockRequests = Arrays.asList(leaveRequest1, leaveRequest2);


        when(leaveRequestRepository.findAll()).thenReturn(mockRequests);


        List<LeaveRequest> result = leaveRequestService.getAllLeaveRequests();

        assertEquals(2, result.size(), "La taille de la liste des demandes de congé doit être 2");
        assertEquals(mockRequests, result, "Les demandes de congé récupérées doivent correspondre aux demandes simulées");
        verify(leaveRequestRepository).findAll();
    }

}
