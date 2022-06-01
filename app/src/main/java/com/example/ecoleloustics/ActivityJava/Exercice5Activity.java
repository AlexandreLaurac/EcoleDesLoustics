
package com.example.ecoleloustics.ActivityJava;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.NumberPicker;

import com.example.ecoleloustics.ActivityJava.TableMultiplicationActivity;
import com.example.ecoleloustics.R;


public class Exercice5Activity extends AppCompatActivity {

    @Override
    protected void onCreate (Bundle savedInstanceState) {
        super.onCreate(savedInstanceState) ;

        // On charge le XML pour créer l'arbre graphique
        setContentView(R.layout.activity_exercice5);

        // Initialisation de la roue de nombres (tables de 1 à 9)
        NumberPicker choixNombre = findViewById (R.id.exercice5_NumberPicker) ;
        choixNombre.setMinValue(1) ;
        choixNombre.setMaxValue(9) ;
    }

    public void exercice5Valider (View view) {
        NumberPicker choixNombre = findViewById (R.id.exercice5_NumberPicker) ;
        int table = choixNombre.getValue() ;
        Intent intention = new Intent (Exercice5Activity.this, TableMultiplicationActivity.class) ;
        intention.putExtra(TableMultiplicationActivity.TABLE_KEY, table) ;
        startActivity (intention) ;
    }
}

