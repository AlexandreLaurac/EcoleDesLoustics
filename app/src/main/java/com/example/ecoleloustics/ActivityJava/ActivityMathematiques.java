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

    public void onTableAddition(View view) {


        Intent activityTableAddi = new Intent(ActivityMathematiques.this, ActivityAddition.class);
        startActivity(activityTableAddi);
    }

    public void onTableMultiplication(View view) {
        Intent activityTableMulti = new Intent(ActivityMathematiques.this, Exercice5Activity.class);
        startActivity(activityTableMulti);
    }

    //codeOperator 1 pour les additions
    public void on10Addition(View view) {
        int codeOperator = 1;

        Intent activity10Operation = new Intent(ActivityMathematiques.this, ActivityMath10Operation.class);
        activity10Operation.putExtra(ActivityMath10Operation.RESULT_KEY, codeOperator);
        startActivity(activity10Operation);
    }
    //codeOperator 2 pour les multiplications
    public void on10Multiplication(View view) {
        int codeOperator = 2;

        Intent activity10Operation = new Intent(ActivityMathematiques.this, ActivityMath10Operation.class);
        activity10Operation.putExtra(ActivityMath10Operation.RESULT_KEY, codeOperator);
        startActivity(activity10Operation);
    }

    public void onCalculMental(View view) {
        Intent activityCalculMental = new Intent(ActivityMathematiques.this, ActivityMathCalculMental.class);
        startActivity(activityCalculMental);
    }






}