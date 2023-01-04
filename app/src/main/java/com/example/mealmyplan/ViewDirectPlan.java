package com.example.mealmyplan;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.Objects;

public class ViewDirectPlan extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_direct_plan);

        Button btnbreak, btnlunch, btndinner;
        btnbreak = findViewById(R.id.bbf);
        btnlunch = findViewById(R.id.blp);
        btndinner = findViewById(R.id.bdp);


        btnbreak.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FirebaseAuth firebaseAuth = FirebaseAuth.getInstance();
                FirebaseUser user = firebaseAuth.getCurrentUser();
                String userKey = Objects.requireNonNull(user).getUid();
                DatabaseReference databaseReference;
                databaseReference = FirebaseDatabase.getInstance().getReference("Users");
                databaseReference.addValueEventListener(new ValueEventListener() {
                    @Override
                    public void onDataChange(@NonNull DataSnapshot snapshot) {
                        String Food = snapshot.child(userKey).child("UserInfo").child("Food").getValue(String.class);
                        String phoneno = snapshot.child(userKey).child("UserInfo").child("phoneno").getValue(String.class);

                        Intent i = new Intent(getApplicationContext(), CustomBreakfastPlan.class);
                        i.putExtra("Food", Food);
                        i.putExtra("phoneno", userKey);
                        i.putExtra("Time", "Bf");
                        startActivity(i);


                    }

                    @Override
                    public void onCancelled(@NonNull DatabaseError error) {

                    }
                });

            }
        });


        btnlunch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FirebaseAuth firebaseAuth = FirebaseAuth.getInstance();
                FirebaseUser user = firebaseAuth.getCurrentUser();
                String userKey = Objects.requireNonNull(user).getUid();
                DatabaseReference databaseReference;
                databaseReference = FirebaseDatabase.getInstance().getReference("Users");
                databaseReference.addValueEventListener(new ValueEventListener() {
                    @Override
                    public void onDataChange(@NonNull DataSnapshot snapshot) {
                        String Food = snapshot.child(userKey).child("UserInfo").child("Food").getValue(String.class);
                        String phoneno = snapshot.child(userKey).child("UserInfo").child("phoneno").getValue(String.class);

                        Intent i = new Intent(getApplicationContext(), CustomBreakfastPlan.class);
                        i.putExtra("Food", Food);
                        i.putExtra("phoneno", userKey);
                        i.putExtra("Time", "L");
                        startActivity(i);


                    }

                    @Override
                    public void onCancelled(@NonNull DatabaseError error) {

                    }
                });

            }
        });


        btndinner.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FirebaseAuth firebaseAuth = FirebaseAuth.getInstance();
                FirebaseUser user = firebaseAuth.getCurrentUser();
                String userKey = Objects.requireNonNull(user).getUid();
                DatabaseReference databaseReference;
                databaseReference = FirebaseDatabase.getInstance().getReference("Users");
                databaseReference.addValueEventListener(new ValueEventListener() {
                    @Override
                    public void onDataChange(@NonNull DataSnapshot snapshot) {
                        String Food = snapshot.child(userKey).child("UserInfo").child("Food").getValue(String.class);
                        String phoneno = snapshot.child(userKey).child("UserInfo").child("phoneno").getValue(String.class);

                        Intent i = new Intent(getApplicationContext(), CustomBreakfastPlan.class);
                        i.putExtra("Food", Food);
                        i.putExtra("phoneno", userKey);
                        i.putExtra("Time", "D");
                        startActivity(i);


                    }

                    @Override
                    public void onCancelled(@NonNull DatabaseError error) {

                    }
                });

            }
        });

    }

}