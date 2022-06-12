package com.example.ecoleloustics.ActivityJava;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.ecoleloustics.R;


public class ActivityCultureGeneraleIntro extends AppCompatActivity {

    public static final String THEME_CHOISI_KEY = "theme_choisi_key" ;
    private String themeChoisi ;

    @Override
    protected void onCreate (Bundle savedInstanceState) {
        super.onCreate(savedInstanceState) ;

        // On charge le XML pour créer l'arbre graphique
        setContentView (R.layout.activity_culture_generale_intro) ;

        // Récupération du thème choisi
        themeChoisi = getIntent().getStringExtra(THEME_CHOISI_KEY) ;

        // Texte d'introduction
        String texteTheme ;
        switch (themeChoisi) { // dissociation entre nom de la catégorie - et affichage du nom correspondant à l'écran
            case "histoire" :
                texteTheme = "HISTOIRE";
                break ;
            case "francais" :
                texteTheme = "FRANCAIS";
                break ;
            case "geographie" :
                texteTheme = "GEOGRAPHIE";
                break ;
            default :
                texteTheme = "aucun" ;
        }
        String texteIntro = "Tu as choisi le thème " + texteTheme + ".\nBravo à toi !\n\n" +
                "10 questions vont maintenant t'être posées. Pour chacune d'elles, tu auras trois réponses possibles.\nChoisis la bonne !" ;

        // Initialisation du texte d'introduction en fonction du thème choisi
        TextView cultureGeneraleIntro_texteIntro = (TextView) findViewById (R.id.cultureGeneraleIntro_texteIntro) ;
        cultureGeneraleIntro_texteIntro.setText(texteIntro) ;
    }

    public void onDemarrer (View view) {

        // Création d'une intention
        Intent intentionCultureGeneraleQuestions = new Intent(ActivityCultureGeneraleIntro.this, ActivityCultureGeneraleQuestions.class) ;

        // Ajout du thème choisi
        intentionCultureGeneraleQuestions.putExtra(ActivityCultureGeneraleQuestions.THEME_CHOISI_KEY, themeChoisi) ;

        // Lancement de la demande de changement d'activité
        startActivity (intentionCultureGeneraleQuestions) ;
    }

}
