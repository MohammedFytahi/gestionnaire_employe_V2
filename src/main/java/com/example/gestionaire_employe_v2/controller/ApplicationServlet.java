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
import java.util.List;

@WebServlet(name = "ApplicationServlet", value = "/ApplicationServlet")
public class ApplicationServlet extends HttpServlet {

    private final OffreService offreService;
    private final ApplicationService applicationService;

    public ApplicationServlet() {
        this.offreService = new OffreService();
        this.applicationService = new ApplicationService();
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String skillsString = request.getParameter("skills");

        if (skillsString != null && !skillsString.isEmpty()) {
            List<String> skills = Arrays.asList(skillsString.split(","));
            for (int i = 0; i < skills.size(); i++) {
                skills.set(i, skills.get(i).trim());
            }

            System.out.println("Filtrage par compétences : " + skills);
            List<Application> applications = applicationService.filterApplicationsBySkills(skills);
            request.setAttribute("applications", applications);
        } else {
            System.out.println("Affichage de toutes les applications");
            List<Application> allApplications = applicationService.getAllApplications();
            request.setAttribute("applications", allApplications);
        }

        request.getRequestDispatcher("view/applications_list.jsp").forward(request, response);
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
            response.sendRedirect(request.getContextPath() + "/success.jsp");
        } catch (Exception e) {
            e.printStackTrace();
            response.sendRedirect(request.getContextPath() + "/error.jsp");
        }
    }
}
