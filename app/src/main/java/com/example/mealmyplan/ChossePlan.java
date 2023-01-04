package com.example.mealmyplan;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
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

import java.util.HashMap;
import java.util.Objects;

public class ChossePlan extends AppCompatActivity { /// ConfirmPlan


    Button BtnPay, Btn1Month, Btn2Month, Btn3Month,Btn;

    DatabaseReference databaseReference;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chosse_plan);

        //BtnViwPlan = findViewById(R.id.button);
        Btn1Month = findViewById(R.id.button2);
        Btn2Month = findViewById(R.id.btp1);
        Btn3Month = findViewById(R.id.button4);
        BtnPay= findViewById(R.id.bnnnnn);
        Btn=findViewById(R.id.bn1);
        Btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i=new Intent(ChossePlan.this,MainActivity.class);
                startActivity(i);
            }
        });
        Btn1Month.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FirebaseAuth firebaseAuth = FirebaseAuth.getInstance();
                FirebaseUser user = firebaseAuth.getCurrentUser();
                String userKey = Objects.requireNonNull(user).getUid();
                DatabaseReference databaseReference;
                databaseReference= FirebaseDatabase.getInstance().getReference("Users");
                databaseReference.addValueEventListener(new ValueEventListener() {
                    @Override
                    public void onDataChange(@NonNull DataSnapshot snapshot) {
                     String   Food=snapshot.child(userKey).child("UserInfo").child("Food").getValue(String.class);
                     String   Vitamin=snapshot.child(userKey).child("UserInfo").child("Vitamins").getValue(String.class);
                        String tWeight=snapshot.child(userKey).child("UserInfo").child("Tweight").getValue(String.class);
                        String cWeight=snapshot.child(userKey).child("UserInfo").child("weight").getValue(String.class);
                        int x=Integer.parseInt(cWeight);
                        int y=Integer.parseInt(tWeight);
                        String Goal;

                        if(x<y){
                            Goal="WeightGain";
                        }
                        else if (y<x){
                            Goal="LossWeight";
                        }
                        else{
                            Goal="MaintainWeight";
                        }
                        Intent i=new Intent(getApplicationContext(),Breakfast.class);
                        i.putExtra("Vitamin",Vitamin);
                        i.putExtra("Food",Food);
                        i.putExtra("Goal",Goal);
                        startActivity(i);




                    }

                    @Override
                    public void onCancelled(@NonNull DatabaseError error) {

                    }
                });


            }
        });
        Btn2Month.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                    FirebaseAuth firebaseAuth = FirebaseAuth.getInstance();
                    FirebaseUser user = firebaseAuth.getCurrentUser();
                    String userKey = Objects.requireNonNull(user).getUid();
                    DatabaseReference databaseReference;
                    databaseReference= FirebaseDatabase.getInstance().getReference("Users");
                    databaseReference.addValueEventListener(new ValueEventListener() {
                        @Override
                        public void onDataChange(@NonNull DataSnapshot snapshot) {
                            String   Food=snapshot.child(userKey).child("UserInfo").child("Food").getValue(String.class);
                            String   Vitamin=snapshot.child(userKey).child("UserInfo").child("Vitamins").getValue(String.class);
                            String tWeight=snapshot.child(userKey).child("UserInfo").child("Tweight").getValue(String.class);
                            String cWeight=snapshot.child(userKey).child("UserInfo").child("weight").getValue(String.class);
                            int x=Integer.parseInt(cWeight);
                            int y=Integer.parseInt(tWeight);
                            String Goal;

                            if(x<y){
                                Goal="WeightGain";
                            }
                            else if (y<x){
                                Goal="LossWeight";
                            }
                            else{
                                Goal="MaintainWeight";
                            }
                            Intent i=new Intent(getApplicationContext(),Lunch.class);
                            i.putExtra("Vitamin",Vitamin);
                            i.putExtra("Food",Food);
                            i.putExtra("Goal",Goal);
                            startActivity(i);




                        }

                        @Override
                        public void onCancelled(@NonNull DatabaseError error) {

                        }
                    });


                }




        });
        Btn3Month.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                    FirebaseAuth firebaseAuth = FirebaseAuth.getInstance();
                    FirebaseUser user = firebaseAuth.getCurrentUser();
                assert user != null;
                String userKey = user.getUid();
                    DatabaseReference databaseReference;
                    databaseReference= FirebaseDatabase.getInstance().getReference("Users");
                    databaseReference.addValueEventListener(new ValueEventListener() {
                        @Override
                        public void onDataChange(@NonNull DataSnapshot snapshot) {
                            String   Food=snapshot.child(userKey).child("UserInfo").child("Food").getValue(String.class);
                            String   Vitamin=snapshot.child(userKey).child("UserInfo").child("Vitamins").getValue(String.class);
                            String tWeight=snapshot.child(userKey).child("UserInfo").child("Tweight").getValue(String.class);
                            String cWeight=snapshot.child(userKey).child("UserInfo").child("weight").getValue(String.class);
                            int x=Integer.parseInt(cWeight);
                            int y=Integer.parseInt(tWeight);
                            String Goal;

                            if(x<y){
                                Goal="WeightGain";
                            }
                            else if (y<x){
                                Goal="LossWeight";
                            }
                            else{
                                Goal="MaintainWeight";
                            }
                            Intent i=new Intent(getApplicationContext(),Dinner.class);
                            i.putExtra("Vitamin",Vitamin);
                            i.putExtra("Food",Food);
                            i.putExtra("Goal",Goal);
                            startActivity(i);




                        }

                        @Override
                        public void onCancelled(@NonNull DatabaseError error) {

                        }
                    });




            }
        });
        BtnPay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i=new Intent(ChossePlan.this,Pay.class);
                startActivity(i);




            }
        });

    }
}