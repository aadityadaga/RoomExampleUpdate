package com.example.aditya.roomexample.Database;

import android.arch.lifecycle.LiveData;
import android.content.Context;

import com.example.aditya.roomexample.Model.User;

import java.util.List;

public class UserRepository {
    private final UserDAO userDAO;

    public UserRepository(Context context) {
        userDAO = DatabaseCreator.getPersonDatabase(context).PersonDatabase();
    }

    public void addPerson(User p) {
        userDAO.Insert(p);

    }


    public LiveData<List<User>> getAllPersons() {
        return userDAO.getAll();
    }

}
