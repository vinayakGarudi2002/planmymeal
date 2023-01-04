package com.example.mealmyplan;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
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

import java.util.Objects;

public class CPnew extends AppCompatActivity { /// ConfirmPlan


    Button BtnViwPlan, Btn1Month, Btn2Month, Btn3Month,BtnPay,Btn;

    DatabaseReference databaseReference;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cpnew);

        //BtnViwPlan = findViewById(R.id.button);
        Btn1Month = findViewById(R.id.button2);
        Btn2Month = findViewById(R.id.btp1);
        Btn3Month = findViewById(R.id.button4);
        BtnPay=findViewById(R.id.bnnnnn);
        Btn=findViewById(R.id.bn1);

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
                        String   phoneno=snapshot.child(userKey).child("UserInfo").child("phoneno").getValue(String.class);

                        Intent i=new Intent(getApplicationContext(),BreakfastC.class);
                        i.putExtra("Food",Food);
                        i.putExtra("phoneno",phoneno);
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
                        String   phoneno=snapshot.child(userKey).child("UserInfo").child("phoneno").getValue(String.class);

                        Intent i=new Intent(getApplicationContext(),LunchC.class);
                        i.putExtra("Food",Food);
                        i.putExtra("phoneno",phoneno);
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
                String userKey = Objects.requireNonNull(user).getUid();
                DatabaseReference databaseReference;
                databaseReference= FirebaseDatabase.getInstance().getReference("Users");
                databaseReference.addValueEventListener(new ValueEventListener() {
                    @Override
                    public void onDataChange(@NonNull DataSnapshot snapshot) {
                        String   Food=snapshot.child(userKey).child("UserInfo").child("Food").getValue(String.class);
                        String   phoneno=snapshot.child(userKey).child("UserInfo").child("phoneno").getValue(String.class);

                        Intent i=new Intent(getApplicationContext(),DinnerC.class);
                        i.putExtra("Food",Food);
                        i.putExtra("phoneno",phoneno);
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

                Intent i = getIntent();
                String Bf  = i.getStringExtra("Bf");
                String L  = i.getStringExtra("L");
                String D  = i.getStringExtra("D");
             String s ="ok";





//                if(Bf!=s){
//                    Toast.makeText(CPnew.this,"Custom Your Break Fast",Toast.LENGTH_SHORT).show();
//                }
//                else if (D!=s) {
//                    Toast.makeText(CPnew.this,"Custom Your Dinner",Toast.LENGTH_SHORT).show();
//                }else if(L!=s){
//                    Toast.makeText(CPnew.this,"Custom Your Lunch",Toast.LENGTH_SHORT).show();
//                }else{
                    FirebaseAuth firebaseAuth = FirebaseAuth.getInstance();
                    FirebaseUser user = firebaseAuth.getCurrentUser();
                    String userKey = user.getUid();

                    databaseReference = FirebaseDatabase.getInstance().getReference("hotel");
                    databaseReference.addValueEventListener(new ValueEventListener() {
                        @Override
                        public void onDataChange(@NonNull DataSnapshot snapshot) {

//                            if(snapshot.child("CustomOrder").child(userKey).exists()){
//                                Toast.makeText(CPnew.this,"order exist",Toast.LENGTH_SHORT).show();
//                            }else if(snapshot.child("directOrder").child(userKey).exists()){
//                                Toast.makeText(CPnew.this,"order exist",Toast.LENGTH_SHORT).show();
//
//                            }else{
                                Intent i=new Intent(CPnew.this,Pay2.class);
                                startActivity(i);
                           // }



                        }

                        @Override
                        public void onCancelled(@NonNull DatabaseError error) {
                            Toast.makeText(CPnew.this,"error ",Toast.LENGTH_SHORT).show();
                        }
                    });
                }




               ;
          //  }


        });
        Btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i=new Intent(CPnew.this,MainActivity.class);
                startActivity(i);
            }
        });
    }
}