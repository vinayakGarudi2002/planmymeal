package com.example.mealmyplan;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.firebase.ui.database.FirebaseRecyclerOptions;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

public class DinnerC extends AppCompatActivity {
    Faadp1 adapter;
    RecyclerView rcv;
    Button btn,btp;
    ArrayList<mode3> ab ;
    String root,goal,vit;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dinner_c);

        btn = findViewById(R.id.btn2);

        rcv = findViewById(R.id.rcv000);

        btp = findViewById(R.id.btn1);

        btp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(DinnerC.this,CPnew.class);
                startActivity(i);
            }
        });



        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ab =  new ArrayList<>();
                for(mode3 m : adapter.list){

                    ab.add(new mode3(m.getName(), m.getImg(), m.getCal(), m.getProt(), m.getCarb(),m.getFat(), m.getVitamin()));

                }

                if(adapter.list.size()<0){
                    Toast.makeText(DinnerC.this,"Check at least 10 ",Toast.LENGTH_SHORT).show();

                }else {
                    DatabaseReference dataReference;
                    FirebaseAuth firebaseAuth = FirebaseAuth.getInstance();
                    FirebaseUser user = firebaseAuth.getCurrentUser();
                    String userKey = user.getUid();
                    Intent i=getIntent();
//                       userKey=i.getStringExtra("userKey");
                    //  String Food=i.getStringExtra("Food");
                    String phoneno=i.getStringExtra("phoneno");
                    //=i.getStringExtra("userKey");
                    dataReference = FirebaseDatabase.getInstance().getReference("customU").child(userKey).child("D");
                    dataReference.addValueEventListener(new ValueEventListener() {
                        @Override
                        public void onDataChange(@NonNull DataSnapshot snapshot) {
                            dataReference.setValue(ab);
                        }

                        @Override
                        public void onCancelled(@NonNull DatabaseError error) {

                        }
                    });
                    Intent i1=new Intent(DinnerC.this,CPnew.class);
                    String s ="ok";
                    i1.putExtra("D","ok");
                    startActivity(i1);
                }




            }

        });
        show();



    }
    private  void show(){
        Intent intent=getIntent();
        String Food=intent.getStringExtra("Food");
        FirebaseRecyclerOptions<mode3> options =
                new FirebaseRecyclerOptions.Builder<mode3>()
                        .setQuery(FirebaseDatabase.getInstance().getReference().child("postc").child(Food).child("D"), mode3.class)
                        .build();

        adapter = new Faadp1(options);
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