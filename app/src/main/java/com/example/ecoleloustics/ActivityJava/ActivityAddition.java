package com.example.ecoleloustics.ActivityJava;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.NumberPicker;

import androidx.appcompat.app.AppCompatActivity;

import com.example.ecoleloustics.R;

public class ActivityAddition extends AppCompatActivity {

    @Override
    protected void onCreate (Bundle savedInstanceState) {
        super.onCreate(savedInstanceState) ;

        // On charge le XML pour créer l'arbre graphique
        setContentView(R.layout.activity_addition);

        // Initialisation de la roue de nombres (tables de 1 à 9)
        NumberPicker choixNombre = findViewById (R.id.activity_addition_NumberPicker) ;
        choixNombre.setMinValue(1) ;
        choixNombre.setMaxValue(9) ;
    }

    public void onValider (View view) {
        NumberPicker choixNombre = findViewById (R.id.activity_addition_NumberPicker) ;
        int table = choixNombre.getValue() ;
        Intent intention = new Intent (ActivityAddition.this, TableAdditionActivity.class) ;
        intention.putExtra(TableAdditionActivity.TABLE_KEY, table) ;
        startActivity (intention) ;
    }
}
