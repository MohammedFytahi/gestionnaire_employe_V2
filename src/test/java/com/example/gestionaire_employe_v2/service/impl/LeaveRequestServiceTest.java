package com.example.gestionaire_employe_v2.service.impl;

import com.example.gestionaire_employe_v2.enums.Statut;
import com.example.gestionaire_employe_v2.model.LeaveRequest;
import com.example.gestionaire_employe_v2.repository.impl.EmployeRepository;
import com.example.gestionaire_employe_v2.repository.impl.LeaveRequestRepository;
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
public class LeaveRequestServiceTest {

    @Mock
    private LeaveRequestRepository leaveRequestRepository;

    @Mock
    private EmployeRepository employeRepository;

    @InjectMocks
    private LeaveRequestService leaveRequestService;

    @Before
    public void setUp() {
        MockitoAnnotations.initMocks(this);
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

        assertEquals(2, result.size());
        assertEquals(mockRequests, result);
        verify(leaveRequestRepository).findAll();
    }

    @Test
    public void testApproveLeaveRequestIfSufficientBalance() {
        int requestId = 1;
        boolean sufficientBalance = true;

        when(leaveRequestRepository.approveLeaveRequestIfSufficientBalance(requestId)).thenReturn(sufficientBalance);

        boolean result = leaveRequestService.approveLeaveRequestIfSufficientBalance(requestId);

        assertEquals(sufficientBalance, result);
        verify(leaveRequestRepository).approveLeaveRequestIfSufficientBalance(requestId);
    }

    @Test
    public void testGetLeaveRequestById() {
        int requestId = 1;

        LeaveRequest mockLeaveRequest = new LeaveRequest();
        mockLeaveRequest.setLeaveRequestId(requestId);
        mockLeaveRequest.setStartDate(LocalDate.now());
        mockLeaveRequest.setEndDate(LocalDate.now().plusDays(5));
        mockLeaveRequest.setLeaveReason("Vacances");
        mockLeaveRequest.setSupportingDocs("document.pdf");
        mockLeaveRequest.setStatus(Statut.RECU);
        mockLeaveRequest.setEmployeeId(152);

        when(leaveRequestRepository.findById(requestId)).thenReturn(mockLeaveRequest);

        LeaveRequest result = leaveRequestService.getLeaveRequestById(requestId);

        assertEquals(mockLeaveRequest, result);
        verify(leaveRequestRepository).findById(requestId);
    }

    @Test
    public void testUpdateLeaveRequestStatus() {
        int requestId = 1;
        Statut newStatus = Statut.ACCEPTE;

        leaveRequestService.updateLeaveRequestStatus(requestId, newStatus);

        verify(leaveRequestRepository).updateStatus(requestId, newStatus);
    }
}
