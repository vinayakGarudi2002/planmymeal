package com.example.mealmyplan;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.Objects;

public class DashBoard extends AppCompatActivity {
    TextView tvName, tvProt, tvCarbs, tvCalar, tvVitam,tvFat;
    Button BtnOrdePlan,b6;
    DatabaseReference databaseReference,databaseReference1;

    FirebaseUser user;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dash_board);




        tvName = findViewById(R.id.tName);
        tvProt = findViewById(R.id.tProt);
        tvCarbs = findViewById(R.id.tCarbs);
        tvCalar = findViewById(R.id.tCalar);
        tvVitam = findViewById(R.id.tVitam);
        tvFat = findViewById(R.id.tFat);
        BtnOrdePlan = findViewById(R.id.BtOrdePlan);
        b6=findViewById(R.id.button6);


//            databaseReference.addListenerForSingleValueEvent(new ValueEventListener() {
//                @Override
//                public void onDataChange(@NonNull DataSnapshot snapshot) {
//
//                    String cals =  snapshot.child("targetCalorie").getValue().toString();
//                    String Protein =  snapshot.child("targetProtein").getValue().toString();
//                    String Carbs =  snapshot.child("targetCarbs").getValue().toString();
//                    String Vitamins =  snapshot.child("Vitamins").getValue().toString();
//                    String Fat = snapshot.child("targetFat").getValue().toString();
//
//
//                    tvProt.setText(Protein);
//                    tvCarbs.setText(Carbs);
//                    tvCalar.setText(cals);
//                    tvVitamin.setText(Vitamins);
//                    tvFat.setText(Fat);
//                }
//
//                @Override
//                public void onCancelled(@NonNull DatabaseError error) {
//
//                }
//            });

        FirebaseAuth firebaseAuth = FirebaseAuth.getInstance();
        FirebaseUser user = firebaseAuth.getCurrentUser();
        String userKey = user.getUid();

        BtnOrdePlan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FirebaseDatabase firebaseDatabase = FirebaseDatabase.getInstance();
                databaseReference = firebaseDatabase.getReference("Users");

                databaseReference.addValueEventListener(new ValueEventListener() {
                    @Override
                    public void onDataChange(@NonNull DataSnapshot snapshot) {
                      // String Name=snapshot.child(userKey).child("UserInfo").child("name").getValue(String.class);
                        String Vitamins =  snapshot.child(userKey).child("UserInfo").child("Vitamins").getValue(String.class);

                      //  tvName.setText(Name);
                        tvVitam.setText(Vitamins);

                    }

                    @Override
                    public void onCancelled(@NonNull DatabaseError error) {
                        Toast.makeText(getApplicationContext(), "Enter your mail address", Toast.LENGTH_SHORT).show();
                    }
                });








                FirebaseAuth firebaseAuth = FirebaseAuth.getInstance();
                FirebaseUser user = firebaseAuth.getCurrentUser();
                String userKey = user.getUid();

                FirebaseDatabase firebaseDatabase1 = FirebaseDatabase.getInstance();
                databaseReference1 = firebaseDatabase1.getReference("Userid");
                databaseReference1.addValueEventListener(new ValueEventListener() {
                    @Override
                    public void onDataChange(@NonNull DataSnapshot snapshot) {
                        String cals =  snapshot.child(userKey).child("UserInfo").child("targetCalorie").getValue(String.class);
                        String Protien =  snapshot.child(userKey).child("UserInfo").child("targetProtein").getValue(String.class);
                        String Carbs =  snapshot.child(userKey).child("UserInfo").child("targetCarbs").getValue(String.class);

                        String Fat = snapshot.child(userKey).child("UserInfo").child("targetFat").getValue(String.class);

                        tvProt.setText(Protien);
                        tvCarbs.setText(Carbs);
                        tvCalar.setText(cals);

                        tvFat.setText(Fat);


                    }

                    @Override
                    public void onCancelled(@NonNull DatabaseError error) {

                    }
                });




            }
        });


      b6.setOnClickListener(new View.OnClickListener() {
          @Override
          public void onClick(View v) {
              Intent intent = new Intent(DashBoard.this,ChossePlan.class);
              startActivity(intent);
          }
      });


    }

}