package com.example.ecoleloustics.ActivityJava;

import static java.lang.Integer.parseInt;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.example.ecoleloustics.R;

import java.util.ArrayList;

public class TableAdditionActivity extends AppCompatActivity {

    public static final String TABLE_KEY = "table_key" ;
    public static final int ERREUR_REQUEST = 0 ;
    private TableAddition tableAddition ;
    private ArrayList<EditText> resultats ;
    private int nbErreurs ;

    @Override
    protected void onCreate (Bundle savedInstanceState) {
        super.onCreate(savedInstanceState) ;
        setContentView (R.layout.activity_table_addition) ;

        // Layout
        LinearLayout disposition = findViewById (R.id.disposition) ;
        // Différentes lignes contenant chacune une addition de la table choisie
        int table = getIntent().getIntExtra(TABLE_KEY,1) ;
        tableAddition =  new TableAddition (table) ;
        resultats = new ArrayList<>() ;
        for (Addition addition : tableAddition.getAdditions()) {
            // Création d'une ligne de calcul
            LinearLayout ligneTemp = (LinearLayout) getLayoutInflater().inflate(R.layout.template_calcul, null);
            // TextView pour l'affichage du calcul à effectuer
            TextView calcul = ligneTemp.findViewById(R.id.template_calcul) ;
            String texteCalcul = addition.getOperande1() + " + " + addition.getOperande2() + " = " ;
            calcul.setText(texteCalcul) ;
            // EditText pour la saisie du résultat
            EditText resultat = ligneTemp.findViewById(R.id.template_resultat) ;

            resultats.add(resultat) ;
            // Ajout de la ligne à la vue
            disposition.addView(ligneTemp) ;
        }
    }

    public boolean resultatsCorrects () {
        nbErreurs = 0 ;
        boolean resultatComplet = true ;
        int taille = tableAddition.getAdditions().size() ;
        for (int i = 0 ; i < taille ; i++) {
            Addition addition = tableAddition.getAdditions().get(i) ;
            EditText resultat = resultats.get(i) ;
            int reponseFournie =  parseInt (resultat.getText().toString()) ;
            if (reponseFournie != addition.getSomme()) {
                resultatComplet = false;
                nbErreurs++ ;
            }
        }
        return resultatComplet ;
    }
    //methode pour verifier tous les champs sont complets
    public void tableAdditionValider (View view) {
        if (resultatsCorrects()) {  // valeurs fournies correctes
            Intent intention = new Intent(TableAdditionActivity.this, FelicitationAdditionActivity.class);
            startActivity (intention) ;
        } else {                    // valeurs entrées erronées
            Intent intention = new Intent(TableAdditionActivity.this, ErreurAdditionActivity.class);
            intention.putExtra(ErreurActivity.ERREUR_KEY, nbErreurs) ;
            startActivityForResult (intention, ERREUR_REQUEST) ;
        }
    }

    @Override
    protected void onActivityResult (int requestCode, int resultCode, @Nullable Intent data) {
        // Vérification du retour à l'aide du code requête
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == ERREUR_REQUEST) {
            // Etat de retour ok
            if (resultCode == RESULT_OK) {
                Toast.makeText(this, "Retour par bouton VALIDER", Toast.LENGTH_SHORT).show();
            }
            // Etat de retour canceled
            else if (resultCode == RESULT_CANCELED) {
                Toast.makeText(this, "Retour par cancel/back", Toast.LENGTH_SHORT).show();
            }
        }
    }


}
