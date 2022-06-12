package com.example.ecoleloustics.ActivityJava;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.ecoleloustics.R;

public class ActivityMathCalculMentalOpResult extends AppCompatActivity {

    public static final String RESULT_KEY = "result_key";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_math_calcul_mental_operation_resultat);

        int nbrJuste = getIntent().getIntExtra(RESULT_KEY, 0);
        TextView avisView = (TextView) findViewById(R.id.math_10_ope_result_avis1);
        TextView resultView = (TextView) findViewById(R.id.math_10_ope_result_resultats);
        String resultS = nbrJuste + " réponses justes";
        resultView.setText(resultS);
        if(nbrJuste == 10){
            String message = "Félicitation tu as  tout  juste !! ";
            avisView.setText(message);
        }
        else{
            String message = "Encore quelques efforts ! Recommences l'exercice ! ";
            avisView.setText(message);
            Button button = (Button) findViewById(R.id.math_10_ope_result_changer);
            button.setVisibility(View.INVISIBLE);
        }
    }
    public void onRefaireExo(View view){

        Intent intent = new Intent(ActivityMathCalculMentalOpResult.this, ActivityMathematiques.class);
        startActivity(intent);
    }
}
