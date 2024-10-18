package com.example.gestionaire_employe_v2.controller;

import com.example.gestionaire_employe_v2.model.FamilyAllowance;
import com.example.gestionaire_employe_v2.repository.impl.FamilyAllowanceRepository;
import com.example.gestionaire_employe_v2.service.impl.EmployeService;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;
import java.util.List;


@WebServlet(name ="calculateAllowance", value = "/calculateAllowance")
public class FamilyAllowanceServlet extends HttpServlet {
    private EmployeService employeService = new EmployeService();

    private FamilyAllowanceRepository familyAllowanceRepository = new FamilyAllowanceRepository();

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<FamilyAllowance> familyAllowances = familyAllowanceRepository.findAllFamilyAllowances();
        request.setAttribute("familyAllowances", familyAllowances);
        request.getRequestDispatcher("/view/listFamilyAllowances.jsp").forward(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int employeId = Integer.parseInt(request.getParameter("employeId"));
        Double allowance = employeService.calculateFamilyAllowance(employeId);
        request.setAttribute("allowance", allowance);
        request.getRequestDispatcher("/view/showAllowance.jsp").forward(request, response);
    }
}


