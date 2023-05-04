package com.example.tas;

public class Info {
    private String id;
    private String nom;

    public Info(String id, String nom) {
        this.nom = nom;
        this.id = id;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNom() {
        return nom;
    }

    public boolean equals(String id) {
        return this.id.equals(id);
    }

    @Override
    public String toString() {
        return "Info{" +
                "id='" + id + '\'' +
                ", nom='" + nom + '\'' +
                '}';
    }

    public void setNom(String nom) {
        this.nom = nom;
    }
}
