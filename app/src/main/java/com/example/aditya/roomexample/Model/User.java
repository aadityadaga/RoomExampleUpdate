package com.example.aditya.roomexample.Model;

import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;

@Entity(tableName = "user")
public class User {
    @ColumnInfo(name = "Email")
    String Email;

    @ColumnInfo(name = "Name")
    String Name;
    @PrimaryKey
    @ColumnInfo(name = "ID")
    int ID;

    public User() {
    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public String getEmail() {
        return Email;
    }

    public void setEmail(String email) {
        Email = email;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public User(String email, String name) {

        Email = email;
        Name = name;
    }
}
