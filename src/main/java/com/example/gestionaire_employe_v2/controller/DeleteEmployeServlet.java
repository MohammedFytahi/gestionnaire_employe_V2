package com.example.gestionaire_employe_v2.controller;

import com.example.gestionaire_employe_v2.service.impl.EmployeService;
import com.example.gestionaire_employe_v2.service.interf.EmployeServiceInterface;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;
@WebServlet(name = "deleteEmploye", value = "/deleteEmploye")
public class DeleteEmployeServlet extends HttpServlet {

    private final EmployeServiceInterface employeService;

    public DeleteEmployeServlet() {
        this.employeService = new EmployeService();
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        int id = Integer.parseInt(request.getParameter("id"));


        employeService.deleteEmploye(id);


        response.sendRedirect("listEmploye");
    }
}
