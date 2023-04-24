package com.example.tas;

public class Activite {
    private String nom;
    private String description;
    private String[] type;
    private String image;


    public Activite(String nom, String description, String[] type, String image) {
        this.nom = nom;
        this.description = description;
        this.type = type;
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


    public void setType(String[] type) {
        this.type = type;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }
}
