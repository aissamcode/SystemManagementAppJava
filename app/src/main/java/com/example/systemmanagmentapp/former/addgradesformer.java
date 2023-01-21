package com.example.systemmanagmentapp.former;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;

import com.example.systemmanagmentapp.R;
import com.example.systemmanagmentapp.database.systemDatabase;
import com.google.android.material.textfield.TextInputEditText;

import java.util.ArrayList;

public class addgradesformer extends AppCompatActivity {

    TextInputEditText interngradeformer;
    Button addgradesintern,backgrades,exitgrades;
    Spinner spinnerintern;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_addgradesformer);
        spinnerintern=findViewById(R.id.spinnerintern);
        interngradeformer=findViewById(R.id.interngradeformer);
        addgradesintern=findViewById(R.id.addgradesintern);
        backgrades=findViewById(R.id.backgrades);
        exitgrades=findViewById(R.id.exitgrades);
        systemDatabase dbintern=new systemDatabase(this,"intern",null,1);

        ArrayList<String> arrayList=dbintern.getDatainternspinner();
        ArrayAdapter<String> arrayAdapter=new ArrayAdapter<>(this, android.R.layout.simple_spinner_item,arrayList);
        spinnerintern.setAdapter(arrayAdapter);
        addgradesintern.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String name= spinnerintern.getSelectedItem().toString().split("/")[1];
                String firstname= spinnerintern.getSelectedItem().toString().split("/")[2];
                dbintern.updategrades(name,firstname,Double.valueOf(interngradeformer.getText().toString()));
            }
        });
        backgrades.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
        exitgrades.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finishAffinity(); // Close all activity's
                System.exit(0);
            }
        });
    }
}