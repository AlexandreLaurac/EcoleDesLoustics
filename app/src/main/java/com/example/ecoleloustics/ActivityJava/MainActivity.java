package com.example.ecoleloustics.ActivityJava;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ListView;

import com.example.ecoleloustics.Adapter.UtilisateurAdapter;

import com.example.ecoleloustics.Model.Utilisateur;
import com.example.ecoleloustics.R;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //liste des items

        List<Utilisateur> utilisateurList = new ArrayList<>();

        utilisateurList.add(new Utilisateur("Baldo", "Jerome"));
        utilisateurList.add(new Utilisateur("Laurac", "Alexandre"));
        utilisateurList.add(new Utilisateur("Bourgeaud", "Corentin"));

        // get listview

        ListView shopListView = findViewById(R.id.shop_list_view);
        shopListView.setAdapter(new UtilisateurAdapter(this,utilisateurList));
    }

    public void onMenu(View view) {

        // Création d'une intention
        Intent activityMenu = new Intent(MainActivity.this, ActivityMenu.class);

        // Lancement de la demande de changement d'activité
        startActivity(activityMenu);
    }

    public void onInscription(View view) {

        // Création d'une intention
        Intent activityInscription = new Intent(MainActivity.this, ActivityInscription.class);

        // Lancement de la demande de changement d'activité
        startActivity(activityInscription);
    }

}