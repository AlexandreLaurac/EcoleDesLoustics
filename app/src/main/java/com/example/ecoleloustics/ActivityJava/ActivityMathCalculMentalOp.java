package com.example.ecoleloustics.ActivityJava;

import android.content.Intent;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.os.Handler;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.ecoleloustics.R;

import java.sql.Time;

public class ActivityMathCalculMentalOp extends AppCompatActivity {

    public static final String RESULT_KEY_M = "result_key";
    private int repJuste = 0;
    private CalculMental calculMental;
    private int codeOperator;
    private CountDownTimer countDownTimer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_math_calcul_mental_operation);

        //recuperation du code l'operator
        codeOperator = getIntent().getIntExtra(RESULT_KEY_M, 0 );

        calculMental = new CalculMental(codeOperator);

        //on genere l'operande 1 à l'ouverture de l'activite
        int operande1 = calculMental.getOperande1();
        String op1 = String.valueOf(operande1);
        TextView op1View = (TextView) findViewById(R.id.math_mental_first_op);
        op1View.setText(op1);

        //on genere l'operande 2 à l'ouverture de l'activite
        int operande2 = calculMental.getOperande2();
        String op2 = String.valueOf(operande2);
        TextView op2View = (TextView) findViewById(R.id.math_mental_second_op);
        op2View.setText(op2);

        //compteur initiliser à 1 car methode genere pas encore initialiser
        TextView compteurView = (TextView) findViewById(R.id.math_mental_compteur);
        compteurView.setText("0");

        //adapter le titre
        TextView titreView = (TextView) findViewById(R.id.math_mental_type_op);

        //recuperer le texte affichant l'operator
        TextView operatorView = (TextView) findViewById(R.id.math_mental_operator);

        //selon l'operator on le met à jour
        if(codeOperator == 1)
        {
            //faire l'addition et adapter titre à l'addition
            operatorView.setText("+");
            titreView.setText("Calcul mental Additions");
        }
        else
        {
            //faire la multiplication
            operatorView.setText("x");
            titreView.setText("Calcul mental Multiplications");
        }
        TextView timeView = (TextView) findViewById(R.id.time);
        timeView.setText("60");
        start();

        //le bouton est lié et on lie clickListener dessus
        Button valider = findViewById(R.id.math_calcul_mental_valider);
        valider.setOnClickListener(this::onClick);
    }

    public void onClick(View v) {

        EditText resultatView = (EditText) findViewById(R.id.math_mental_resultat);
        String resultatMentS = resultatView.getText().toString().trim();

        if (resultatMentS.isEmpty()){
            Toast.makeText(ActivityMathCalculMentalOp.this, "N'oublies pas ton résultat !!", Toast.LENGTH_LONG).show();
        }
        else if (siJuste(resultatMentS)){
            genere();
            viderResult();
        }


    }

    public void genere(){


        // génére les deux opérandes aléatoirement à chaque clic
        calculMental = new CalculMental(codeOperator);
        int operande1 = calculMental.getOperande1();
        String op1 = String.valueOf(operande1);
        TextView op1View = (TextView) findViewById(R.id.math_mental_first_op);
        op1View.setText(op1);

        int operande2 = calculMental.getOperande2();
        String op2 = String.valueOf(operande2);
        TextView op2View = (TextView) findViewById(R.id.math_mental_second_op);
        op2View.setText(op2);

    }



    //vide l'éditText pour l'opération suivante
    public void viderResult(){

        TextView resultView = findViewById(R.id.math_mental_resultat);
        resultView.setText("");

    }

    public void start(){
        TextView timeView = (TextView) findViewById(R.id.time);
        countDownTimer  = new CountDownTimer(60 * 1000, 1000){
            @Override
            public void onTick(long millisUntilFinished) {
                timeView.setText("" + millisUntilFinished / 1000 + " sec rest");
            }

            @Override
            public void onFinish() {
                timeView.setText("Fin du temps");
                Intent finOperation = new Intent(ActivityMathCalculMentalOp.this, ActivityMathCalculMentalOpResult.class);
                //finOperation.putExtra(ActivityMath10OperationResultat.RESULT_KEY, repJuste);
                startActivity(finOperation);
            }
        };

        countDownTimer.start();
    }

    public boolean siJuste(String resultatS){

        int result = Integer.parseInt(resultatS);
        boolean etatRep = false;

        if(calculMental.getOperation() == result){
            repJuste++;
            //affiche l'incrementation le compteur
            TextView CompteurView = (TextView) findViewById(R.id.math_mental_compteur);
            String compteurS = String.valueOf(repJuste);
            CompteurView.setText(compteurS + "");
            Toast.makeText(getApplicationContext(), "REPONSE BONNE!!" , Toast.LENGTH_LONG).show();
            etatRep = true;
        }
        else
        {

            Toast.makeText(getApplicationContext(), "REPONSE FAUSSE!!\nRecommences", Toast.LENGTH_LONG).show();

        }
        return etatRep;
    }
}

