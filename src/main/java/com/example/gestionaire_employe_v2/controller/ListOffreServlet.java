package com.example.gestionaire_employe_v2.controller;

import com.example.gestionaire_employe_v2.model.Offre;
import com.example.gestionaire_employe_v2.service.impl.OffreService;
import com.example.gestionaire_employe_v2.service.interf.OffreServiceInterface;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;
import java.util.List;

@WebServlet(name = "ListOffreServlet", value = "/ListOffreServlet")
public class ListOffreServlet extends HttpServlet {
    private OffreServiceInterface offreService;

    public ListOffreServlet(){
        this.offreService = new OffreService();
    }
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        List<Offre> offres = null;

        try {
            offres = offreService.findAll();
        }catch (Exception e){
            e.printStackTrace();
        }

        request.setAttribute("offres", offres);

      RequestDispatcher dispatcher = request.getRequestDispatcher("view/listOffre.jsp");
      dispatcher.forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
