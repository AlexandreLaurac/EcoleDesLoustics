package com.example.ecoleloustics.ActivityJava;



import java.util.ArrayList ;
//import java.util.HashMap ;


public class TableMultiplication {

    // Attributs
    private final int table ;
    private ArrayList<Multiplication> multiplications ;

    // Constructeur
    public TableMultiplication (int table) {
        this.table = table ;

        // Initialisation de l'attribut multiplications
        multiplications = new ArrayList<>() ;
        for (int i = 1 ;  i <= 9 ; i++) {
            Multiplication temp = new Multiplication (i,table) ;
            multiplications.add(temp) ;
        }
    }

    // Getters
    public ArrayList<Multiplication> getMultiplications () {
        return multiplications ;
    }

    public int getTable () {
        return table ;
    }


}
