package com.example.systemmanagmentapp.director;

import androidx.appcompat.app.AppCompatActivity;

import android.app.FragmentManager;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;

import com.example.systemmanagmentapp.R;

public class internD extends AppCompatActivity {

    //@aissamcode
    Button addinternD,listinternD;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_intern_d);
        addinternD=findViewById(R.id.addinternD);
        listinternD=findViewById(R.id.listinternD);

        addinternD.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                android.app.Fragment addinternfragment= new addinternfragment();
                FragmentManager fragmentManager=getFragmentManager();
                fragmentManager.beginTransaction().replace(R.id.layoutintern,addinternfragment,null).commit();
            }
        });
        listinternD.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                android.app.Fragment internlistfragment= new internlistfragment();
                FragmentManager fragmentManager=getFragmentManager();
                fragmentManager.beginTransaction().replace(R.id.layoutintern,internlistfragment,null).commit();
            }
        });
    }
}