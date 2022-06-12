package com.example.ecoleloustics.Model.db;

import android.content.Context;

import androidx.annotation.NonNull;
import androidx.room.Room;
import androidx.room.RoomDatabase;
import androidx.sqlite.db.SupportSQLiteDatabase;

public class DatabaseClient {

    // Instance unique permettant de faire le lien avec la base de données
    private static DatabaseClient instance;

    // Objet représentant la base de données de votre application
    private AppDatabase appDatabase;

    // Constructeur
    private DatabaseClient(final Context context) {

        // Créer l'objet représentant la base de données de votre application
        // à l'aide du "Room database builder"
        // EcoleDesLoustics est le nom de la base de données
        //appDatabase = Room.databaseBuilder(context, AppDatabase.class, "EcoleDesLoustics").build();

        ////////// REMPLIR LA BD à la première création à l'aide de l'objet roomDatabaseCallback
        // Ajout de la méthode addCallback permettant de populate (remplir) la base de données à sa création
        appDatabase = Room.databaseBuilder(context, AppDatabase.class, "EcoleDesLoustics").addCallback(roomDatabaseCallback).build();
    }

    // Méthode statique
    // Retourne l'instance de l'objet DatabaseClient
    public static synchronized DatabaseClient getInstance(Context context) {
        if (instance == null) {
            instance = new DatabaseClient(context);
        }
        return instance;
    }

    // Retourne l'objet représentant la base de données de votre application
    public AppDatabase getAppDatabase() {
        return appDatabase;
    }

