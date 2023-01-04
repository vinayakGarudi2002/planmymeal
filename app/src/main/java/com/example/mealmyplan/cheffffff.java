package com.example.mealmyplan;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.firebase.ui.database.FirebaseRecyclerOptions;
import com.google.firebase.database.FirebaseDatabase;

public class cheffffff extends AppCompatActivity {
    RecyclerView rcv2;
    Faadp4 adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cheffffff);
        rcv2=findViewById(R.id.rcv2);
        FirebaseRecyclerOptions<mode7> options =
                new FirebaseRecyclerOptions.Builder<mode7>()
                        .setQuery(FirebaseDatabase.getInstance().getReference("hotel").child("directOrder"), mode7.class)
                        .build();
        adapter = new Faadp4(options);
        rcv2.setLayoutManager(new LinearLayoutManager(this));
        rcv2.setAdapter(adapter);
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