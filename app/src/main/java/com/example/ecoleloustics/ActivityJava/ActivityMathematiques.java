package com.example.ecoleloustics.ActivityJava;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.ecoleloustics.R;


public class ActivityMathematiques extends AppCompatActivity{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // On charge le XML pour créer l'arbre graphique
        setContentView(R.layout.activity_mathematiques);

    }

    public void onMultiplication(View view) {

        // Création d'une intention
        Intent activityMultiplication= new Intent(ActivityMathematiques.this, Exercice5Activity.class);

        // Lancement de la demande de changement d'activité
        startActivity(activityMultiplication);
    }





}