package com.example.ecoleloustics.ActivityJava;

import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.example.ecoleloustics.MonApplication;
import com.example.ecoleloustics.Adapter.UsersAdapter;
import com.example.ecoleloustics.Model.db.DatabaseClient;
import com.example.ecoleloustics.Model.db.User;
import com.example.ecoleloustics.R;

import java.util.ArrayList;
import java.util.List;


public class ActivityConnexion extends AppCompatActivity {

    //
    private static final int REQUEST_CODE_ADD = 0;

    // DATA
    private DatabaseClient mDb;
    private UsersAdapter adapter;

    // VIEW
    private Button buttonAdd;
    private ListView listUser;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_connexion);

        // Récupération du DatabaseClient
        mDb = DatabaseClient.getInstance(getApplicationContext());

        // Récupérer les vues
        listUser = findViewById(R.id.listUser);
        buttonAdd = findViewById(R.id.button_add);

        // Lier l'adapter au listView
        adapter = new UsersAdapter(this, new ArrayList<User>());
        listUser.setAdapter(adapter);

        // Ajouter un événement au bouton d'ajout
        buttonAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(ActivityConnexion.this, ActivityInscription.class);
                startActivityForResult(intent, REQUEST_CODE_ADD);
            }
        });

        // Ajout d'un événement click à la listView
        listUser.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                // Récupération de l'utilisateur cliqué à l'aide de l'adapter
                User user = adapter.getItem(position);
                ((MonApplication) ActivityConnexion.this.getApplication()).setUserCourant(user) ;

                // Message
                //Toast.makeText(ActivityConnexion.this, "Click : " + user.getPrenom(), Toast.LENGTH_SHORT).show();
                Intent activityMenu = new Intent(ActivityConnexion.this, ActivityMenu.class);
                startActivity (activityMenu) ;
            }
        });

        // Ajout d'un événement long click à la listView
        listUser.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {

            @Override
            public boolean onItemLongClick(AdapterView<?> parent, View view, int position, long id) {

                // Récupération de la tâche cliquée à l'aide de l'adapter
                User user = adapter.getItem(position);

                // Message
                Toast.makeText(ActivityConnexion.this, "LongClick : " + user.getPrenom(), Toast.LENGTH_SHORT).show();

                return false;
            }
        });

        // Mise à jour des utilisateurs
        getUsers();
    }


    /**
     *
     *
     */
    private void getUsers() {

        // Classe asynchrone permettant de récupérer des utilisateurs et de mettre à jour le listView de l'activité
        class GetUsers extends AsyncTask<Void, Void, List<User>> {

            @Override
            protected List<User> doInBackground(Void... voids) {
                List<User> userList = mDb.getAppDatabase().userDao().getAll() ;
                return userList ;
            }

            @Override
            protected void onPostExecute(List<User> users) {
                super.onPostExecute(users);

                // Mettre à jour l'adapter avec la liste d'utilisateurs
                adapter.clear();
                adapter.addAll(users);

                // Now, notify the adapter of the change in source
                adapter.notifyDataSetChanged();
            }
        }

        // IMPORTANT bien penser à executer la demande asynchrone
        // Création d'un objet de type GetUsers et execution de la demande asynchrone
        GetUsers gu = new GetUsers();
        gu.execute();
    }


    @Override
    protected void onStart() {
        super.onStart();

        // Mise à jour des utilisateurs
        getUsers();

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode == REQUEST_CODE_ADD && resultCode == RESULT_OK) {

            // Mise à jour des utilisateurs
            getUsers();
        }
    }
}
