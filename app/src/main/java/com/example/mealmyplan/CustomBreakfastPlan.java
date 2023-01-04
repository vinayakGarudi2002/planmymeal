package com.example.mealmyplan;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.firebase.ui.database.FirebaseRecyclerOptions;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.FirebaseDatabase;


public class CustomBreakfastPlan extends AppCompatActivity {
    Faadp adapter;
    Button btnback;
    TextView txt;
    String Food,Vitamin,Goal,Food1,Vitamin1,Goal1;
    RecyclerView rcv;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_custom_breakfast_plan);
        rcv=findViewById(R.id.rcv000);
        btnback=findViewById(R.id.button17);
        btnback.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i=new Intent(CustomBreakfastPlan.this,ChefCustomClass.class);
                startActivity(i);

            }
        });

        show();
    }

    private void show(){
        Intent intent=getIntent();
        String Vitamin1=intent.getStringExtra("Vitamin");
        String Food1=intent.getStringExtra("Food");
        String Goal1=intent.getStringExtra("Goal");
//       Intent i=getIntent();
//       String userKey=i.getStringExtra("userKey");

        FirebaseAuth firebaseAuth = FirebaseAuth.getInstance();
        FirebaseUser user = firebaseAuth.getCurrentUser();
  //      String userKey = "NscrDouSvFPQOCI0WOApsJLzSLl2";
        Intent i=getIntent();
        String phoneno=i.getStringExtra("phoneno");
        String Time=i.getStringExtra("Time");


        FirebaseRecyclerOptions<mode3> options =
                new FirebaseRecyclerOptions.Builder<mode3>()
                        .setQuery(FirebaseDatabase.getInstance().getReference("customU").child(phoneno).child(Time), mode3.class)
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