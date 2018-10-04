package com.example.aditya.roomexample.ViewModel;

import android.app.Application;
import android.arch.lifecycle.AndroidViewModel;
import android.arch.lifecycle.LiveData;
import android.support.annotation.NonNull;

import com.example.aditya.roomexample.Database.UserRepository;
import com.example.aditya.roomexample.Model.User;

import java.util.List;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

public class ViewModel extends AndroidViewModel {
    public ViewModel(@NonNull Application application) {
        super(application);
    }

    private UserRepository personRepository = new UserRepository(this.getApplication());
    private final Executor executor = Executors.newFixedThreadPool(2);


    public void addPerson(User p) {
        executor.execute(() -> {
            personRepository.addPerson(p);
        });
    }

    public LiveData<List<User>> getAllUsers() {
        return personRepository.getAllPersons();
    }
}
