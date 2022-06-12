package com.example.ecoleloustics.Model.db;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import java.util.List;

@Dao
public interface QuestionDao {

    @Query("SELECT * FROM question")
    List<Question> getAll();

    @Query("SELECT * FROM question WHERE categorie=:Categorie")
    List<Question> getCategorie(String Categorie);

    @Query("SELECT id FROM question")
    List<Integer> getId() ;

    @Query("SELECT id FROM question WHERE categorie=:Categorie")
    List<Integer> getIdofCategorie(String Categorie) ;

    @Query("SELECT * FROM question WHERE id=:Id")
    Question getQuestionById(int Id) ;

    @Insert
    void insert(Question question);

    @Insert
    long[] insertAll(Question... questions);

    @Delete
    void delete(Question question);

    @Update
    void update(Question question);

}
