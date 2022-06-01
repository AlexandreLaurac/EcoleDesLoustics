package com.example.ecoleloustics.Model;

public class Utilisateur {

    //attributs

    private String name;
    private String prenom;

    //constructeurs


    public Utilisateur(String name, String prenom) {
        this.name = name;
        this.prenom = prenom;
    }

    //méthodes


    public String getName() {
        return name;
    }

    public String getPrenom() {
        return prenom;
    }
}
