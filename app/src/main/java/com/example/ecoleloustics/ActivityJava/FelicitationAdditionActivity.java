package com.example.ecoleloustics.ActivityJava;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

import com.example.ecoleloustics.R;

public class FelicitationAdditionActivity extends AppCompatActivity {

    @Override
    protected void onCreate (Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_felicitation);
    }

    public void felicitationChoisirTable (View view) {
        Intent intention = new Intent(FelicitationAdditionActivity.this, TableAdditionActivity.class) ;
        intention.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP) ;
        startActivity (intention) ;
    }

    public void felicitationChoisirExercice (View view) {
        Intent intention = new Intent (FelicitationAdditionActivity.this, ActivityMathematiques.class) ;
        intention.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP) ;
        startActivity (intention) ;
    }


}
