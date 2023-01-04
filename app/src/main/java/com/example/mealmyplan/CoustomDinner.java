package com.example.mealmyplan;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class CoustomDinner extends AppCompatActivity {
    Button Pay;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_coustom_dinner);
    Pay=findViewById(R.id.Breakfast);
    Pay.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            Intent i =new Intent(CoustomDinner.this,Pay.class);
            startActivity(i);
        }
    });
    }
}