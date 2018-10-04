package com.example.aditya.roomexample;

import android.arch.lifecycle.ViewModelProviders;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.aditya.roomexample.Model.User;
import com.example.aditya.roomexample.ViewModel.ViewModel;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    EditText mEdittextEmail, mEditetextName;
    Button mButtonSubmit, mbuttonGetAll;
    ViewModel mViewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mEdittextEmail = findViewById(R.id.edittext_Email);
        mEditetextName = findViewById(R.id.edittext_password);
        mButtonSubmit = findViewById(R.id.btn_Submit);
        mbuttonGetAll = findViewById(R.id.btn_ListAll);
        mViewModel = ViewModelProviders.of(this).get(ViewModel.class);
        mButtonSubmit.setOnClickListener(this);
        mbuttonGetAll.setOnClickListener(this);

    }


    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.btn_Submit:
                if(mEdittextEmail.getText().toString().trim().isEmpty()){
                   mEdittextEmail.setError("Enter Email");
                }else if( mEditetextName.getText().toString().trim().isEmpty()){
                    mEditetextName.setError("Enter Password");
            }else{
                    User mUser = new User(mEdittextEmail.getText().toString().trim(), mEditetextName.getText().toString().trim());
                    mViewModel.addPerson(mUser);
                    mEdittextEmail.setText("");
                    mEditetextName.setText("");
                }
                break;

            case R.id.btn_ListAll:
                startActivity(new Intent(this, DisplayUserActivity.class));

        }
    }
}
