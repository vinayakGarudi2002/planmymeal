package com.example.mealmyplan;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.tasks.OnSuccessListener;
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
import java.util.HashMap;
import java.util.List;

public class Pay2 extends AppCompatActivity {
    String Food,cdate,ctime,cadate,catime;
    Button cb,bpay,btnmyplan;
    String item,getprice;
    String getEdate;
    Spinner  spinner4;
    int a;


    DatabaseReference databaseReference,df1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pay);
        TextView te,tp;
        List<String> list4 = new ArrayList<String>();
        list4.add("One Month");
        list4.add("Two Month");
        list4.add("Three Month");

        spinner4 = (Spinner)findViewById(R.id.spinner77);
        ArrayAdapter<String> arrayAdapter4 = new ArrayAdapter<String>(Pay2.this, android.R.layout.simple_spinner_item, list4);
        arrayAdapter4.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner4.setAdapter(arrayAdapter4);
        spinner4.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

                spinner4.setSelection(position);
                item = parent.getItemAtPosition(position).toString();

                Toast.makeText(parent.getContext(), "Selected: " + item, Toast.LENGTH_LONG).show();

                a=1;


            }
            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
        btnmyplan=findViewById(R.id.button7);




        te = findViewById(R.id.T56);
        tp = findViewById(R.id.T94);
        cb = findViewById(R.id.clc1);
        cb.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                a=0;
                if(item == "One Month") {
                    @SuppressLint("SimpleDateFormat") SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
                    Calendar c = Calendar.getInstance();

                    String date = sdf.format(c.getTime());
                    cdate=date;
                    c.add(Calendar.MONTH, 1);
                    String Edate = sdf.format(c.getTime());
                    // String getdate =date.getText().toString();
                    getEdate = Edate;
                    te.setText(getEdate);
                    getprice = "5000" ;
                    tp.setText(getprice);

                }else if(item == "Two Month"){
                    @SuppressLint("SimpleDateFormat") SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
                    Calendar c = Calendar.getInstance();

                    String date = sdf.format(c.getTime());
                    cdate=date;
                    c.add(Calendar.MONTH, 2);
                    String Edate = sdf.format(c.getTime());
                    // String getdate =date.getText().toString();
                    getEdate = Edate;
                    te.setText(getEdate);
                    getprice = "9000" ;
                    tp.setText(getprice);
                }else{
                    @SuppressLint("SimpleDateFormat") SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
                    Calendar c = Calendar.getInstance();

                    String date = sdf.format(c.getTime());
                    cdate=date;
                    c.add(Calendar.MONTH, 3);
                    String Edate = sdf.format(c.getTime());
                    // String getdate =date.getText().toString();
                    getEdate = Edate;
                    te.setText(getEdate);
                    getprice = "12000" ;
                    tp.setText(getprice);


                }
            }
        });
        FirebaseAuth firebaseAuth = FirebaseAuth.getInstance();
        FirebaseUser user = firebaseAuth.getCurrentUser();
        String userKey = user.getUid();
        bpay = findViewById(R.id.btp1);

        Calendar c = Calendar.getInstance();
        ctime = String.valueOf(c.get(Calendar.HOUR)) + " "  + String.valueOf(c.get(Calendar.MINUTE));





        bpay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if(a==0){
                    df1 = FirebaseDatabase.getInstance().getReference("Users");
                    df1.addValueEventListener(new ValueEventListener() {
                        @Override
                        public void onDataChange(@NonNull DataSnapshot snapshot) {
                            String getName = snapshot.child(userKey).child("UserInfo").child("name").getValue(String.class);
                            String getAdd = snapshot.child(userKey).child("UserInfo").child("Address").getValue(String.class);
                            String getBreakfastTime = snapshot.child(userKey).child("UserInfo").child("BreakfastTime").getValue(String.class);
                            String getLunchTime = snapshot.child(userKey).child("UserInfo").child("LunchTime").getValue(String.class);
                            String getDinnerTime = snapshot.child(userKey).child("UserInfo").child("DinnerTime").getValue(String.class);
                            String getPhoneNumber = snapshot.child(userKey).child("UserInfo").child("phoneno").getValue(String.class);
                            String getRegion = snapshot.child(userKey).child("UserInfo").child("Region").getValue(String.class);
                            String getUserkey=userKey;
                            String getCalc =  snapshot.child("Userid").child(userKey).child("UserInfo").child("targetCalorie").getValue(String.class);
                            databaseReference = FirebaseDatabase.getInstance().getReference("hotel").child("CustomOrder").child(userKey);
                            databaseReference.addValueEventListener(new ValueEventListener() {
                                @Override
                                public void onDataChange(@NonNull DataSnapshot snapshot) {

                                    HashMap<String,Object> save = new HashMap<>();

                                    String getOstate = "resume";
                                    save.put("expDate",getEdate);
                                    save.put("UserKey",getUserkey);
                                    save.put("name",getName);
                                    save.put("Address",getAdd);
                                    save.put("BreakfastTime",getBreakfastTime);
                                    save.put("LunchTime",getLunchTime);
                                    save.put("DinnerTime",getDinnerTime);
                                    save.put("phoneno",getPhoneNumber);
                                    save.put("Region",getRegion);
                                    save.put("cal",getCalc);
                                    save.put("Ostate",getOstate);

                                    save.put("cdate",cdate);
                                    save.put("ctime",ctime);
                                    cadate = "No";
                                    catime = "No";
                                    save.put("cadate",cadate);
                                    save.put("catime",catime);
                                    save.put("type","CustomOrder");


                                    databaseReference.setValue(save).addOnSuccessListener(new OnSuccessListener<Void>() {
                                        @Override
                                        public void onSuccess(Void unused) {
                                            Toast.makeText(Pay2.this,"Success ",Toast.LENGTH_LONG).show();
                                            Intent i=new Intent(Pay2.this,MainActivity.class);
                                            startActivity(i);
                                            finish();

                                        }
                                    });
                                }

                                @Override
                                public void onCancelled(@NonNull DatabaseError error) {
                                    Toast.makeText(Pay2.this,"error ",Toast.LENGTH_SHORT).show();
                                }
                            });
                        }

                        @Override
                        public void onCancelled(@NonNull DatabaseError error) {

                        }
                    });

                }else{
                    Toast.makeText(Pay2.this, "calculate price " , Toast.LENGTH_LONG).show();
                }






            }

        });


    }


}