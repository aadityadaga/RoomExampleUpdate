package com.example.aditya.roomexample;

import android.arch.lifecycle.Observer;
import android.arch.lifecycle.ViewModelProviders;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.example.aditya.roomexample.Model.User;
import com.example.aditya.roomexample.ViewModel.ViewModel;

import java.util.ArrayList;
import java.util.List;

public class DisplayUserActivity extends AppCompatActivity {
    RecyclerView mRecyclerView;
    ViewModel mViewModel;
    List<User> mList = new ArrayList<>();
    DataAdapter mAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display_user);
        mRecyclerView = findViewById(R.id.RecyclerView);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(this));
        mAdapter = new DataAdapter(this, mList);
        mViewModel = ViewModelProviders.of(this).get(ViewModel.class);
        mRecyclerView.setAdapter(mAdapter);
        mViewModel.getAllUsers().observe(this, users -> {
            if (users != null) {
                mList.addAll(users);
            }
            mAdapter.notifyDataSetChanged();

        });
    }
}
