package com.example.tas;

import java.util.ArrayList;
import java.util.List;

public class Burger {

    private String nom, ingredients;
    private float prix;

    public Burger(String nom, String ingredients, float prix) {
        this.nom = nom;
        this.ingredients = ingredients;
        this.prix = prix;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getIngredients() {
        return ingredients;
    }

    public void setIngredients(String ingredients) {
        this.ingredients = ingredients;
    }

    public float getPrix() {
        return prix;
    }

    public void setPrix(float prix) {
        this.prix = prix;
    }



}
