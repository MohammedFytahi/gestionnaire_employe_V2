package com.example.gestionaire_employe_v2.controller;

import com.example.gestionaire_employe_v2.enums.Statut;
import com.example.gestionaire_employe_v2.model.Offre;

import com.example.gestionaire_employe_v2.service.impl.OffreService;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.time.LocalDate;

@WebServlet(name = "addOffre", value = "/addOffre")
public class AddOffreServlet extends HttpServlet {

    private final OffreService offreService = new OffreService();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Forward to JSP page to display the form
        request.getRequestDispatcher("view/addOffre.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            // Get form parameters
            String title = request.getParameter("title");
            String description = request.getParameter("description");
            String requirements = request.getParameter("requirements");
            LocalDate datePosted = LocalDate.now();  // Automatically set the date of posting
            LocalDate validityPeriode = LocalDate.parse(request.getParameter("validityPeriode"));
            Statut statut = Statut.valueOf(request.getParameter("statut"));


            Offre offre = new Offre();
            offre.setTitle(title);
            offre.setDescription(description);
            offre.setRequirements(requirements);
            offre.setDatePosted(datePosted);
            offre.setValidityPeriode(validityPeriode);
            offre.setStatut(statut);


            offreService.addOffre(offre);


            response.sendRedirect("success.jsp");
        } catch (Exception e) {
            e.printStackTrace();
            response.sendRedirect("error.jsp");
        }
    }
}
