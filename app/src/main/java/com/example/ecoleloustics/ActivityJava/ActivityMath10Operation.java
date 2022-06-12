package com.example.ecoleloustics.ActivityJava;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.ecoleloustics.R;

public class ActivityMath10Operation extends AppCompatActivity {


        public static final String RESULT_KEY = "result_key";
        private int compteur = 1;
        private int repJuste = 0;
        private CalculMental calculMental;
        private int codeOperator;

        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_math_10_operation);
            //recuperation du code l'operator
            codeOperator = getIntent().getIntExtra(RESULT_KEY, 0 );

            calculMental = new CalculMental(codeOperator);

            //on genere l'operande 1 à l'ouverture de l'activite
            int operande1 = calculMental.getOperande1();
            String op1 = String.valueOf(operande1);
            TextView op1View = (TextView) findViewById(R.id.math_10_ope_first_op);
            op1View.setText(op1);

            //on genere l'operande 2 à l'ouverture de l'activite
            int operande2 = calculMental.getOperande2();
            String op2 = String.valueOf(operande2);
            TextView op2View = (TextView) findViewById(R.id.math_10_ope_second_op);
            op2View.setText(op2);

            //compteur initiliser à 1 car methode genere pas encore initialiser
            TextView compteurView = (TextView) findViewById(R.id.math_10_ope_compteur);
            compteurView.setText("1/10");

            //adapter le titre des 10 opérations
            TextView titreView = (TextView) findViewById(R.id.math_10_ope_type_op);

            //recuperer le texte affichant l'operator
            TextView operatorView = (TextView) findViewById(R.id.math_10_ope_operator);

            //selon l'operator on le met à jour
            if(codeOperator == 1)
            {
                //faire l'addition et adapter titre à l'addition
                operatorView.setText("+");
                titreView.setText("10 Additions");
            }
            else
            {
                //faire la multiplication
                operatorView.setText("x");
                titreView.setText("10 Multiplications");
            }

            //le bouton est lié et on lie clickListener dessus
            Button valider = findViewById(R.id.valider);
            valider.setOnClickListener(this::onClick);

        }

    public void onClick(View v) {

        TextView resultatView = findViewById(R.id.math_10_ope_resultat);
        String resultatS = resultatView.getText().toString().trim();

        if (resultatS.isEmpty()){
            Toast.makeText(getApplicationContext(), "N'oublies pas ton résultat !!", Toast.LENGTH_LONG).show();
        }

        else if (compteur < 10) {
            siJuste(resultatS);
            genere();
            viderResult();
        }
        else{
            siJuste(resultatS);
            Intent finOperation = new Intent(ActivityMath10Operation.this, ActivityMath10OperationResultat.class);
            finOperation.putExtra(ActivityMath10OperationResultat.RESULT_KEY, repJuste);
            startActivity(finOperation);
        }
    }

    public void genere(){

        compteur++;
        // génére les deux opérandes aléatoirement à chaque clic
        calculMental = new CalculMental(codeOperator);
        int operande1 = calculMental.getOperande1();
        String op1 = String.valueOf(operande1);
        TextView op1View = (TextView) findViewById(R.id.math_10_ope_first_op);
        op1View.setText(op1);

        int operande2 = calculMental.getOperande2();
        String op2 = String.valueOf(operande2);
        TextView op2View = (TextView) findViewById(R.id.math_10_ope_second_op);
        op2View.setText(op2);

        //affiche l'incrementation le compteur
        TextView CompteurView = (TextView) findViewById(R.id.math_10_ope_compteur);
        String compteurS = String.valueOf(compteur);
        CompteurView.setText(compteurS + "/10");
    }

    public void siJuste(String resultatS){

        int result = Integer.parseInt(resultatS);

        TextView verifView = findViewById(R.id.verification);
        if(calculMental.getOperation() == result){
            repJuste++;
            //verifView.setText("OK" + " et réponse juste =  " +repJuste);
            Toast.makeText(getApplicationContext(), "REPONSE BONNE!!" , Toast.LENGTH_LONG).show();
        }
        else
        {
            //verifView.setText("KO");
            Toast.makeText(getApplicationContext(), "REPONSE FAUSSE!!\nLe bon résultat était :  " + calculMental.getOperation(), Toast.LENGTH_LONG).show();
        }

    }

    //vide l'éditText pour l'opération suivante
    public void viderResult(){

        TextView resultView = findViewById(R.id.math_10_ope_resultat);
        resultView.setText("");
    }



}
