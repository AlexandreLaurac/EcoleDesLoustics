package com.example.ecoleloustics.ActivityJava;

import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.ecoleloustics.Model.db.DatabaseClient;
import com.example.ecoleloustics.Model.db.Question;
import com.example.ecoleloustics.R;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;


public class ActivityCultureGeneraleQuestions extends AppCompatActivity {

    private static final int nbQuestions = 10 ;
    public static final String THEME_CHOISI_KEY = "theme_choisi_key" ;

    private DatabaseClient mDb ;
    private TextView vueQuestion ;
    private RadioButton [] radioBoutons ;
    private RadioGroup radioGroup ;
    private int compteur ;
    private String themeChoisi ;
    private List<Question> listeQuestions ;
    private Question questionCourante ;
    private int idDuBonRadioBouton ;
    private int nbBonnesReponses ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState) ;
        setContentView (R.layout.activity_culture_generale_questions) ;

        // Récupération du DatabaseClient
        mDb = DatabaseClient.getInstance(getApplicationContext()) ;

        // Récupération des vues
        vueQuestion = (TextView) findViewById (R.id.cultureGeneraleQuestions_vueQuestion) ;
        radioBoutons = new RadioButton[3] ;
        radioBoutons[0] = (RadioButton) findViewById (R.id.cultureGeneraleQuestions_radioBouton1) ;
        radioBoutons[1] = (RadioButton) findViewById (R.id.cultureGeneraleQuestions_radioBouton2) ;
        radioBoutons[2] = (RadioButton) findViewById (R.id.cultureGeneraleQuestions_radioBouton3) ;
        radioGroup = (RadioGroup) findViewById (R.id.cultureGeneraleQuestions_radioGroup) ;

        // Initialisation du compteur et du nombre de bonnes réponses
        compteur = 0 ;
        nbBonnesReponses = 0 ;

        // Récupération du thème choisi
        themeChoisi = getIntent().getStringExtra(THEME_CHOISI_KEY) ;

        // Récupération des questions et initialisation de la première question
        getQuestions() ;
    }


    private void getQuestions() {

        // Classe asynchrone permettant de récupérer les questions de la base
        class GetQuestions extends AsyncTask<Void, Void, List<Question>> {

            @Override
            protected List<Question> doInBackground(Void... voids) {

                // On récupère la liste des questions de la base
                //List<Question> listeTEMP = mDb.getAppDatabase().questionDao().getCategorie("francais");
                //return listeTEMP ;

                // On récupère la liste des Id des questions de la base correspondant à une certaine catégorie, choisie deux activités plus tôt
                List<Integer> listeId = mDb.getAppDatabase().questionDao().getIdofCategorie(themeChoisi) ;

                // Tirage aléatoire sans remise de 10 Id (et donc 10 questions) parmi ces Id
                List<Question> questionsList = new ArrayList<>() ;
                for (int i=0 ; i<nbQuestions ; i++) {
                    Random random = new Random () ;
                    int alea = random.nextInt(listeId.size() - i) ;
                    int idCourant = listeId.get(alea) ;
                    Question question = mDb.getAppDatabase().questionDao().getQuestionById(idCourant) ;
                    questionsList.add(question) ;
                    listeId.remove(alea) ;
                }

                return questionsList ;
            }

            @Override
            protected void onPostExecute(List<Question> questions) {
                super.onPostExecute(questions);
                listeQuestions = questions ;

                // Initialisation des vues
                InitialisationVues() ;
            }
        }

        // Création d'un objet de type GetQuestions et execution de la demande asynchrone
        GetQuestions gq = new GetQuestions () ;
        gq.execute();
    }

    private void InitialisationVues () {

        // On récupère la question courante
        questionCourante = listeQuestions.get(compteur) ;

        // Intitulé de la question
        vueQuestion.setText(questionCourante.getIntitule()) ;

        // Réponses : il s'agit de les faire apparaitre dans un ordre aléatoire, la réponse 1 étant toujours la bonne
        ArrayList<Integer> indices = new ArrayList<>() ; // Liste d'indices de 0 à taille des boutons, qui vont être tirés dans un ordre aléatoire, sans remise
        for (int k = 0 ; k < radioBoutons.length ; k++) { indices.add(k) ; }
        String [] reponses = new String[3] ; // Tableau de chaines de caractères, recevant les différentes réponses d'une question, dans l'ordre des indices aléatoires
        Random alea = new Random() ; // générateur de nombre pseudo-aléatoire
        int i, indiceCourant, bonneReponse ;
            // 1ère question
        i = alea.nextInt(3) ;
        indiceCourant = indices.get(i) ;
        bonneReponse = indices.get(i) ;
        reponses[indiceCourant] = questionCourante.getReponse1() ;
        indices.remove(i) ;
            // 2è question
        i = alea.nextInt(2) ;
        indiceCourant = indices.get(i) ;
        reponses[indiceCourant] = questionCourante.getReponse2() ;
        indices.remove(i) ;
            // 3è question
        indiceCourant = indices.get(0) ;  // indice restant
        reponses[indiceCourant] = questionCourante.getReponse3() ;
            // Attribution des réponses aux radio boutons
        radioBoutons[0].setText(reponses[0]) ;
        radioBoutons[1].setText(reponses[1]) ;
        radioBoutons[2].setText(reponses[2]) ;
            // On enregistre l'Id du radio bouton auquel a été attribué la bonne réponse pour pouvoir le comparer plus tard avec le bouton cliqué
        idDuBonRadioBouton = radioBoutons[bonneReponse].getId() ;

        // On décoche les boutons
        radioGroup.clearCheck() ;
    }

    // Evenement lié au bouton VALIDER
    public void onValider (View view) {

        // Si aucun bouton n'est coché, on empêche de passer à la question suivante et on en prévient l'élève
        if (!radioBoutons[0].isChecked() && !radioBoutons[1].isChecked() && !radioBoutons[2].isChecked()) {
            String notification =  "Choisis une réponse avant de passer à la question suivante" ;
            Toast.makeText(this, notification, Toast.LENGTH_SHORT).show() ;
        }
        // Un bouton a été coché
        else {
            // On vérifie si la réponse est la bonne et si oui on félicite l'élève
            if (radioGroup.getCheckedRadioButtonId() == idDuBonRadioBouton) {
                nbBonnesReponses++ ;
                String notification = "Bravo, c'est la bonne réponse !" ;
                Toast.makeText(this, notification, Toast.LENGTH_SHORT).show() ;
            }
            // Si la réponse n'est pas la bonne, on donne la bonne réponse à l'élève
            else {
                String notification = "Eh non, ce n'est pas ça !\nLa bonne réponse était \"" + questionCourante.getReponse1() + "\"" ;
                Toast.makeText(this, notification, Toast.LENGTH_SHORT).show() ;
            }
            // On incrémente le compteur
            compteur++ ;
            // Si on a répondu à toutes les questions
            if (compteur == nbQuestions) {
                // On crée une nouvelle intention et on lance l'activité associée
                Intent intentionCultureGeneraleResultats = new Intent(ActivityCultureGeneraleQuestions.this, ActivityCultureGeneraleResultats.class);
                intentionCultureGeneraleResultats.putExtra(ActivityCultureGeneraleResultats.NBREPONSES, nbBonnesReponses) ;
                intentionCultureGeneraleResultats.putExtra(ActivityCultureGeneraleResultats.NBQUESTIONS, nbQuestions) ;
                startActivity(intentionCultureGeneraleResultats);
            }
            // sinon
            else {
                // On charge la question suivante
                InitialisationVues();
            }
        }
    }


}

