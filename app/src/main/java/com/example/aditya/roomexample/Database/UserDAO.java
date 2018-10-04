package com.example.aditya.roomexample.Database;

import android.arch.lifecycle.LiveData;
import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;

import com.example.aditya.roomexample.Model.User;

import java.util.List;

@Dao
interface UserDAO {
    @Insert
    void Insert(User mUser);

    @Query("Select * FROM User ")
    LiveData<List<User>> getAll();


}
