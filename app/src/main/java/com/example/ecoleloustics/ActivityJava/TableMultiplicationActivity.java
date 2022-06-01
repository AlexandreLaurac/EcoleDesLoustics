package com.example.ecoleloustics.ActivityJava;



import static java.lang.Integer.parseInt;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.example.ecoleloustics.R;

import java.util.ArrayList;




public class TableMultiplicationActivity extends AppCompatActivity {

    public static final String TABLE_KEY = "table_key" ;
    public static final int ERREUR_REQUEST = 0 ;
    private TableMultiplication tableMultiplication ;
    private ArrayList<EditText> resultats ;
    private int nbErreurs ;

    @Override
    protected void onCreate (Bundle savedInstanceState) {
        super.onCreate(savedInstanceState) ;
        setContentView (R.layout.activity_table_multiplication) ;

        // Layout
        LinearLayout disposition = findViewById (R.id.disposition) ;
        // Différentes lignes contenant chacune un produit de la table choisie
        int table = getIntent().getIntExtra(TABLE_KEY,1) ;
        tableMultiplication =  new TableMultiplication (table) ;
        resultats = new ArrayList<>() ;
        for (Multiplication multiplication : tableMultiplication.getMultiplications()) {
            // Création d'une ligne de calcul
            LinearLayout ligneTemp = (LinearLayout) getLayoutInflater().inflate(R.layout.template_calcul, null);
            // TextView pour l'affichage du calcul à effectuer
            TextView calcul = ligneTemp.findViewById(R.id.template_calcul) ;
            String texteCalcul = multiplication.getOperande1() + " x " + multiplication.getOperande2() + " = " ;
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
        int taille = tableMultiplication.getMultiplications().size() ;
        for (int i = 0 ; i < taille ; i++) {
            Multiplication multiplication = tableMultiplication.getMultiplications().get(i) ;
            EditText resultat = resultats.get(i) ;
            int reponseFournie =  parseInt (resultat.getText().toString()) ;
            if (reponseFournie != multiplication.getProduit()) {
                resultatComplet = false;
                nbErreurs++ ;
            }
        }
        return resultatComplet ;
    }

    public void tableMultiplicationValider (View view) {
        if (resultatsCorrects()) {  // valeurs fournies correctes
            Intent intention = new Intent(TableMultiplicationActivity.this, FelicitationActivity.class);
            startActivity (intention) ;
        } else {                    // valeurs entrées erronées
            Intent intention = new Intent(TableMultiplicationActivity.this, ErreurActivity.class);
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
