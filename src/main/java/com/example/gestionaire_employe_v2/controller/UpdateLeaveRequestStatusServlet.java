package com.example.gestionaire_employe_v2.controller;

import com.example.gestionaire_employe_v2.enums.Statut;
import com.example.gestionaire_employe_v2.model.Employe;
import com.example.gestionaire_employe_v2.model.LeaveRequest;
import com.example.gestionaire_employe_v2.service.impl.EmployeService;
import com.example.gestionaire_employe_v2.service.impl.LeaveRequestService;

import com.example.gestionaire_employe_v2.util.EmailUtil;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet(name = "updateLeaveRequestStatus", value = "/updateLeaveRequestStatus")
public class UpdateLeaveRequestStatusServlet extends HttpServlet {

    private final LeaveRequestService leaveRequestService = new LeaveRequestService();
    private final EmployeService employeeService = new EmployeService(); // Service pour récupérer l'employé

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int requestId = Integer.parseInt(request.getParameter("requestId"));
        String action = request.getParameter("action");


        Statut newStatus;
        if ("ACCEPTER".equals(action)) {
            newStatus = Statut.ACCEPTE;
        } else if ("REFUSER".equals(action)) {
            newStatus = Statut.REJETE;
        } else {
            throw new ServletException("Action non reconnue: " + action);
        }


        leaveRequestService.updateLeaveRequestStatus(requestId, newStatus);


        LeaveRequest leaveRequest = leaveRequestService.getLeaveRequestById(requestId);


        Employe employee = employeeService.trouverParId(leaveRequest.getEmployeeId());


        if (employee != null) {
            String employeeEmail = employee.getEmail();
            sendEmail(employeeEmail, "Statut de votre demande de congé: " + newStatus.name());
        }


        response.sendRedirect(request.getContextPath() + "/adminLeaveRequests");
    }


    private void sendEmail(String to, String status) {
        String subject = "Statut de votre demande de congé";
        String body = "Votre demande de congé a été " + status.toLowerCase() + ".";

        EmailUtil.sendEmail(to, subject, body);
    }

}
