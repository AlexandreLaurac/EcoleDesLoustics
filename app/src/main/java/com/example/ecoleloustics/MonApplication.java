package com.example.ecoleloustics;

import android.app.Application;
import com.example.ecoleloustics.Model.db.User;


public class MonApplication extends Application {

    // Informations à conserver
    private User userCourant ;

    // Getters - setters
    public User getUserCourant() {
        return userCourant ;
    }

    public void setUserCourant (User user) {
        this.userCourant = user ;
    }
}