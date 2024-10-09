package com.example.gestionaire_employe_v2.model;

import com.example.gestionaire_employe_v2.enums.Statut;
import jakarta.persistence.*;

import java.time.LocalDate;

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
    @Column(name = "dataPosted")
    private LocalDate datePosted;

    @Column(name = "validity_periode")
    private LocalDate validity_periode;

    @Enumerated(EnumType.STRING)
    @Column(name = "statut")
    private Statut statut;


    public Offre(){

    }
    public Offre(String title, String description, String requirements, LocalDate datePosted, LocalDate validity_periode, Statut statut) {
        this.title = title;
        this.description = description;
        this.requirements = requirements;
        this.datePosted = datePosted;
        this.validity_periode = validity_periode;
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

    public LocalDate getValidity_periode() {
        return validity_periode;
    }

    public void setValidity_periode(LocalDate validity_periode) {
        this.validity_periode = validity_periode;
    }

    public Statut getStatut() {
        return statut;
    }

    public void setStatut(Statut statut) {
        this.statut = statut;
    }

    @Override
    public String toString() {
        return "Offre{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", description='" + description + '\'' +
                ", requirements='" + requirements + '\'' +
                ", datePosted=" + datePosted +
                ", validity_periode=" + validity_periode +
                ", statut=" + statut +
                '}';
    }
}
