package com.example.gestionaire_employe_v2.controller;

import com.example.gestionaire_employe_v2.model.Employe;
import com.example.gestionaire_employe_v2.service.impl.EmployeService;
import com.example.gestionaire_employe_v2.service.interf.EmployeServiceInterface;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;
import java.util.List;

@WebServlet(name = "listEmploye", value = "/listEmploye")
public class ListEmployeServlet extends HttpServlet {

    private final EmployeServiceInterface employeService;


    public ListEmployeServlet() {
        this.employeService = new EmployeService();
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


        RequestDispatcher dispatcher = request.getRequestDispatcher("view/listEmploye.jsp");
        dispatcher.forward(request, response);
    }
}
