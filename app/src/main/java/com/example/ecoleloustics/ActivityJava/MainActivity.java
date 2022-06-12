package com.example.ecoleloustics.ActivityJava;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

import com.example.ecoleloustics.MonApplication;
import com.example.ecoleloustics.R;


public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState) ;
        setContentView(R.layout.activity_main) ;
    }

    public void onMenu (View view) {

        // On lance le jeu en mode visiteur, l'utilisateur courant doit être initialisé à null
        ((MonApplication) this.getApplication()).setUserCourant(null) ;

        // Création d'une intention
        Intent activityMenu = new Intent(MainActivity.this, ActivityMenu.class) ;

        // Lancement de la demande de changement d'activité
        startActivity (activityMenu) ;
    }

    public void onConnexion (View view) {

        // Création d'une intention
        Intent activityConnexion = new Intent(MainActivity.this, ActivityConnexion.class) ;

        // Lancement de la demande de changement d'activité
        startActivity (activityConnexion) ;
    }

}