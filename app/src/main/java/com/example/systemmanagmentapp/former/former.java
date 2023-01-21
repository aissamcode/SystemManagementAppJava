package com.example.systemmanagmentapp.former;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.systemmanagmentapp.R;
import com.example.systemmanagmentapp.director.director;
import com.example.systemmanagmentapp.director.formerD;

public class former extends AppCompatActivity {

    //@aissamcode
    Button internF,addgradeformer,calenderformer,exitformer,backformer;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_former);
        internF=findViewById(R.id.internF);
        addgradeformer=findViewById(R.id.addgradeformer);
        backformer=findViewById(R.id.backformer);
        exitformer=findViewById(R.id.exitformer);
        calenderformer=findViewById(R.id.calenderformer);
        internF.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(former.this, listintern.class));
            }
        });
        addgradeformer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(former.this,addgradesformer.class));
            }
        });
        calenderformer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(former.this,calendarformer.class));
            }
        });
        backformer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
        exitformer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finishAffinity(); // Close all activity's
                System.exit(0);
            }
        });
    }
}