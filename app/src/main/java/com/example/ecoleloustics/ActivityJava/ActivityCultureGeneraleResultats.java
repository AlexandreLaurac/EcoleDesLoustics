package com.example.ecoleloustics.ActivityJava;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.ecoleloustics.R;


public class ActivityCultureGeneraleResultats extends AppCompatActivity {

    public static final String NBREPONSES = "nbreponses_key" ;
    public static final String NBQUESTIONS = "nbquestions_key" ;

    @Override
    protected void onCreate (Bundle savedInstanceState) {
        super.onCreate(savedInstanceState) ;

        // On charge le XML pour créer l'arbre graphique
        setContentView (R.layout.activity_culture_generale_resultats) ;

        // Récupération des "paramètres" de l'activité précédente et des vues
        int nbBonnesReponses = getIntent().getIntExtra(NBREPONSES,1) ;
        int nbQuestions = getIntent().getIntExtra(NBQUESTIONS, 10) ;
        TextView cultureGeneraleResultats_texteResultat = (TextView) findViewById(R.id.cultureGeneraleResultats_texteResultat) ;
        TextView cultureGeneraleResultats_texteEncouragement = (TextView) findViewById(R.id.cultureGeneraleResultats_texteEncouragement) ;
        String texte = "Tu as donné " + nbBonnesReponses + " bonnes réponses sur " + nbQuestions ;
        cultureGeneraleResultats_texteResultat.setText(texte) ;
        String texteEncouragement ;
        if (nbBonnesReponses < 5) {
            texteEncouragement = "Poursuis tes efforts" ;
        }
        else if (nbBonnesReponses < 7) {
            texteEncouragement = "C'est pas mal" ;
        }
        else if (nbBonnesReponses < 9) {
            texteEncouragement = "Félicitations !" ;
        }
        else {
            texteEncouragement = "Tu es un as !" ;
            texte = "Tu as donné toutes les bonnes réponses !" ;
            cultureGeneraleResultats_texteResultat.setText(texte) ;
        }
        cultureGeneraleResultats_texteEncouragement.setText(texteEncouragement) ;
    }

    public void AutreTheme (View view) {
        Intent intentionActivityCultureGenerale = new Intent (ActivityCultureGeneraleResultats.this, ActivityCultureGenerale.class) ;
        intentionActivityCultureGenerale.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP) ;
        startActivity (intentionActivityCultureGenerale) ;
    }

    public void MenuPrincipal (View view) {
        Intent intentionActivityMenu = new Intent (ActivityCultureGeneraleResultats.this, ActivityMenu.class) ;
        intentionActivityMenu.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP) ;
        startActivity (intentionActivityMenu) ;
    }


}


