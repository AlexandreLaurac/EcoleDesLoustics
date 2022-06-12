package com.example.ecoleloustics.ActivityJava;

import java.util.Random;

public class CalculMental {

    private int operande1 ;
    private int operande2 ;
    private int codeOperator;


    // Constructeurs
    public CalculMental(int codeOperator){

        this.operande1 = genererNbr();
        this.operande2 = genererNbr();
        this.codeOperator = codeOperator;
    }

    public int genererNbr() {

        Random random = new Random();
        int nbrMin = 1;
        int nbrMax = 10;
        int operande = nbrMin + random.nextInt(nbrMax - nbrMin);
        return operande;
    }

    public int getOperande1 () {
        return operande1 ;
    }

    public int getOperande2 () {
        return operande2 ;
    }

    public int getOperation () {

        if (this.getCodeOperator() == 1){
            return operande1 + operande2 ;
        }
        else{
            return operande1 * operande2;
        }
    }

    public int getCodeOperator(){
        return codeOperator;
    }



}

