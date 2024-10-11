package com.example.gestionaire_employe_v2.model;

import com.example.gestionaire_employe_v2.enums.Statut;
import jakarta.persistence.*;
import java.time.LocalDate;
import java.util.List;

@Entity
@Table(name = "offre")
public class Offre {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "title")
    private String title;

    @Column(name = "description")
    private String description;

    @Column(name = "requirements")
    private String requirements;

    @Column(name = "datePosted")
    private LocalDate datePosted;

    @Column(name = "validity_periode")
    private LocalDate validityPeriode;

    @Enumerated(EnumType.STRING)
    @Column(name = "statut")
    private Statut statut;

    // One offer can have many applications
    @OneToMany(mappedBy = "offre", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Application> applications;

    public Offre() {}

    public Offre(String title, String description, String requirements, LocalDate datePosted, LocalDate validityPeriode, Statut statut) {
        this.title = title;
        this.description = description;
        this.requirements = requirements;
        this.datePosted = datePosted;
        this.validityPeriode = validityPeriode;
        this.statut = statut;
    }



    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getRequirements() {
        return requirements;
    }

    public void setRequirements(String requirements) {
        this.requirements = requirements;
    }

    public LocalDate getDatePosted() {
        return datePosted;
    }

    public void setDatePosted(LocalDate datePosted) {
        this.datePosted = datePosted;
    }

    public LocalDate getValidityPeriode() {
        return validityPeriode;
    }

    public void setValidityPeriode(LocalDate validityPeriode) {
        this.validityPeriode = validityPeriode;
    }

    public Statut getStatut() {
        return statut;
    }

    public void setStatut(Statut statut) {
        this.statut = statut;
    }

    public List<Application> getApplications() {
        return applications;
    }

    public void setApplications(List<Application> applications) {
        this.applications = applications;
    }
}