    // Objet permettant de populate (remplir) la base de données à sa création
    RoomDatabase.Callback roomDatabaseCallback = new RoomDatabase.Callback() {

        // Called when the database is created for the first time.
        @Override
        public void onCreate(@NonNull SupportSQLiteDatabase db) {
            super.onCreate(db);

        //---------------------------------- INSERTION DE DONNEES ----------------------------------

            // Utilisateurs
            db.execSQL("INSERT INTO user (prenom, nom) VALUES('Jerome', 'Baldo');");
            db.execSQL("INSERT INTO user (prenom, nom) VALUES('Alexandre', 'Laurac');");

            // Questions
            //db.execSQL("INSERT INTO question (intitule, reponse1, reponse2, reponse3) VALUES('Quelle est la couleur du cheval blanc d''Henri IV ?', 'blanc', 'noir', 'rouge');");
            //db.execSQL("INSERT INTO question (intitule, reponse1, reponse2, reponse3) VALUES('Vrai ou faux ?', 'Vrai', 'Faux', 'Je ne sais pas');") ;
            //db.execSQL("INSERT INTO question (intitule, reponse1, reponse2, reponse3) VALUES('Intitulé de la question ?', 'Réponse 1 (LA BONNE !!!)', 'Réponse 2 (pas bonne...)', 'Je ne sais pas');") ;
            db.execSQL("INSERT INTO question (categorie, intitule, reponse1, reponse2, reponse3) VALUES('francais', 'Question francais 1', 'reponse1', 'reponse2', 'reponse3');");
            db.execSQL("INSERT INTO question (categorie, intitule, reponse1, reponse2, reponse3) VALUES('francais', 'Question francais 2', 'reponse1', 'reponse2', 'reponse3');");
            db.execSQL("INSERT INTO question (categorie, intitule, reponse1, reponse2, reponse3) VALUES('francais', 'Question francais 3', 'reponse1', 'reponse2', 'reponse3');");
            db.execSQL("INSERT INTO question (categorie, intitule, reponse1, reponse2, reponse3) VALUES('francais', 'Question francais 4', 'reponse1', 'reponse2', 'reponse3');");
            db.execSQL("INSERT INTO question (categorie, intitule, reponse1, reponse2, reponse3) VALUES('francais', 'Question francais 5', 'reponse1', 'reponse2', 'reponse3');");
            db.execSQL("INSERT INTO question (categorie, intitule, reponse1, reponse2, reponse3) VALUES('francais', 'Question francais 6', 'reponse1', 'reponse2', 'reponse3');");
            db.execSQL("INSERT INTO question (categorie, intitule, reponse1, reponse2, reponse3) VALUES('francais', 'Question francais 7', 'reponse1', 'reponse2', 'reponse3');");
            db.execSQL("INSERT INTO question (categorie, intitule, reponse1, reponse2, reponse3) VALUES('francais', 'Question francais 8', 'reponse1', 'reponse2', 'reponse3');");
            db.execSQL("INSERT INTO question (categorie, intitule, reponse1, reponse2, reponse3) VALUES('francais', 'Question francais 9', 'reponse1', 'reponse2', 'reponse3');");
            db.execSQL("INSERT INTO question (categorie, intitule, reponse1, reponse2, reponse3) VALUES('francais', 'Question francais 10', 'reponse1', 'reponse2', 'reponse3');");
            db.execSQL("INSERT INTO question (categorie, intitule, reponse1, reponse2, reponse3) VALUES('francais', 'Question francais 11', 'reponse1', 'reponse2', 'reponse3');");
            db.execSQL("INSERT INTO question (categorie, intitule, reponse1, reponse2, reponse3) VALUES('francais', 'Question francais 12', 'reponse1', 'reponse2', 'reponse3');");
            db.execSQL("INSERT INTO question (categorie, intitule, reponse1, reponse2, reponse3) VALUES('francais', 'Question francais 13', 'reponse1', 'reponse2', 'reponse3');");
            db.execSQL("INSERT INTO question (categorie, intitule, reponse1, reponse2, reponse3) VALUES('francais', 'Question francais 14', 'reponse1', 'reponse2', 'reponse3');");
            db.execSQL("INSERT INTO question (categorie, intitule, reponse1, reponse2, reponse3) VALUES('francais', 'Question francais 15', 'reponse1', 'reponse2', 'reponse3');");
            db.execSQL("INSERT INTO question (categorie, intitule, reponse1, reponse2, reponse3) VALUES('francais', 'Question francais 16', 'reponse1', 'reponse2', 'reponse3');");
            db.execSQL("INSERT INTO question (categorie, intitule, reponse1, reponse2, reponse3) VALUES('francais', 'Question francais 17', 'reponse1', 'reponse2', 'reponse3');");
            db.execSQL("INSERT INTO question (categorie, intitule, reponse1, reponse2, reponse3) VALUES('francais', 'Question francais 18', 'reponse1', 'reponse2', 'reponse3');");
            db.execSQL("INSERT INTO question (categorie, intitule, reponse1, reponse2, reponse3) VALUES('francais', 'Question francais 19', 'reponse1', 'reponse2', 'reponse3');");
            db.execSQL("INSERT INTO question (categorie, intitule, reponse1, reponse2, reponse3) VALUES('francais', 'Question francais 20', 'reponse1', 'reponse2', 'reponse3');");

            // Questions d'histoire
            db.execSQL("INSERT INTO question (categorie, intitule, reponse1, reponse2, reponse3) VALUES('histoire', 'Pour arriver au pouvoir, à quoi Henri IV doit-il renoncer ?', 'À sa foi protestante', 'À monter sur le trône d''Espagne auquel il était aussi prétendant', 'À Marie de Médicis');");
            db.execSQL("INSERT INTO question (categorie, intitule, reponse1, reponse2, reponse3) VALUES('histoire', 'Quel roi de France est communément appelé Saint Louis ?', 'Louis IX', 'Louis XI', 'Louis XIII');");
            db.execSQL("INSERT INTO question (categorie, intitule, reponse1, reponse2, reponse3) VALUES('histoire', 'De quel roi Richelieu était-il le ministre ?', 'Louis XIII', 'Louis XII', 'Henri III');");
            db.execSQL("INSERT INTO question (categorie, intitule, reponse1, reponse2, reponse3) VALUES('histoire', 'Quel jour Napoléon Ier est-il sacré empereur ?', 'Le 2 décembre 1804', 'Le 18 mai 1800', 'Le 7 octobre 1805');");
            db.execSQL("INSERT INTO question (categorie, intitule, reponse1, reponse2, reponse3) VALUES('histoire', 'Que se passe-t-il la nuit du 4 août 1789 ?', 'L''abolition des droits et privilèges féodaux', 'Le vote de la Déclaration des droits de l''Homme et du citoyen', 'L''abolition de l''esclavage');");
            db.execSQL("INSERT INTO question (categorie, intitule, reponse1, reponse2, reponse3) VALUES('histoire', 'Quand l''école est-elle devenue gratuite, laïque et obligatoire en primaire ?', 'En 1882', 'En 1914', 'En 1982');");
            db.execSQL("INSERT INTO question (categorie, intitule, reponse1, reponse2, reponse3) VALUES('histoire', 'Quelles sont les dates de la première guerre mondiale ?', '1914-1918', '1789-1815', '1939-1945');");
            db.execSQL("INSERT INTO question (categorie, intitule, reponse1, reponse2, reponse3) VALUES('histoire', 'En quelle année les femmes ont-elles eu le droit de vote ?', 'En 1944', 'En 1945', 'En 1918');");
            db.execSQL("INSERT INTO question (categorie, intitule, reponse1, reponse2, reponse3) VALUES('histoire', 'Que séparait le mur de Berlin ?', 'L''Allemagne de l''Ouest et l''Allemagne de l''Est', 'le Danemark et la Pologne', 'La France et l''Allemagne');");
            db.execSQL("INSERT INTO question (categorie, intitule, reponse1, reponse2, reponse3) VALUES('histoire', 'En quelle année le mur de Berlin est-il détruit ?', 'En 1989', 'En 1945', 'En 1991');");
            db.execSQL("INSERT INTO question (categorie, intitule, reponse1, reponse2, reponse3) VALUES('histoire', 'En quelle année finit la seconde Guerre Mondiale ?', 'En 1945', 'En 1951', 'En 1918');");
            db.execSQL("INSERT INTO question (categorie, intitule, reponse1, reponse2, reponse3) VALUES('histoire', 'Comment Hitler arrive-t-il au pouvoir ?', 'Légalement', 'Par l''assassinat de ses rivaux', 'Par un coup d''Etat');");
            db.execSQL("INSERT INTO question (categorie, intitule, reponse1, reponse2, reponse3) VALUES('histoire', 'Pendant quelle guerre le maréchal Pétain est-il devenu important pour la France ?', 'La première Guerre Mondiale', 'La deuxième Guerre Mondiale', 'La guerre de 1870 face à la Prusse');");
            db.execSQL("INSERT INTO question (categorie, intitule, reponse1, reponse2, reponse3) VALUES('histoire', 'Où le maréchal Pétain établit-il l''Etat français pendant l''occupation ?', 'Vichy', 'Paris', 'Berlin');");
            db.execSQL("INSERT INTO question (categorie, intitule, reponse1, reponse2, reponse3) VALUES('histoire', 'Quand le général de Gaulle fait-il son appel ?', 'Le 18 juin 1940', 'Le 8 mai 1945', 'Le 14 juillet 1789');");
            db.execSQL("INSERT INTO question (categorie, intitule, reponse1, reponse2, reponse3) VALUES('histoire', 'Quelle année sert de transition entre le Moyen-Âge et l''Epoque Moderne ?', '1492', '476', '1789');");
            db.execSQL("INSERT INTO question (categorie, intitule, reponse1, reponse2, reponse3) VALUES('histoire', 'Où est sacré Charlemagne ?', 'Rome', 'Paris', 'Aix-la-Chapelle');");
            db.execSQL("INSERT INTO question (categorie, intitule, reponse1, reponse2, reponse3) VALUES('histoire', 'A quelle dynastie appartient Clovis ?', 'Les Mérovingiens', 'Les Capétiens', 'Les Bourbons');");
            db.execSQL("INSERT INTO question (categorie, intitule, reponse1, reponse2, reponse3) VALUES('histoire', 'Quel roi Jeanne d''Arc a-t-elle aidé ?', 'Charles VII', 'Charles VIII', 'Charles VI');");
            db.execSQL("INSERT INTO question (categorie, intitule, reponse1, reponse2, reponse3) VALUES('histoire', 'Quel est le nom de l''édit qui tolère les Protestants ?', 'L''édit de Nantes', 'L''édit de Versailles', 'L''édit de Marseille');");
            db.execSQL("INSERT INTO question (categorie, intitule, reponse1, reponse2, reponse3) VALUES('histoire', 'Quel château symbolise la grandeur de Louis XIV ?', 'Versailles', 'Saint-Germain-en-Laye', 'Le Louvre');");
            db.execSQL("INSERT INTO question (categorie, intitule, reponse1, reponse2, reponse3) VALUES('histoire', 'Quel surnom donne-t-on à Louis XIV ?', 'Le roi soleil', 'Le roi lune', 'Le Vert Galant');");
            db.execSQL("INSERT INTO question (categorie, intitule, reponse1, reponse2, reponse3) VALUES('histoire', 'En quelle année les Etats-Unis deviennent-ils indépendants ?', 'En 1776', 'En 1789', 'En 1815');");
/*
            db.execSQL("INSERT INTO question (categorie, intitule, reponse1, reponse2, reponse3) VALUES('histoire', 'Question histoire 1', 'reponse1', 'reponse2', 'reponse3');");
            db.execSQL("INSERT INTO question (categorie, intitule, reponse1, reponse2, reponse3) VALUES('histoire', 'Question histoire 2', 'reponse1', 'reponse2', 'reponse3');");
            db.execSQL("INSERT INTO question (categorie, intitule, reponse1, reponse2, reponse3) VALUES('histoire', 'Question histoire 3', 'reponse1', 'reponse2', 'reponse3');");
            db.execSQL("INSERT INTO question (categorie, intitule, reponse1, reponse2, reponse3) VALUES('histoire', 'Question histoire 4', 'reponse1', 'reponse2', 'reponse3');");
            db.execSQL("INSERT INTO question (categorie, intitule, reponse1, reponse2, reponse3) VALUES('histoire', 'Question histoire 5', 'reponse1', 'reponse2', 'reponse3');");
            db.execSQL("INSERT INTO question (categorie, intitule, reponse1, reponse2, reponse3) VALUES('histoire', 'Question histoire 6', 'reponse1', 'reponse2', 'reponse3');");
            db.execSQL("INSERT INTO question (categorie, intitule, reponse1, reponse2, reponse3) VALUES('histoire', 'Question histoire 7', 'reponse1', 'reponse2', 'reponse3');");
            db.execSQL("INSERT INTO question (categorie, intitule, reponse1, reponse2, reponse3) VALUES('histoire', 'Question histoire 8', 'reponse1', 'reponse2', 'reponse3');");
            db.execSQL("INSERT INTO question (categorie, intitule, reponse1, reponse2, reponse3) VALUES('histoire', 'Question histoire 9', 'reponse1', 'reponse2', 'reponse3');");
            db.execSQL("INSERT INTO question (categorie, intitule, reponse1, reponse2, reponse3) VALUES('histoire', 'Question histoire 10', 'reponse1', 'reponse2', 'reponse3');");
            db.execSQL("INSERT INTO question (categorie, intitule, reponse1, reponse2, reponse3) VALUES('histoire', 'Question histoire 11', 'reponse1', 'reponse2', 'reponse3');");
            db.execSQL("INSERT INTO question (categorie, intitule, reponse1, reponse2, reponse3) VALUES('histoire', 'Question histoire 12', 'reponse1', 'reponse2', 'reponse3');");
            db.execSQL("INSERT INTO question (categorie, intitule, reponse1, reponse2, reponse3) VALUES('histoire', 'Question histoire 13', 'reponse1', 'reponse2', 'reponse3');");
            db.execSQL("INSERT INTO question (categorie, intitule, reponse1, reponse2, reponse3) VALUES('histoire', 'Question histoire 14', 'reponse1', 'reponse2', 'reponse3');");
            db.execSQL("INSERT INTO question (categorie, intitule, reponse1, reponse2, reponse3) VALUES('histoire', 'Question histoire 15', 'reponse1', 'reponse2', 'reponse3');");
            db.execSQL("INSERT INTO question (categorie, intitule, reponse1, reponse2, reponse3) VALUES('histoire', 'Question histoire 16', 'reponse1', 'reponse2', 'reponse3');");
            db.execSQL("INSERT INTO question (categorie, intitule, reponse1, reponse2, reponse3) VALUES('histoire', 'Question histoire 17', 'reponse1', 'reponse2', 'reponse3');");
            db.execSQL("INSERT INTO question (categorie, intitule, reponse1, reponse2, reponse3) VALUES('histoire', 'Question histoire 18', 'reponse1', 'reponse2', 'reponse3');");
            db.execSQL("INSERT INTO question (categorie, intitule, reponse1, reponse2, reponse3) VALUES('histoire', 'Question histoire 19', 'reponse1', 'reponse2', 'reponse3');");
            db.execSQL("INSERT INTO question (categorie, intitule, reponse1, reponse2, reponse3) VALUES('histoire', 'Question histoire 20', 'reponse1', 'reponse2', 'reponse3');");
*/

            db.execSQL("INSERT INTO question (categorie, intitule, reponse1, reponse2, reponse3) VALUES('geographie', 'Question geographie 1', 'reponse1', 'reponse2', 'reponse3');");
            db.execSQL("INSERT INTO question (categorie, intitule, reponse1, reponse2, reponse3) VALUES('geographie', 'Question geographie 2', 'reponse1', 'reponse2', 'reponse3');");
            db.execSQL("INSERT INTO question (categorie, intitule, reponse1, reponse2, reponse3) VALUES('geographie', 'Question geographie 3', 'reponse1', 'reponse2', 'reponse3');");
            db.execSQL("INSERT INTO question (categorie, intitule, reponse1, reponse2, reponse3) VALUES('geographie', 'Question geographie 4', 'reponse1', 'reponse2', 'reponse3');");
            db.execSQL("INSERT INTO question (categorie, intitule, reponse1, reponse2, reponse3) VALUES('geographie', 'Question geographie 5', 'reponse1', 'reponse2', 'reponse3');");
            db.execSQL("INSERT INTO question (categorie, intitule, reponse1, reponse2, reponse3) VALUES('geographie', 'Question geographie 6', 'reponse1', 'reponse2', 'reponse3');");
            db.execSQL("INSERT INTO question (categorie, intitule, reponse1, reponse2, reponse3) VALUES('geographie', 'Question geographie 7', 'reponse1', 'reponse2', 'reponse3');");
            db.execSQL("INSERT INTO question (categorie, intitule, reponse1, reponse2, reponse3) VALUES('geographie', 'Question geographie 8', 'reponse1', 'reponse2', 'reponse3');");
            db.execSQL("INSERT INTO question (categorie, intitule, reponse1, reponse2, reponse3) VALUES('geographie', 'Question geographie 9', 'reponse1', 'reponse2', 'reponse3');");
            db.execSQL("INSERT INTO question (categorie, intitule, reponse1, reponse2, reponse3) VALUES('geographie', 'Question geographie 10', 'reponse1', 'reponse2', 'reponse3');");
            db.execSQL("INSERT INTO question (categorie, intitule, reponse1, reponse2, reponse3) VALUES('geographie', 'Question geographie 11', 'reponse1', 'reponse2', 'reponse3');");
            db.execSQL("INSERT INTO question (categorie, intitule, reponse1, reponse2, reponse3) VALUES('geographie', 'Question geographie 12', 'reponse1', 'reponse2', 'reponse3');");
            db.execSQL("INSERT INTO question (categorie, intitule, reponse1, reponse2, reponse3) VALUES('geographie', 'Question geographie 13', 'reponse1', 'reponse2', 'reponse3');");
            db.execSQL("INSERT INTO question (categorie, intitule, reponse1, reponse2, reponse3) VALUES('geographie', 'Question geographie 14', 'reponse1', 'reponse2', 'reponse3');");
            db.execSQL("INSERT INTO question (categorie, intitule, reponse1, reponse2, reponse3) VALUES('geographie', 'Question geographie 15', 'reponse1', 'reponse2', 'reponse3');");
            db.execSQL("INSERT INTO question (categorie, intitule, reponse1, reponse2, reponse3) VALUES('geographie', 'Question geographie 16', 'reponse1', 'reponse2', 'reponse3');");
            db.execSQL("INSERT INTO question (categorie, intitule, reponse1, reponse2, reponse3) VALUES('geographie', 'Question geographie 17', 'reponse1', 'reponse2', 'reponse3');");
            db.execSQL("INSERT INTO question (categorie, intitule, reponse1, reponse2, reponse3) VALUES('geographie', 'Question geographie 18', 'reponse1', 'reponse2', 'reponse3');");
            db.execSQL("INSERT INTO question (categorie, intitule, reponse1, reponse2, reponse3) VALUES('geographie', 'Question geographie 19', 'reponse1', 'reponse2', 'reponse3');");
            db.execSQL("INSERT INTO question (categorie, intitule, reponse1, reponse2, reponse3) VALUES('geographie', 'Question geographie 20', 'reponse1', 'reponse2', 'reponse3');");

        }
    };
}
