package com.example.ecoleloustics.ActivityJava ;

import android.content.Intent ;
import android.os.Bundle ;
import android.view.View ;
import android.widget.TextView ;

import androidx.appcompat.app.AppCompatActivity ;

import com.example.ecoleloustics.R ;

public class ActivityMathCalculMentalResultat extends AppCompatActivity {

    public static final String NBREPONSES = "nbreponses_key" ;

    @Override
    protected void onCreate (Bundle savedInstanceState) {
        super.onCreate(savedInstanceState) ;

        // On charge le XML pour créer l'arbre graphique
        setContentView (R.layout.activity_math_calcul_mental_resultat) ;

        // Récupération du nombre de bonnes réponses à partir de l'activité précédente et de la vue associée
        int nbBonnesReponses = getIntent().getIntExtra(NBREPONSES,0) ;
        TextView calculMentalResultat_texteResultat = (TextView) findViewById(R.id.calculMentalResultat_texteResultat) ;
        String texte = "Tu as donné " + nbBonnesReponses + " réponses correctes" ;
        calculMentalResultat_texteResultat.setText(texte) ;

        // Message d'encouragement en fonction du résultat
        String texteEncouragement ;
        if (nbBonnesReponses < 10) {
            texteEncouragement = "Poursuis tes efforts" ;
        }
        else if (nbBonnesReponses < 30) {
            texteEncouragement = "C'est pas mal" ;
        }
        else if (nbBonnesReponses < 60) {
            texteEncouragement = "Félicitations !" ;
        }
        else {
            texteEncouragement = "Tu es un as !" ;
        }
        TextView calculMentalResultat_texteEncouragement = (TextView) findViewById(R.id.calculMentalResultat_texteEncouragement) ;
        calculMentalResultat_texteEncouragement.setText(texteEncouragement) ;
    }

    public void AutreExerciceCalculMental (View view) {
        Intent intentionActivityMathCalculMental = new Intent (ActivityMathCalculMentalResultat.this, ActivityMathCalculMental.class) ;
        intentionActivityMathCalculMental.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP) ;
        startActivity (intentionActivityMathCalculMental) ;
    }

    public void AutreExerciceMaths (View view) {
        Intent intentionActivityMathematiques = new Intent (ActivityMathCalculMentalResultat.this, ActivityMathematiques.class) ;
        intentionActivityMathematiques.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP) ;
        startActivity (intentionActivityMathematiques) ;
    }

    public void MenuPrincipal (View view) {
        Intent intentionActivityMenu = new Intent (ActivityMathCalculMentalResultat.this, ActivityMenu.class) ;
        intentionActivityMenu.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP) ;
        startActivity (intentionActivityMenu) ;
    }

}
