package com.example.systemmanagmentapp.director;

import androidx.appcompat.app.AppCompatActivity;

import android.app.FragmentManager;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.systemmanagmentapp.R;

public class fieldD extends AppCompatActivity {

    Button addfield,listfield;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_field_d);
        addfield=findViewById(R.id.addfield);
        listfield=findViewById(R.id.listfield);
        addfield.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                android.app.Fragment addfieldfragment= new addfieldfragment();
                FragmentManager fragmentManager=getFragmentManager();
                fragmentManager.beginTransaction().replace(R.id.layoutfield,addfieldfragment,null).commit();
            }
        });
        listfield.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                android.app.Fragment fieldlistfragment= new fieldlistfragment();
                FragmentManager fragmentManager=getFragmentManager();
                fragmentManager.beginTransaction().replace(R.id.layoutfield,fieldlistfragment,null).commit();
            }
        });
    }
}