package com.example.gestionaire_employe_v2.controller;

import com.example.gestionaire_employe_v2.enums.Role;
import com.example.gestionaire_employe_v2.model.Rh;
import com.example.gestionaire_employe_v2.service.impl.RhService;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;

@WebServlet(name = "AddRhServlet", value = "/AddRhServlet")
public class AddRhServlet extends HttpServlet {

    private final RhService rhService = new RhService();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        request.getRequestDispatcher("/view/ajouterRh.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        try {
            String username = request.getParameter("username");
            String email = request.getParameter("email");
            String password = request.getParameter("password");



            Rh newRh = new Rh();
            newRh.setUsername(username);
            newRh.setEmail(email);
            newRh.setPassword(password);
            newRh.setRole(Role.RH);


            rhService.ajouterRh(newRh);



            response.sendRedirect("listEmploye");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
