package com.example.gestionaire_employe_v2.controller;

import com.example.gestionaire_employe_v2.model.LeaveRequest;
import com.example.gestionaire_employe_v2.service.impl.LeaveRequestService;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.List;

@WebServlet(name = "adminLeaveRequests", value = "/adminLeaveRequests")
public class AdminLeaveRequestsServlet extends HttpServlet {

    private final LeaveRequestService leaveRequestService = new LeaveRequestService();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<LeaveRequest> leaveRequests = leaveRequestService.getAllLeaveRequests();
        System.out.println("Nombre de demandes de congé : " + leaveRequests.size());
        request.setAttribute("leaveRequests", leaveRequests);
        request.getRequestDispatcher("/view/AdminLeaveRequests.jsp").forward(request, response);
    }

}
