package com.example.ecoleloustics.ActivityJava;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.ecoleloustics.MonApplication;
import com.example.ecoleloustics.R;


public class ActivityMenu extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // On charge le XML pour créer l'arbre graphique
        setContentView(R.layout.activity_menu);

        // Récupération du prénom de l'utilisateur courant et affichage d'un message de bienvenue adapté
        String prenom = ((MonApplication) this.getApplication()).getUserCourant().getPrenom() ;
        TextView messageIntro = (TextView) findViewById (R.id.menu_messageIntro) ;
        String message = "Bonjour " + prenom + " !" ;
        messageIntro.setText(message) ;
    }

    public void onParcours(View view) {

        // Création d'une intention
        Intent activityParcours = new Intent(ActivityMenu.this, ActivityParcours.class);

        // Lancement de la demande de changement d'activité
        startActivity(activityParcours);
    }

    public void onMathematiques(View view) {

        // Création d'une intention
        Intent activityMathematiques = new Intent(ActivityMenu.this, ActivityMathematiques.class);

        // Lancement de la demande de changement d'activité
        startActivity(activityMathematiques);
    }

    public void onCultureGe(View view) {

        // Création d'une intention
        Intent activityCultureGe = new Intent(ActivityMenu.this, ActivityCultureGenerale.class);

        // Lancement de la demande de changement d'activité
        startActivity(activityCultureGe);
    }


}
