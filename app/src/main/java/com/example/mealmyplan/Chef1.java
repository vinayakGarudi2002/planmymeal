package com.example.mealmyplan;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class Chef1 extends AppCompatActivity {
    Button ViewCP,ViewOP;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chef1);
        ViewCP=findViewById(R.id.button10);
        ViewOP=findViewById(R.id.button11);
        ViewCP.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i=new Intent(Chef1.this,ChefCustomClass.class);
                startActivity(i);
            }
        });
        ViewOP.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i=new Intent(Chef1.this,ChefDirectOrder.class);
                startActivity(i);
            }
        });

    }
}