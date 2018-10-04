package com.example.aditya.roomexample.Database;

import android.arch.persistence.room.Database;
import android.arch.persistence.room.RoomDatabase;

import com.example.aditya.roomexample.Model.User;

@Database(entities = {User.class}, version = 1, exportSchema = false)
public abstract class UserDatabase extends RoomDatabase
{
    public abstract UserDAO PersonDatabase();
}