package com.example.ecoleloustics.Model.db;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

import java.io.Serializable;

@Entity
public class Question implements Serializable {

    @PrimaryKey(autoGenerate = true)
    private int id ;

    @ColumnInfo(name = "categorie")
    private String categorie ;

    @ColumnInfo(name = "intitule")
    private String intitule ;

    @ColumnInfo(name = "reponse1") // Par convention, il s'agit de la bonne réponse
    private String reponse1 ;

    @ColumnInfo(name = "reponse2")
    private String reponse2 ;

    @ColumnInfo(name = "reponse3")
    private String reponse3 ;

    /*
     * Getters and Setters
     * */
    public int getId() {
        return id ;
    }

    public void setId (int id) {
        this.id = id ;
    }

    public String getCategorie() {
        return categorie ;
    }

    public void setCategorie (String categorie) {
        this.categorie = categorie ;
    }

    public String getIntitule() {
        return intitule ;
    }

    public void setIntitule (String intitule) {
        this.intitule = intitule ;
    }

    public String getReponse1() {
        return reponse1 ;
    }

    public void setReponse1 (String reponse1) {
        this.reponse1 = reponse1 ;
    }

    public String getReponse2() {
        return reponse2 ;
    }

    public void setReponse2 (String reponse2) {
        this.reponse2 = reponse2 ;
    }

    public String getReponse3() {
        return reponse3 ;
    }

    public void setReponse3 (String reponse3) {
        this.reponse3 = reponse3 ;
    }

}
