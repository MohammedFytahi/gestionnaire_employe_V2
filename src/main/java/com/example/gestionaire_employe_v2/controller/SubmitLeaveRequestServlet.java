package com.example.gestionaire_employe_v2.controller;

import com.example.gestionaire_employe_v2.model.LeaveRequest;
import com.example.gestionaire_employe_v2.enums.Statut;
import com.example.gestionaire_employe_v2.service.impl.LeaveRequestService;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.MultipartConfig;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.time.LocalDate;

@WebServlet(name = "submitLeaveRequest", value = "/submitLeaveRequest")
@MultipartConfig
public class SubmitLeaveRequestServlet extends HttpServlet {

    private final LeaveRequestService leaveRequestService = new LeaveRequestService();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("/view/LeaveRequestForm.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        Integer employeeIdObj = (Integer) session.getAttribute("userId");

        if (employeeIdObj == null) {
            response.sendRedirect(request.getContextPath() + "/login");
            return; // Exit if userId is not set
        }

        int employeeId = employeeIdObj.intValue();

        String startDateStr = request.getParameter("startDate");
        String endDateStr = request.getParameter("endDate");
        String leaveReason = request.getParameter("leaveReason");

        LocalDate startDate = LocalDate.parse(startDateStr);
        LocalDate endDate = LocalDate.parse(endDateStr);

        String supportingDocs = request.getPart("supportingDocs").getSubmittedFileName();

        LeaveRequest leaveRequest = new LeaveRequest();
        leaveRequest.setEmployeeId(employeeId);
        leaveRequest.setStartDate(startDate);
        leaveRequest.setEndDate(endDate);
        leaveRequest.setLeaveReason(leaveReason);
        leaveRequest.setSupportingDocs(supportingDocs);
        leaveRequest.setStatus(Statut.RECU);

        leaveRequestService.createLeaveRequest(leaveRequest);

        response.sendRedirect(request.getContextPath() + "/leaveRequestSuccess.jsp");
    }
}
