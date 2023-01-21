package com.example.systemmanagmentapp.director;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.example.systemmanagmentapp.MainActivity;
import com.example.systemmanagmentapp.R;

public class director extends AppCompatActivity {

    //@aissamcode
    Button former, intern, field, information, back, exit;
    TextView loggedas;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_director);
        former = findViewById(R.id.former);
        intern = findViewById(R.id.intern);
        field = findViewById(R.id.field);
        information = findViewById(R.id.information);
        loggedas = findViewById(R.id.loggedas);
        back = findViewById(R.id.back);
        exit = findViewById(R.id.exit);
        String login = getIntent().getStringExtra("login");
        String password = getIntent().getStringExtra("password");
        loggedas.setText(login.toString());
        former.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(director.this, formerD.class));
            }
        });
        intern.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(director.this, internD.class));
            }
        });
        field.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(director.this, fieldD.class));
            }
        });
        information.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(director.this, directorInformation.class);
                i.putExtra("login", login);
                i.putExtra("password", password);
                startActivity(i);
            }
        });
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
}