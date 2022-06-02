package com.example.ecoleloustics.ActivityJava;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

import com.example.ecoleloustics.R;

public class ActivityInscription extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // On charge le XML pour créer l'arbre graphique
        setContentView(R.layout.activity_inscription);
    }
// methode vérifiant que les champs sont remplis



//methode  activant ou désactivant le bouton valider

    // si champsOk retourne true
    // dans ce cas valider passe en true et change l'état du bouton
    // si champOK retourne False
    // dans ce cas valider continue de rester en false
    // si alors toast affichant que les champs ne sont pas tous remplis


    public void onMenu(View view) {
        //verifier si champs remplis
        // si pas champ rempli toast pour signaler l'erreur
        // Création d'une intention
        Intent activityMenu = new Intent(ActivityInscription.this , ActivityMenu.class);
        // appeler méthode
        // Lancement de la demande de changement d'activité
        startActivity(activityMenu);
    }
}
