package com.example.gestionaire_employe_v2.model;

import com.example.gestionaire_employe_v2.enums.Role;
import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
@Table(name = "employees")
public class Employe extends User {
    @Column(name = "date_of_birth", nullable = false)
    private LocalDate dateOfBirth;

    @Column(name = "social_nbr", unique = true, nullable = false)
    private String socialNbr;

    @Column(name = "date_of_joining", nullable = false)
    private LocalDate dateOfJoining;

    @Column(name = "salary", nullable = false)
    private Long salary;

    @Column(name = "child_nbr", nullable = false)
    private int childNbr;

    @Column(name = "leave_balance", nullable = false)
    private Long leaveBalance;

    @Column(name = "department", nullable = false)
    private String department;

    @Column(name = "post", nullable = false)
    private String post;


    public Employe() {
        super();
    }


    public Employe(int id, String username, String email, String password, LocalDate dateOfBirth, String socialNbr, LocalDate dateOfJoining, Long salary, int childNbr, Long leaveBalance, String department, String post) {
        super(id, username, email, password, Role.EMPLOYE);
        this.dateOfBirth = dateOfBirth;
        this.socialNbr = socialNbr;
        this.dateOfJoining = dateOfJoining;
        this.salary = salary;
        this.childNbr = childNbr;
        this.leaveBalance = leaveBalance;
        this.department = department;
        this.post = post;
    }


    // Getters et Setters
    public LocalDate getDateOfBirth() {
        return dateOfBirth;
    }



    public void setDateOfBirth(LocalDate dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public String getSocialNbr() {
        return socialNbr;
    }

    public void setSocialNbr(String socialNbr) {
        this.socialNbr = socialNbr;
    }

    public LocalDate getDateOfJoining() {
        return dateOfJoining;
    }

    public void setDateOfJoining(LocalDate dateOfJoining) {
        this.dateOfJoining = dateOfJoining;
    }

    public Long getSalary() {
        return salary;
    }

    public void setSalary(Long salary) {
        this.salary = salary;
    }

    public int getChildNbr() {
        return childNbr;
    }

    public void setChildNbr(int childNbr) {
        this.childNbr = childNbr;
    }

    public Long getLeaveBalance() {
        return leaveBalance;
    }

    public void setLeaveBalance(Long leaveBalance) {
        this.leaveBalance = leaveBalance;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public String getPost() {
        return post;
    }

    public void setPost(String post) {
        this.post = post;
    }


    @Override
    public String toString() {
        return "Employe{" +
                "dateOfBirth=" + dateOfBirth +
                ", socialNbr='" + socialNbr + '\'' +
                ", dateOfJoining=" + dateOfJoining +
                ", salary=" + salary +
                ", childNbr=" + childNbr +
                ", leaveBalance=" + leaveBalance +
                ", department='" + department + '\'' +
                ", post='" + post + '\'' +
                '}';
    }
}
