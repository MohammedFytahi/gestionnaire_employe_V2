package com.example.gestionaire_employe_v2.controller;

import com.example.gestionaire_employe_v2.service.impl.EmployeService;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;

@WebServlet(name ="calculateAllowance", value = "/calculateAllowance")
public class FamilyAllowanceServlet extends HttpServlet {
    private EmployeService employeService = new EmployeService();

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int employeId = Integer.parseInt(request.getParameter("employeId"));
        Double allowance = employeService.calculateFamilyAllowance(employeId);
        request.setAttribute("allowance", allowance);
        request.getRequestDispatcher("/view/showAllowance.jsp").forward(request, response);
    }
}


