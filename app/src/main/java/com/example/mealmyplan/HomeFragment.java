package com.example.mealmyplan;

import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
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
public class HomeFragment extends Fragment {

    TextView tvName, tvProt, tvCarbs, tvCalar, tvVitam,tvFat;
    Button BtnOrdePlan,Btnclc,BtnCoustomPlan;
    private DatabaseReference databaseReference,databaseReference1;
    FirebaseUser user;



    public HomeFragment() {

    }



    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);



    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {



        View view = inflater.inflate(R.layout.fragment_home, container, false);
        tvName = view.findViewById(R.id.tName);
        tvProt = view.findViewById(R.id.tProt);
        tvCarbs = view.findViewById(R.id.tCarbs);
        tvCalar = view.findViewById(R.id.tCalar);
        tvVitam = view.findViewById(R.id.tVitam);
        tvFat = view.findViewById(R.id.tFat);
        BtnOrdePlan = view.findViewById(R.id.BtOrdePlan);
        Btnclc=view.findViewById(R.id.button5);
        BtnCoustomPlan=view.findViewById(R.id.CsPlan);






        Btnclc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FirebaseAuth firebaseAuth = FirebaseAuth.getInstance();
                FirebaseUser user = firebaseAuth.getCurrentUser();
                String userKey = user.getUid();
                FirebaseDatabase firebaseDatabase = FirebaseDatabase.getInstance();
                databaseReference = firebaseDatabase.getReference("Users");

                databaseReference.addValueEventListener(new ValueEventListener() {
                    @Override
                    public void onDataChange(@NonNull DataSnapshot snapshot) {
                        String Name=snapshot.child(userKey).child("UserInfo").child("name").getValue(String.class);
                        String Vitamins =  snapshot.child(userKey).child("UserInfo").child("Vitamins").getValue(String.class);

                        tvName.setText(Name);
                        tvVitam.setText(Vitamins);

                    }

                    @Override
                    public void onCancelled(@NonNull DatabaseError error) {
                        // Toast.makeText(getApplicationContext(), "Enter your mail address", Toast.LENGTH_SHORT).show();
                    }
                });



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







        BtnOrdePlan.setOnClickListener(new View.OnClickListener() {
            @Override

            public void onClick(View v)
            {
                int a =1;
                FirebaseAuth firebaseAuth = FirebaseAuth.getInstance();
                FirebaseUser user = firebaseAuth.getCurrentUser();
                String userKey = user.getUid();
                databaseReference = FirebaseDatabase.getInstance().getReference("hotel");
                databaseReference.addValueEventListener(new ValueEventListener() {
                    @Override
                    public void onDataChange(@NonNull DataSnapshot snapshot) {
                        if(snapshot.child("CustomOrder").hasChild(userKey)){
                           // Toast.makeText(getActivity().getApplicationContext(), "order already exist " , Toast.LENGTH_SHORT).show();

                        }else if(snapshot.child("directOrder").hasChild(userKey)){

                          //  Toast.makeText(getActivity().getApplicationContext(), "order already exist " , Toast.LENGTH_SHORT).show();
                        }else{
                            Intent intent=new Intent(getActivity().getApplicationContext(),ChossePlan.class);
                            startActivity(intent);
                        }
                    }

                    @Override
                    public void onCancelled(@NonNull DatabaseError error) {

                    }
                });







            }


        });
        BtnCoustomPlan.setOnClickListener(new View.OnClickListener() {
            @Override

            public void onClick(View v)
            {
                FirebaseAuth firebaseAuth = FirebaseAuth.getInstance();
                FirebaseUser user = firebaseAuth.getCurrentUser();
                String userKey = user.getUid();
                databaseReference = FirebaseDatabase.getInstance().getReference("hotel");
                databaseReference.addValueEventListener(new ValueEventListener() {
                    @Override
                    public void onDataChange(@NonNull DataSnapshot snapshot) {
                        if(snapshot.child("CustomOrder").hasChild(userKey)){
                            //Toast.makeText(getActivity().getApplicationContext(), "order already exist " , Toast.LENGTH_SHORT).show();
//
                        }else if(snapshot.child("directOrder").hasChild(userKey)){
                           // Toast.makeText(getActivity().getApplicationContext(), "order already exist " , Toast.LENGTH_SHORT).show();
                        }else{
                            Intent intent=new Intent(getActivity().getApplicationContext(),CPnew.class);
                            startActivity(intent);
                        }
                    }

                    @Override
                    public void onCancelled(@NonNull DatabaseError error) {

                    }
                });






            }


        });


        return view;

    }


}

