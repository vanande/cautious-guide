package com.example.tas;

public class Activite {
    private String nom;
    private String description;
    private String type;


    public Activite(String nom, String description, String type) {
        this.nom = nom;
        this.description = description;
        this.type = type;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}
