package com.example.gestionaire_employe_v2.controller;

import com.example.gestionaire_employe_v2.model.Application;
import com.example.gestionaire_employe_v2.model.Offre;
import com.example.gestionaire_employe_v2.service.impl.ApplicationService;
import com.example.gestionaire_employe_v2.service.impl.OffreService;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;
import java.util.Arrays;

@WebServlet(name = "AddApplicationServlet", value = "/AddApplicationServlet")
public class AddApplicationServlet extends HttpServlet {

    private final OffreService offreService;
    private  ApplicationService applicationService;

    public AddApplicationServlet() {
        this.offreService = new OffreService();
        this.applicationService =new ApplicationService();
    }
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String offreIdParam = request.getParameter("offreId");

        if (offreIdParam != null) {
            int offreId = Integer.parseInt(offreIdParam);


            Offre offre = offreService.findById(offreId);


            request.setAttribute("offre", offre);


            request.getRequestDispatcher("view/apply.jsp").forward(request, response);
        } else {

            response.sendError(HttpServletResponse.SC_BAD_REQUEST, "L'offre n'existe pas.");
        }
    }
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String candidateName = request.getParameter("candidateName");
        String email = request.getParameter("email");
        String skillsString = request.getParameter("skills");
        String offreIdParam = request.getParameter("offreId");

        if (candidateName == null || email == null || skillsString == null || offreIdParam == null) {
            response.sendError(HttpServletResponse.SC_BAD_REQUEST, "Paramètres manquants.");
            return;
        }

        String[] skillsArray = skillsString.split(",");
        for (int i = 0; i < skillsArray.length; i++) {
            skillsArray[i] = skillsArray[i].trim();
        }

        int offreId = Integer.parseInt(offreIdParam);
        Offre offre = offreService.findById(offreId);
        if (offre == null) {
            response.sendError(HttpServletResponse.SC_BAD_REQUEST, "Offre introuvable.");
            return;
        }

        Application application = new Application(candidateName, email, Arrays.asList(skillsArray), offre);

        try {
            applicationService.saveApplication(application);
            response.sendRedirect(request.getContextPath() + "/ApplicationServlet");
        } catch (Exception e) {
            e.printStackTrace();
            response.sendRedirect(request.getContextPath() + "/error.jsp");
        }
    }

}