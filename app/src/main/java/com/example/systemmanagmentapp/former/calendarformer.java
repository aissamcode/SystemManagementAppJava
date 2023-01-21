package com.example.systemmanagmentapp.former;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.systemmanagmentapp.R;

public class calendarformer extends AppCompatActivity {

    Button backcalendar,exitcalendar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calendarformer);
        backcalendar=findViewById(R.id.backcalendar);
        exitcalendar=findViewById(R.id.exitcalendar);
        backcalendar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
        exitcalendar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finishAffinity(); // Close all activity's
                System.exit(0);
            }
        });
    }
}