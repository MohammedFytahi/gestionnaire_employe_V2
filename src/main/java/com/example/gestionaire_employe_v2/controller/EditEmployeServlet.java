package com.example.gestionaire_employe_v2.controller;

import com.example.gestionaire_employe_v2.enums.Role;
import com.example.gestionaire_employe_v2.model.Employe;
import com.example.gestionaire_employe_v2.service.impl.EmployeService;
import com.example.gestionaire_employe_v2.service.interf.EmployeServiceInterface;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.time.LocalDate;

    @WebServlet(name = "editEmploye", value = "/editEmploye")
public class EditEmployeServlet extends HttpServlet {

    private final EmployeServiceInterface employeService = new EmployeService();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        Long id = Long.parseLong(request.getParameter("id"));


        Employe employe = employeService.trouverParId(id);


        request.setAttribute("employe", employe);
        RequestDispatcher dispatcher = request.getRequestDispatcher("view/editEmploye.jsp");
        dispatcher.forward(request, response);
    }



    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {

            Long id = Long.parseLong(request.getParameter("id"));
            String username = request.getParameter("username");
            String email = request.getParameter("email");
            String password = request.getParameter("password");
            String roleParam = request.getParameter("role");
            LocalDate dateOfBirth = LocalDate.parse(request.getParameter("dateOfBirth"));
            String socialNbr = request.getParameter("socialNbr");
            LocalDate dateOfJoining = LocalDate.parse(request.getParameter("dateOfJoining"));
            Long salary = Long.parseLong(request.getParameter("salary"));
            int childNbr = Integer.parseInt(request.getParameter("childNbr"));
            Long leaveBalance = Long.parseLong(request.getParameter("leaveBalance"));
            String department = request.getParameter("department");
            String post = request.getParameter("post");


            Employe employe = employeService.trouverParId(id);
            employe.setUsername(username);
            employe.setEmail(email);
            employe.setPassword(password);
            employe.setRole(Role.valueOf(roleParam));
            employe.setDateOfBirth(dateOfBirth);
            employe.setSocialNbr(socialNbr);
            employe.setDateOfJoining(dateOfJoining);
            employe.setSalary(salary);
            employe.setChildNbr(childNbr);
            employe.setLeaveBalance(leaveBalance);
            employe.setDepartment(department);
            employe.setPost(post);


            employeService.updateEmploye(employe);


            response.sendRedirect(request.getContextPath() + "/listEmploye");
        } catch (Exception e) {
            e.printStackTrace();
            response.sendRedirect("error.jsp");
        }
    }
}
