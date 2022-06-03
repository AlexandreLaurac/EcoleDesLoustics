package com.example.ecoleloustics.ActivityJava;

import android.os.AsyncTask;
import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;


import com.example.ecoleloustics.Model.db.DatabaseClient;
import com.example.ecoleloustics.Model.db.User;

import com.example.ecoleloustics.R;


public class ActivityInscription extends AppCompatActivity {

    // Base de données
    private DatabaseClient mDb ;

    // Vues
    private EditText editTextPrenomView ;
    private EditText editTextNomView ;
    private Button saveView ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_inscription);

        // Récupération du DatabaseClient
        mDb = DatabaseClient.getInstance(getApplicationContext());

        // Récupérer les vues
        editTextPrenomView = findViewById(R.id.editTextPrenom);
        editTextNomView = findViewById(R.id.editTextNom);
        saveView = findViewById(R.id.button_save);

        // Associer un événement au bouton save
        saveView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                saveUser();
            }
        });
    }

    private void saveUser() {

        // Récupérer les informations contenues dans les vues
        final String sPrenom = editTextPrenomView.getText().toString().trim();
        final String sNom = editTextNomView.getText().toString().trim();

        // Vérifier les informations fournies par l'utilisateur
        if (sPrenom.isEmpty()) {
            editTextPrenomView.setError("Prénom requis");
            editTextPrenomView.requestFocus();
            return ;
        }
        if (sNom.isEmpty()) {
            editTextNomView.setError("Nom requis");
            editTextNomView.requestFocus();
            return ;
        }

        /**
         * Création d'une classe asynchrone pour sauvegarder la tache donnée par l'utilisateur
         */
        class SaveUser extends AsyncTask<Void, Void, User> {

            @Override
            protected User doInBackground(Void... voids) {

                // Création d'un utilisateur
                User user = new User();
                user.setPrenom(sPrenom);
                user.setNom(sNom);

                // Ajout à la base de données
                mDb.getAppDatabase().userDao().insert(user) ;
                return user ;
            }

            @Override
            protected void onPostExecute(User user) {
                super.onPostExecute(user) ;

                // Quand l'utilisateur est créé, on arrête l'activité AddUserActivity (on l'enleve de la pile d'activités)
////////////////////////////////////////// A REVOIR !!!!! //////////////////////////////////////////
                setResult(RESULT_OK) ;
                finish() ;
                Toast.makeText(getApplicationContext(), "Sauvegardé", Toast.LENGTH_LONG).show() ;
            }
        }

        //////////////////////////
        // IMPORTANT bien penser à executer la demande asynchrone
        SaveUser su = new SaveUser();
        su.execute();
    }

}
