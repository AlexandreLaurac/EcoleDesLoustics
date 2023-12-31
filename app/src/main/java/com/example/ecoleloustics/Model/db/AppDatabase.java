package com.example.ecoleloustics.Model.db;

import androidx.room.Database;
import androidx.room.RoomDatabase;

@Database(entities = {User.class, Question.class}, version = 1, exportSchema = false)
public abstract class AppDatabase extends RoomDatabase {

    public abstract UserDao userDao() ;
    public abstract QuestionDao questionDao() ;

}