package com.example.ecoleloustics.ActivityJava;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

import com.example.ecoleloustics.R;

public class ActivityMathCalculMental extends AppCompatActivity {



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_math_calcul_mental);
    }

    public void onAddition(View view) {
        int codeOperator = 1;
        Intent activityCalculMental = new Intent(ActivityMathCalculMental.this, ActivityMathCalculMentalOp.class);
        activityCalculMental.putExtra(ActivityMathCalculMentalOp.RESULT_KEY_M, codeOperator);
        startActivity(activityCalculMental);

    }

    public void onMultiplication(View view) {
        int codeOperator = 2;
        Intent activityCalculMental = new Intent(ActivityMathCalculMental.this, ActivityMathCalculMentalOp.class);
        activityCalculMental.putExtra(ActivityMathCalculMentalOp.RESULT_KEY_M, codeOperator);
        startActivity(activityCalculMental);
    }
}
