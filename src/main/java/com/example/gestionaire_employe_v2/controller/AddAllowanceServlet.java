package com.example.gestionaire_employe_v2.controller;

import com.example.gestionaire_employe_v2.model.Employe;
import com.example.gestionaire_employe_v2.service.impl.EmployeService;
import com.example.gestionaire_employe_v2.service.interf.EmployeServiceInterface;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;
import java.util.List;

@WebServlet(name = "AddAllowanceServlet", value = "/AddAllowanceServlet")
public class AddAllowanceServlet extends HttpServlet {

    private final EmployeServiceInterface employeService;
    public AddAllowanceServlet(){this.employeService = new EmployeService();
    }
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Employe> employes = null;

        try {
            employes = employeService.findAllEmployes();
        } catch (Exception e) {

            e.printStackTrace();
            request.setAttribute("errorMessage", "An error occurred while retrieving employees.");
        }

        request.setAttribute("employes", employes);


        RequestDispatcher dispatcher = request.getRequestDispatcher("view/calculeForm.jsp");
        dispatcher.forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
