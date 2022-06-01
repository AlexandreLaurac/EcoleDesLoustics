package com.example.ecoleloustics.ActivityJava;




public class Multiplication {

    // Attributs
    private int operande1 ;
    private int operande2 ;

    // Constructeurs
    public Multiplication () {
        this.operande1 = 1 ;
        this.operande2 = 1 ;
    }

    public Multiplication (int operande1, int operande2) {
        this.operande1 = operande1 ;
        this.operande2 = operande2 ;
    }

    // Getters
    public int getOperande1 () {
        return operande1 ;
    }

    public int getOperande2 () {
        return operande2 ;
    }

    public int getProduit () {
        return operande1 * operande2 ;
    }

    // Setters
    public void setOperande1 (int operande1) {
        if (operande1 >= 1 && operande1 <= 9) {
            this.operande1 = operande1 ;
        }
        else {
            this.operande1 = 1 ;
        }
    }

    public void setOperande2 (int operande2) {
        if (operande2 >= 1 && operande2 <= 9) {
            this.operande2 = operande2 ;
        }
        else {
            this.operande2 = 1 ;
        }
    }

}