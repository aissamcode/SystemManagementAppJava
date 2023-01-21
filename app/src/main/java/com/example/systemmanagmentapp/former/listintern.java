package com.example.systemmanagmentapp.former;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;

import com.example.systemmanagmentapp.R;
import com.example.systemmanagmentapp.database.systemDatabase;

import java.util.ArrayList;

public class listintern extends AppCompatActivity {

    Button backformerI, exitformerI;
    ListView listviewinternF;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_listintern);
        listviewinternF = findViewById(R.id.listviewinternF);
        systemDatabase dbintern = new systemDatabase(this, "intern", null, 1);

        backformerI = findViewById(R.id.backformerI);
        exitformerI = findViewById(R.id.exitformerI);
        backformerI.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
        exitformerI.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finishAffinity(); // Close all activity's
                System.exit(0);
            }
        });
        ArrayList<String> listintern = dbintern.getDataintern();
        ArrayAdapter adapter = new ArrayAdapter(this, android.R.layout.simple_list_item_1, listintern);
        listviewinternF.setAdapter(adapter);
    }
}