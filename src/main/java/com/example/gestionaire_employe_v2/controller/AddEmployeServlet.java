package com.example.gestionaire_employe_v2.controller;

import com.example.gestionaire_employe_v2.enums.Role;
import com.example.gestionaire_employe_v2.model.Employe;
import com.example.gestionaire_employe_v2.repository.impl.EmployeRepository;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.time.LocalDate;

@WebServlet(name = "addEmploye",value = "/addEmploye")
public class AddEmployeServlet extends HttpServlet {

    private final EmployeRepository employeRepository = new EmployeRepository();

    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        RequestDispatcher Dispatcher = request.getRequestDispatcher("view/ajouterEmploye.jsp");
        Dispatcher.forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {

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


            Employe newEmploye = new Employe();
            newEmploye.setUsername(username);
            newEmploye.setEmail(email);
            newEmploye.setPassword(password);
            newEmploye.setRole(Role.valueOf(roleParam)); // Convert role from string to enum
            newEmploye.setDateOfBirth(dateOfBirth);
            newEmploye.setSocialNbr(socialNbr);
            newEmploye.setDateOfJoining(dateOfJoining);
            newEmploye.setSalary(salary);
            newEmploye.setChildNbr(childNbr);
            newEmploye.setLeaveBalance(leaveBalance);
            newEmploye.setDepartment(department);
            newEmploye.setPost(post);


            employeRepository.addEmploye(newEmploye);


            response.sendRedirect("view/ajouterEmploye.jsp");
        } catch (Exception e) {

            e.printStackTrace();

        }
    }
}
