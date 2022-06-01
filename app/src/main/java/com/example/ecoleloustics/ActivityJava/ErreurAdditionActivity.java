package com.example.ecoleloustics.ActivityJava;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.ecoleloustics.R;

public class ErreurAdditionActivity extends AppCompatActivity {

    public static final String ERREUR_KEY = "erreur_key" ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState) ;
        setContentView(R.layout.activity_addition_erreur) ;

        // Récupération et affichage du nombre d'erreurs
        TextView erreur_NombreErreurs = findViewById (R.id.erreur_addition_NombreErreurs) ;
        int nbErreurs = getIntent().getIntExtra(ERREUR_KEY,9) ;
        String message = "Nombre d'erreurs : " + nbErreurs ;
        erreur_NombreErreurs.setText(message) ;
    }

    public void erreurCorrigerErreurs (View view) {
        setResult (RESULT_OK) ;
        super.finish() ;
    }

    public void erreurChoisirTable (View view) {
        Intent intention = new Intent(ErreurAdditionActivity.this, TableAdditionActivity.class) ;
        intention.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP) ;
        startActivity (intention) ;
    }

}
