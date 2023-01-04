package com.example.mealmyplan;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.TextView;

import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;

public class Testing1 extends AppCompatActivity {
    String Vitamin, Gender, Activity, item;
    EditText etAge, etHeight, etName, etPhoneno, etSurname, etWeight, etTargetWeight;
    Button BtnDone;
    private DatabaseReference databaseReference;
    int cals, prot, carb, fat, x, y;
    private String mUserId;
    TextView text;
    FirebaseUser user;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_testing1);
         Spinner spinner = (android.widget.Spinner) findViewById(R.id.spinner); // check
        spinner.setOnItemSelectedListener((AdapterView.OnItemSelectedListener) this);
         Spinner spinner1 = (Spinner) findViewById(R.id.spinner1); // check
        spinner1.setOnItemSelectedListener((AdapterView.OnItemSelectedListener) this);
         Spinner spinner2 = (Spinner) findViewById(R.id.spinner2); // check
        spinner2.setOnItemSelectedListener((AdapterView.OnItemSelectedListener) this);



        BtnDone = findViewById(R.id.buttonOK);


    }
}