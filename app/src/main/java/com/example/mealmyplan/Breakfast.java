package com.example.mealmyplan;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.firebase.ui.database.FirebaseRecyclerOptions;
import com.google.firebase.database.FirebaseDatabase;


public class Breakfast extends AppCompatActivity {
    Faadp adapter;
    TextView txt;
    String Food,Vitamin,Goal,Food1,Vitamin1,Goal1;
    RecyclerView rcv;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_breakfast);
       rcv=findViewById(R.id.rcv000);
       show();
    }

    private void show(){
        Intent intent=getIntent();
        String Vitamin1=intent.getStringExtra("Vitamin");
        String Food1=intent.getStringExtra("Food");
        String Goal1=intent.getStringExtra("Goal");

        FirebaseRecyclerOptions<mode3> options =
                new FirebaseRecyclerOptions.Builder<mode3>()
                        .setQuery(FirebaseDatabase.getInstance().getReference().child("Plan").child(Food1).child(Goal1).child(Vitamin1).child("Breakfast"), mode3.class)
                        .build();

        adapter = new Faadp(options);
        rcv.setLayoutManager(new LinearLayoutManager(this));
        rcv.setAdapter(adapter);

    }
    @Override
    protected void onStart() {
        super.onStart();
        adapter.startListening();
    }

    @Override
    protected void onStop() {
        super.onStop();
        adapter.stopListening();
    }

}