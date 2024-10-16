package com.example.gestionaire_employe_v2.controller;

import com.example.gestionaire_employe_v2.enums.Statut;
import com.example.gestionaire_employe_v2.enums.Role;
import com.example.gestionaire_employe_v2.model.Offre;
import com.example.gestionaire_employe_v2.model.User;
import com.example.gestionaire_employe_v2.service.impl.OffreService;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.time.LocalDate;

@WebServlet(name = "addOffre", value = "/addOffre")
public class AddOffreServlet extends HttpServlet {

    private final OffreService offreService = new OffreService();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        HttpSession session = request.getSession(false);
        if (session == null || session.getAttribute("user") == null) {
            response.sendRedirect("login.jsp");
            return;
        }

        User user = (User) session.getAttribute("user");


        if (user.getRole() == Role.RH) {
            request.getRequestDispatcher("view/addOffre.jsp").forward(request, response);
        } else {
            request.setAttribute("errorMessage", "Vous n'êtes pas autorisé à ajouter des offres.");
            request.getRequestDispatcher("view/unauthorized.jsp").forward(request, response);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession(false);
        if (session == null || session.getAttribute("user") == null) {
            response.sendRedirect("login.jsp");
            return;
        }

        User user = (User) session.getAttribute("user");


        if (user.getRole() != Role.RH) {
            request.setAttribute("errorMessage", "Vous n'êtes pas autorisé à ajouter des offres.");
            request.getRequestDispatcher("view/unauthorized.jsp").forward(request, response);
            return;
        }

        try {

            String title = request.getParameter("title");
            String description = request.getParameter("description");
            String requirements = request.getParameter("requirements");
            LocalDate datePosted = LocalDate.now();
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
            request.setAttribute("errorMessage", "Erreur lors de l'ajout de l'offre. Vérifiez les champs et réessayez.");
            request.getRequestDispatcher("view/addOffre.jsp").forward(request, response);
        }
    }
}
