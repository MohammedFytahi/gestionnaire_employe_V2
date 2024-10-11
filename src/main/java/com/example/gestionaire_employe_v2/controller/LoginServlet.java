package com.example.gestionaire_employe_v2.controller;

import com.example.gestionaire_employe_v2.model.User;
import com.example.gestionaire_employe_v2.service.impl.UserService;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;

@WebServlet("/login")
public class LoginServlet extends HttpServlet {
    private final UserService userService = new UserService();

    @Override
    protected  void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
        request.getRequestDispatcher("/view/login.jsp").forward(request, response);

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String email = request.getParameter("email");
        String password = request.getParameter("password");

        // Authentifier l'utilisateur
        User user = userService.authenticate(email, password);

        if (user != null) {
            // Authentification réussie, créer une session
            HttpSession session = request.getSession();
            session.setAttribute("user", user);

            // Rediriger en fonction du rôle de l'utilisateur
            switch (user.getRole()) {
                case ADMIN:
                    response.sendRedirect(request.getContextPath() + "/listEmploye");
                    break;
                case RH:
                    response.sendRedirect("view/rhHome.jsp");
                    break;
                case EMPLOYE:
                    response.sendRedirect("view/listEmploye.jsp");
                    break;
                default:
                    response.sendRedirect("home.jsp");
                    break;
            }
        } else {
            // Authentification échouée, rediriger vers la page de connexion avec un message d'erreur
            request.setAttribute("errorMessage", "Email ou mot de passe incorrect.");
            request.getRequestDispatcher("login.jsp").forward(request, response);
        }
    }
}
