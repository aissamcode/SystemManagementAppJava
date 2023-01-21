package com.example.systemmanagmentapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.example.systemmanagmentapp.database.systemDatabase;
import com.example.systemmanagmentapp.director.director;
import com.example.systemmanagmentapp.former.former;
import com.example.systemmanagmentapp.intern.intern;
import com.google.android.material.textfield.TextInputEditText;

public class MainActivity extends AppCompatActivity {

    // this project was creates by aissam belmeskine
    //IG =  @aissamcode

    Button loginbutton;
    TextInputEditText logininput, passwordinput;
    systemDatabase systemDatabase = new systemDatabase(this, "user", null, 1);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        loginbutton = findViewById(R.id.loginbutton);
        logininput = findViewById(R.id.logininput);
        passwordinput = findViewById(R.id.passwordinput);
        loginbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (systemDatabase.mainlogin(logininput.getText().toString(), passwordinput.getText().toString()) == 1) {
                    Intent i = new Intent(MainActivity.this, director.class);
                    i.putExtra("login", logininput.getText().toString());
                    i.putExtra("password", passwordinput.getText().toString());
                    startActivity(i);
                } else if (systemDatabase.mainlogin(logininput.getText().toString(), passwordinput.getText().toString()) == 2) {
                    startActivity(new Intent(MainActivity.this, former.class));
                } else if (systemDatabase.mainlogin(logininput.getText().toString(), passwordinput.getText().toString()) == 3) {
                    Intent i = new Intent(MainActivity.this, intern.class);
                    i.putExtra("login", logininput.getText().toString());
                    i.putExtra("password", passwordinput.getText().toString());
                    startActivity(i);
                } else {
                    Toast.makeText(MainActivity.this, "Not Found", Toast.LENGTH_LONG).show();
                }
            }
        });
    }
}
//@aissamcode