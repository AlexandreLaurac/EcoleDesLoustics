package com.example.ecoleloustics.ActivityJava;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.ecoleloustics.Model.db.User;
import com.example.ecoleloustics.MonApplication;
import com.example.ecoleloustics.R;


public class ActivityMenu extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


        // On charge le XML pour créer l'arbre graphique
        setContentView(R.layout.activity_menu);

        // Récupération de l'utilisateur courant et affichage d'un message de bienvenue adapté
        User userCourant = ((MonApplication) this.getApplication()).getUserCourant() ;
        String prenom ;
        if (userCourant != null) {
            prenom = userCourant.getPrenom() ;
        }
        else {
            prenom = "cher visiteur" ;
        }
        TextView messageIntro = (TextView) findViewById (R.id.menu_messageIntro) ;
        String message = "Bonjour " + prenom + " !" ;
        messageIntro.setText(message) ;

        // On cache le bouton parcours, fonctionnalité non mise en oeuvre faute de temps
        Button button = (Button) findViewById(R.id.menu_parcours) ;
        button.setVisibility(View.INVISIBLE) ;
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
