package com.example.systemmanagmentapp.director;

import androidx.appcompat.app.AppCompatActivity;

import android.app.FragmentManager;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.systemmanagmentapp.R;

public class formerD extends AppCompatActivity {

    //@aissamcode
    Button addformer,listformer;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_former_d);
        addformer=findViewById(R.id.addformer);
        listformer=findViewById(R.id.listformer);
        addformer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                android.app.Fragment fragmentaddformer= new addformerfragment();
                FragmentManager fragmentManager=getFragmentManager();
                fragmentManager.beginTransaction().replace(R.id.layoutformer,fragmentaddformer,null).commit();
            }
        });
        listformer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                android.app.Fragment formerList= new formerlistfragment();
                FragmentManager fragmentManager=getFragmentManager();
                fragmentManager.beginTransaction().replace(R.id.layoutformer,formerList,null).commit();
            }
        });
    }
}