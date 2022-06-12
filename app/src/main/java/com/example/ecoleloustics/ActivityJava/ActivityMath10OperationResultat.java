package com.example.ecoleloustics.ActivityJava;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.ecoleloustics.R;

public class ActivityMath10OperationResultat extends AppCompatActivity {

    public static final String RESULT_KEY = "result_key";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_math_10_operation_resultat);

        int nbrJuste = getIntent().getIntExtra(RESULT_KEY, 0);
        TextView avisView = (TextView) findViewById(R.id.math_10_ope_result_avis1);
        TextView resultView = (TextView) findViewById(R.id.math_10_ope_result_resultats);
        String resultS = "Tu as donné " + nbrJuste + " bonnes réponses sur 10" ;
        resultView.setText(resultS) ;

        String texteEncouragement ;
        if (nbrJuste < 5) {
            texteEncouragement = "Poursuis tes efforts" ;
        }
        else if (nbrJuste < 7) {
            texteEncouragement = "C'est pas mal" ;
        }
        else if (nbrJuste < 9) {
            texteEncouragement = "Félicitations !" ;
        }
        else {
            texteEncouragement = "Tu es un as !" ;
            resultS = "Tu as donné toutes les bonnes réponses !" ;
            resultView.setText(resultS) ;
        }
        avisView.setText(texteEncouragement) ;

    }

    public void onRefaireExo(View view) {
        Intent intent = new Intent(ActivityMath10OperationResultat.this, ActivityMath10Operation.class);
        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP) ;
        startActivity(intent);
    }

    public void onAutreExerciceMaths(View view) {
        Intent intent = new Intent(ActivityMath10OperationResultat.this, ActivityMathematiques.class);
        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP) ;
        startActivity(intent);
    }

    public void onMenuPrincipal(View view) {
        Intent intent = new Intent(ActivityMath10OperationResultat.this, ActivityMenu.class);
        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP) ;
        startActivity(intent);
    }


}



