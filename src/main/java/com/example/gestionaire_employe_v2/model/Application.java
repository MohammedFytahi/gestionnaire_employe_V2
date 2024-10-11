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
    private String candidateName;

    @Column(name = "email")
    private String email;


    @ElementCollection
    @CollectionTable(name = "application_skills", joinColumns = @JoinColumn(name = "application_id"))
    @Column(name = "skill")
    private List<String> skills;


    @ManyToOne
    @JoinColumn(name = "offre_id")
    private Offre offre;

    public Application() {}

    public Application(String candidateName, String email, List<String> skills, Offre offre) {
        this.candidateName = candidateName;
        this.email = email;
        this.skills = skills;
        this.offre = offre;
    }

    // Getters and Setters

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCandidateName() {
        return candidateName;
    }

    public void setCandidateName(String candidateName) {
        this.candidateName = candidateName;
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

    public Offre getOffre() {
        return offre;
    }

    public void setOffre(Offre offre) {
        this.offre = offre;
    }
}
