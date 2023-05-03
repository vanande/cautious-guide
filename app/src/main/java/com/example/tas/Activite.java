package com.example.tas;

public class Activite {

    private String nom, description, image;

    public Activite(String nom, String description, String image) {
        this.nom = nom;
        this.description = description;
        this.image = image;
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

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

}
