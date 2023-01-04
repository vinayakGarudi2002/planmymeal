package com.example.mealmyplan;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class CoustomLunch extends AppCompatActivity {
    Button Lunch;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_coustom_lunch);
        Lunch=findViewById(R.id.Breakfast);
        Lunch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i=new Intent(CoustomLunch.this,CoustomDinner.class);
                startActivity(i);
            }
        });

    }
}