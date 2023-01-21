package com.example.systemmanagmentapp.director;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.systemmanagmentapp.R;
import com.example.systemmanagmentapp.database.systemDatabase;
import com.google.android.material.textfield.TextInputEditText;

import java.util.ArrayList;

public class directorInformation extends AppCompatActivity {

    TextView nametextview,logintextview,numberformer,numberintern;
    Button back,exit;
    TextInputEditText passwordinput;
    systemDatabase systemDatabase1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_director_information);
        nametextview=findViewById(R.id.nametextview);
        logintextview=findViewById(R.id.logintextview);
        passwordinput=findViewById(R.id.passwordinfo);
        numberformer=findViewById(R.id.numberformer);
        numberintern=findViewById(R.id.numberintern);
        back=findViewById(R.id.backinfo);
        exit=findViewById(R.id.exitinfo);
         systemDatabase1=new systemDatabase(this,"user",null,1);
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
        exit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finishAffinity(); // Close all activity's
                System.exit(0);
            }
        });

    }

    @Override
    protected void onStart() {
        systemDatabase systemDatabase2=new systemDatabase(this,"intern",null,1);
        systemDatabase systemDatabase3=new systemDatabase(this,"former",null,1);

        super.onStart();
        ArrayList<String> listintern = systemDatabase1.getdatainfo(getIntent().getStringExtra("login"),getIntent().getStringExtra("password"));
        nametextview.setText(listintern.get(0)+" "+listintern.get(1));
        logintextview.setText(listintern.get(2));
        passwordinput.setText(listintern.get(3));
        numberintern.setText(String.valueOf(systemDatabase2.getnumberintern()));
        numberformer.setText(String.valueOf(systemDatabase3.getnumberformer()));
    }
}