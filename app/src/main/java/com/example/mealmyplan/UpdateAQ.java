package com.example.mealmyplan;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

public class UpdateAQ extends AppCompatActivity implements AdapterView.OnItemSelectedListener {
    String  item,Region,Food;
    EditText  Add,phn ;
    Button buttonUp,buttonCC,btp,btp1;
    private DatabaseReference databaseReference;

    private String mUserId;
    TextView text;
    FirebaseUser user;
    FirebaseAuth auth;
    String etBreak,etLunch,etDinner;
    Spinner spinner6,spinner7,spinner8;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_update_aq);
        Add = findViewById(R.id.Add);


        List<String> list6 = new ArrayList<String>();
        list6.add("7AM");
        list6.add("8AM");
        list6.add("9AM");
        list6.add("10AM");

        spinner6 = (Spinner)findViewById(R.id.spinnerbc);
        ArrayAdapter<String> arrayAdapter6 = new ArrayAdapter<String>(UpdateAQ.this, android.R.layout.simple_spinner_item, list6);
        arrayAdapter6.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner6.setAdapter(arrayAdapter6);
        spinner6.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

                spinner6.setSelection(position);
                etBreak = parent.getItemAtPosition(position).toString();

                // Toast.makeText(parent.getContext(), "Selected: " + item, Toast.LENGTH_LONG).show();




            }
            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
        List<String> list8 = new ArrayList<String>();
        list8.add("7PM");
        list8.add("8PM");
        list8.add("9PM");
        list8.add("10PM");

        spinner8 = (Spinner)findViewById(R.id.spinnerdc);
        ArrayAdapter<String> arrayAdapter8 = new ArrayAdapter<String>(UpdateAQ.this, android.R.layout.simple_spinner_item, list8);
        arrayAdapter8.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner8.setAdapter(arrayAdapter8);
        spinner8.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

                spinner8.setSelection(position);
                etDinner = parent.getItemAtPosition(position).toString();

                //  Toast.makeText(parent.getContext(), "Selected: " + item, Toast.LENGTH_LONG).show();




            }
            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
        List<String> list7 = new ArrayList<String>();
        list7.add("1PM");
        list7.add("2PM");
        list7.add("3PM");
        spinner7 = (Spinner)findViewById(R.id.spinnerlc);
        ArrayAdapter<String> arrayAdapter7 = new ArrayAdapter<String>(UpdateAQ.this, android.R.layout.simple_spinner_item, list7);
        arrayAdapter7.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner7.setAdapter(arrayAdapter7);
        spinner7.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

                spinner7.setSelection(position);
                etLunch = parent.getItemAtPosition(position).toString();

                // Toast.makeText(parent.getContext(), "Selected: " + item, Toast.LENGTH_LONG).show();




            }
            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });



        final Spinner spinner3 = (Spinner) findViewById(R.id.spinnerRc); // check
        spinner3.setOnItemSelectedListener((AdapterView.OnItemSelectedListener) this);


        buttonUp = findViewById(R.id.buttonUp);
        FirebaseDatabase firebaseDatabase = FirebaseDatabase.getInstance();
        databaseReference = firebaseDatabase.getReference();




        List<String> list3 = new ArrayList<String>();
        list3.add("Goregoan");
        list3.add("Kandivali");
        list3.add("Malad");
        list3.add("Borivali");

        ArrayAdapter<String> arrayAdapter3 = new ArrayAdapter<String>(UpdateAQ.this, android.R.layout.simple_spinner_item, list3);
        arrayAdapter3.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner3.setAdapter(arrayAdapter3);
        spinner3.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

                spinner3.setSelection(position);
                item = parent.getItemAtPosition(position).toString();

                // Toast.makeText(parent.getContext(), "Selected: " + item, Toast.LENGTH_LONG).show();
                Region = item;

            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {


            }
        });




        FirebaseAuth firebaseAuth = FirebaseAuth.getInstance();
        FirebaseUser user = firebaseAuth.getCurrentUser();
        String userKey = user.getUid();
        Intent i = getIntent();
        Calendar c = Calendar.getInstance();
        @SuppressLint("SimpleDateFormat") SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        String date = sdf.format(c.getTime());
        String  ca1date=date;

        int ctH = c.get(Calendar.HOUR_OF_DAY);
        int ctM = c.get(Calendar.MINUTE);

        String type = i.getStringExtra("Type");


        String Adr = i.getStringExtra("Adr");
        databaseReference = FirebaseDatabase.getInstance().getReference("hotel").child(type).child(userKey);
        databaseReference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                String Bf,Lf,Df;
                Lf = snapshot.child("LunchTime").getValue(String.class);
                Df = snapshot.child("DinnerTime").getValue(String.class);
                Bf = snapshot.child("BreakfastTime").getValue(String.class);
                //  String ty = snapshot.child("type").getValue(String.class);
                buttonUp.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        String add = Add.getText().toString();

                        DatabaseReference databaseReference5;
                        databaseReference5 = FirebaseDatabase.getInstance().getReference("hotel").child(type).child(userKey);
                        databaseReference5.child("LunchTime").setValue(etLunch);
                        databaseReference5.child("DinnerTime").setValue(etDinner);
                        databaseReference5.child("BreakfastTime").setValue(etBreak);
                        databaseReference5.child("Address").setValue(add);

                        databaseReference5.child("Region").setValue(Region);
                        Toast.makeText(getApplicationContext(), "Update Aplicable From Next Meal" , Toast.LENGTH_SHORT).show();

                    }
                });




            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });






        btp = findViewById(R.id.buttonPu);
        btp1 = findViewById(R.id.buttonRu);
        btp1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DatabaseReference databaseReference;

                databaseReference = FirebaseDatabase.getInstance().getReference("hotel").child(type).child(userKey);
                databaseReference.child("Ostate").setValue("Resume");
                Toast.makeText(getApplicationContext(), "Change Will Be Applicable from next order" , Toast.LENGTH_SHORT).show();
                Intent i=new Intent(getApplicationContext(),MainActivity.class);
                startActivity(i);

            }
        });

        btp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DatabaseReference databaseReference;

                databaseReference = FirebaseDatabase.getInstance().getReference("hotel").child(type).child(userKey);
                databaseReference.child("Ostate").setValue("Pause");
                Toast.makeText(getApplicationContext(), " Changes will  Be Applicable from next order" , Toast.LENGTH_SHORT).show();
                Intent i=new Intent(getApplicationContext(),MainActivity.class);
                startActivity(i);

            }
        });

        buttonCC = findViewById(R.id.buttonCC);



        String  cadate=date;
        String    catime = String.valueOf(c.get(Calendar.HOUR)) + " "  + String.valueOf(c.get(Calendar.MINUTE));

        buttonCC.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DatabaseReference databaseReference1;
                databaseReference = FirebaseDatabase.getInstance().getReference("hotel").child(type).child(userKey);

                databaseReference.child("cadate").setValue(cadate);
                databaseReference.child("catime").setValue(catime);

                databaseReference1 = FirebaseDatabase.getInstance().getReference("history").child(userKey);

                moveFirebaseRecord( databaseReference,  databaseReference1);

                databaseReference.removeValue();
                Toast.makeText(getApplicationContext(), "order Canceld " , Toast.LENGTH_SHORT).show();
                Intent i=new Intent(UpdateAQ.this,MainActivity.class);
                startActivity(i);

            }
        });


    }
    private void moveFirebaseRecord(final DatabaseReference fromPath, final DatabaseReference toPath) {
        fromPath.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                toPath.setValue(dataSnapshot.getValue(), new DatabaseReference.CompletionListener() {
                    @Override
                    public void onComplete(DatabaseError firebaseError, @NonNull DatabaseReference firebase) {
                        if (firebaseError != null) {
                            System.out.println("Copy failed");
                        } else {
                            System.out.println("Success");

                        }
                    }
                });

            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });
    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

        String item = parent.getItemAtPosition(position).toString();

        Toast.makeText(parent.getContext(), "Selected: " + item, Toast.LENGTH_LONG).show();



    }

    //

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }

    private void Bf(String Bf, int ctH, int ctM){
        if(   (Bf=="7AM" && (7-ctH)<2)   ){
            Toast.makeText(UpdateAQ.this, "order can be updated after" + Bf , Toast.LENGTH_SHORT).show();

        }
        if(   (Bf=="8AM" && (8-ctH)<2)   ){
            Toast.makeText(UpdateAQ.this, "order can be updated after" + Bf , Toast.LENGTH_SHORT).show();

        }
        if(   (Bf=="9AM" && (9-ctH)<=2) && ctM!=0  ){
            Toast.makeText(UpdateAQ.this, "order can be updated after" + Bf , Toast.LENGTH_SHORT).show();

        }
        if(   (Bf=="10AM" && (10-ctH)<=2) && ctM!=0  ){
            Toast.makeText(UpdateAQ.this, "order can be updated after" + Bf , Toast.LENGTH_SHORT).show();

        }

    }

    private int Lf(String Lf, int ctH, int ctM){
        if(   (Lf=="1PM" && (13-ctH)<=2)   ){

            return 1;
        }
        if(   (Lf=="2PM" && (14-ctH)<=2)  ){

            return 1;
        }
        if(   (Lf=="3PM" && (15-ctH)<=2)  ){
            Toast.makeText(UpdateAQ.this, "order can be updated after" + Lf , Toast.LENGTH_SHORT).show();
            return 1;
        }

        return 0;
    }

    private int Df(String Df, int ctH, int ctM){
        if(   (Df=="7PM" && (19-ctH)<=2) && ctM!=0  ){
            Toast.makeText(UpdateAQ.this, "order can be updated after" + Df , Toast.LENGTH_SHORT).show();
            return 1;
        }
        if(   (Df=="8PM" && (20-ctH)<=2)   ){
            Toast.makeText(UpdateAQ.this, "order can be updated after" + Df , Toast.LENGTH_SHORT).show();
            return 1;
        }
        if(   (Df=="9PM" && (21-ctH)<=2)  ){
            Toast.makeText(UpdateAQ.this, "order can be updated after" + Df , Toast.LENGTH_SHORT).show();
            return 1;
        }
        if(   (Df=="10PM" && (22-ctH)<=2)   ){
            Toast.makeText(UpdateAQ.this, "order can be updated after" + Df , Toast.LENGTH_SHORT).show();
            return 1;
        }

        return 0;
    }



}