package com.example.systemmanagmentapp.intern;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.systemmanagmentapp.R;
import com.example.systemmanagmentapp.database.systemDatabase;

import java.util.ArrayList;

public class intern extends AppCompatActivity {

    //@aissamcode
    //this is intern profile info
    TextView loggedasintern,nameintern,fieldintern,gradesintern,genderintern;
    Button exitintern,backintern;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_intern);
        nameintern=findViewById(R.id.nameintern);
        fieldintern=findViewById(R.id.fieldintern);
        gradesintern=findViewById(R.id.gradesintern);
        genderintern=findViewById(R.id.genderintern);
        exitintern= findViewById(R.id.exitintern);
        backintern=findViewById(R.id.backintern);
        systemDatabase systemDatabase1=new systemDatabase(this,"user",null,1);

        systemDatabase dbintern = new systemDatabase(this, "intern", null, 1);


        loggedasintern=findViewById(R.id.loggedasintern);
        String login = getIntent().getStringExtra("login");
        String password = getIntent().getStringExtra("password");
        ArrayList<String> infointern = systemDatabase1.getdatainfo(login,password);

        ArrayList<String> arrayList = dbintern.getdatainfointern(infointern.get(0),infointern.get(1));
        loggedasintern.setText(login);
        nameintern.setText(arrayList.get(0)+" "+arrayList.get(1));
        genderintern.setText(arrayList.get(2));
        fieldintern.setText(arrayList.get(3));
        gradesintern.setText(arrayList.get(4).toString());
        exitintern.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
        backintern.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finishAffinity(); // Close all activity's
                System.exit(0);
            }
        });
    }
}
