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
        this.employeService = new EmployeService(); // Instantiate the service
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Retrieve the employee ID from the request parameter
        int id = Integer.parseInt(request.getParameter("id"));

        // Call the service to delete the employee by ID
        employeService.deleteEmploye(id);

        // Redirect back to the employee list after deletion
        response.sendRedirect("listEmploye");
    }
}
