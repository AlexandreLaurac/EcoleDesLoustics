package com.example.ecoleloustics.ActivityJava;

import java.util.ArrayList;

public class TableAddition {

    // Attributs
    private final int table;
    private ArrayList<Addition> additions;

    // Constructeur
    public TableAddition(int table) {
        this.table = table;

        // Initialisation de l'attribut additions
        additions = new ArrayList<>();
        for (int i = 1; i <= 9; i++) {
            Addition temp = new Addition(i, table);
            additions.add(temp);
        }
    }

    // Getters
    public ArrayList<Addition> getAdditions () {
        return additions ;
    }

    public int getTable () {
        return table ;
    }
}


