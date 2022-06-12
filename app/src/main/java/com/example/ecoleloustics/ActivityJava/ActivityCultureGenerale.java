package com.example.ecoleloustics.ActivityJava;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

import com.example.ecoleloustics.R;


public class ActivityCultureGenerale extends AppCompatActivity {

    private String themeChoisi ;

    @Override
    protected void onCreate (Bundle savedInstanceState) {
        super.onCreate(savedInstanceState) ;

        // On charge le XML pour créer l'arbre graphique
        setContentView (R.layout.activity_culture_generale) ;
    }

    public void onFrancais (View view) {
        themeChoisi = "francais" ;
        lanceActivite() ;
    }

    public void onHistoire (View view) {
        themeChoisi = "histoire" ;
        lanceActivite() ;
    }

    public void onGeographie (View view) {
        themeChoisi = "geographie" ;
        lanceActivite() ;
    }

    public void lanceActivite () {

        // Création d'une intention
        Intent intentionCultureGeneraleIntro = new Intent(ActivityCultureGenerale.this, ActivityCultureGeneraleIntro.class) ;

        // Ajout du theme choisi à l'activité
        intentionCultureGeneraleIntro.putExtra(ActivityCultureGeneraleIntro.THEME_CHOISI_KEY, themeChoisi) ;

        // Lancement de la demande de changement d'activité
        startActivity (intentionCultureGeneraleIntro) ;
    }

}
