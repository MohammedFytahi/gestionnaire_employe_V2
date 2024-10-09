package com.example.gestionaire_employe_v2.model;

import jakarta.persistence.*;
import java.util.List;

@Entity
@Table(name = "applications")
public class Application {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "condidateName")
    private String condidateName;

    @Column(name = "email")
    private String email;

    // Use @ElementCollection to store multiple skills
    @ElementCollection
    @CollectionTable(name = "application_skills", joinColumns = @JoinColumn(name = "application_id"))
    @Column(name = "skill")
    private List<String> skills;


    public Application(){

    }

    public Application(String condidateName, String email, List<String> skills) {
        this.condidateName = condidateName;
        this.email = email;
        this.skills = skills;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCondidateName() {
        return condidateName;
    }

    public void setCondidateName(String condidateName) {
        this.condidateName = condidateName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public List<String> getSkills() {
        return skills;
    }

    public void setSkills(List<String> skills) {
        this.skills = skills;
    }
}
