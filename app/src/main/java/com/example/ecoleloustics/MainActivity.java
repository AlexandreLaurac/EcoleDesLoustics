package com.example.ecoleloustics;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //liste des items

        List<HighTechItem> highTechItemList = new ArrayList<>();

        highTechItemList.add(new HighTechItem("Baldo", 35));
        highTechItemList.add(new HighTechItem("Laurac", 45));
        highTechItemList.add(new HighTechItem("Bourgeaud", 25));

        // get listview

        ListView shopListView = findViewById(R.id.shop_list_view);
        shopListView.setAdapter(new HighTechItemAdapter(this,highTechItemList));
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