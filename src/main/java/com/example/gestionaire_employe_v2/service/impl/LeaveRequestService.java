package com.example.gestionaire_employe_v2.service.impl;

import com.example.gestionaire_employe_v2.enums.Statut;
import com.example.gestionaire_employe_v2.model.LeaveRequest;
import com.example.gestionaire_employe_v2.repository.impl.LeaveRequestRepository;

import java.util.List;


public class LeaveRequestService {
    private final LeaveRequestRepository leaveRequestRepository = new LeaveRequestRepository();

    public void createLeaveRequest(LeaveRequest leaveRequest) {
        leaveRequestRepository.save(leaveRequest);
    }

    public List<LeaveRequest> getAllLeaveRequests() {
        List<LeaveRequest> requests = leaveRequestRepository.findAll();
        System.out.println("Demandes de congé récupérées : " + requests.size());
        return requests;
    }
    public LeaveRequest getLeaveRequestById(int requestId) {
        return leaveRequestRepository.findById(requestId);
    }

    public void updateLeaveRequestStatus(int requestId, Statut status) {
        leaveRequestRepository.updateStatus(requestId, status);
    }
}
