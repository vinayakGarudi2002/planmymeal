package com.example.mealmyplan;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class ChooseOne extends AppCompatActivity {

        Button Chef, Customer;
        Intent intent;
        String type;
// ConstraintLayout bgimage;

@Override
protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


        setContentView(R.layout.activity_choose_one);
        Chef = (Button) findViewById(R.id.chef);
        // DeliveryPerson = (Button) findViewById(R.id.delivery);
        Customer = (Button) findViewById(R.id.customer);


        Chef.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ChooseOne.this,ChefLogin.class);

                startActivity(intent);
                finish();
            }
        });



        Customer.setOnClickListener(new View.OnClickListener() {
@Override
public void onClick(View v) {
        Intent intent = new Intent(ChooseOne.this,Signup.class);
        startActivity(intent);
        finish();
        }
        });



        }
        }