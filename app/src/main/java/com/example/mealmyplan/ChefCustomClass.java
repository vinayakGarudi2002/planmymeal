package com.example.mealmyplan;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.firebase.ui.database.FirebaseRecyclerOptions;
import com.google.firebase.database.FirebaseDatabase;

public class ChefCustomClass extends AppCompatActivity {
    Faadp5 adapter;
    RecyclerView rcv;
    Button btp;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chef_custom_class);
        rcv = findViewById(R.id.rcv000);
        btp = findViewById(R.id.btn1);

        btp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(ChefCustomClass.this,Chef1.class);
                startActivity(i);
            }
        });
        FirebaseRecyclerOptions<mode8> options =
                new FirebaseRecyclerOptions.Builder<mode8>()
                        .setQuery(FirebaseDatabase.getInstance().getReference("hotel").child("CustomOrder"), mode8.class)
                        .build();

        adapter = new Faadp5(options);
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