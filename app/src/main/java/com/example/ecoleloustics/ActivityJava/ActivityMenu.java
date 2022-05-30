package com.example.ecoleloustics.ActivityJava;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.view.View;

import com.example.ecoleloustics.R;

public class ActivityMenu extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // On charge le XML pour créer l'arbre graphique
        setContentView(R.layout.activity_menu);

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
