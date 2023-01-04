package com.example.mealmyplan;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class ProfileFragment extends Fragment {

    TextView tvName, tvPhone, tvAge, tvHeight, tvTargetWeight, tvVitamin, tvWeight;
    Button BtnUpdate, BtnShow,BtnPlan;
    private DatabaseReference databaseReference, databaseReference1;
    FirebaseUser user;

    public ProfileFragment() {

    }

    public static ProfileFragment newInstance(String param1, String param2) {
        ProfileFragment fragment = new ProfileFragment();
//        Bundle args = new Bundle();
//        args.putString(ARG_PARAM1, param1);
//        args.putString(ARG_PARAM2, param2);
        //  fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_profile, container, false);
        tvName = view.findViewById(R.id.tName123);
        tvPhone = view.findViewById(R.id.tPhone);
        tvAge = view.findViewById(R.id.tAge);
        tvHeight = view.findViewById(R.id.tHeight);
        tvWeight = view.findViewById(R.id.editTextWeight);
        tvTargetWeight = view.findViewById(R.id.textView20);
        tvVitamin = view.findViewById(R.id.tVitam123);
        BtnUpdate = view.findViewById(R.id.BtUpdate);
        BtnShow = view.findViewById(R.id.bShow);
        BtnPlan=view.findViewById(R.id.Bsp);

        BtnPlan.setOnClickListener(new View.OnClickListener() {
            @Override

            public void onClick(View v)
            {
                DatabaseReference databaseReference;
                FirebaseAuth firebaseAuth = FirebaseAuth.getInstance();
                FirebaseUser user = firebaseAuth.getCurrentUser();
                String userKey = user.getUid();
                databaseReference = FirebaseDatabase.getInstance().getReference("hotel");
                databaseReference.addValueEventListener(new ValueEventListener() {
                    @Override
                    public void onDataChange(@NonNull DataSnapshot snapshot) {
                        if(snapshot.child("directOrder").hasChild(userKey)){
                            Intent intent = new Intent(getActivity().getApplicationContext(),ChossePlan1.class);
                            startActivity(intent);
                            //Toast.makeText(getActivity().getApplicationContext(), "order already exist " , Toast.LENGTH_SHORT).show();

                        }else if(snapshot.child("CustomOrder").hasChild(userKey)){
                            // Toast.makeText(getActivity().getApplicationContext(), "order already exist " , Toast.LENGTH_SHORT).show();
                            Intent intent = new Intent(getActivity().getApplicationContext(),ViewDirectPlan.class);
                            startActivity(intent);


                        }else{
                            Toast.makeText(getActivity().getApplicationContext(), "order Not exist " , Toast.LENGTH_SHORT).show();
                        }
                    }

                    @Override
                    public void onCancelled(@NonNull DatabaseError error) {

                    }
                });






            }


        });

        BtnShow.setOnClickListener(new View.OnClickListener() {
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
                        String Name = snapshot.child(userKey).child("UserInfo").child("name").getValue(String.class);
                        String Vitamins = snapshot.child(userKey).child("UserInfo").child("Vitamins")
                                .getValue(String.class);
                        String Phone = snapshot.child(userKey).child("UserInfo").child("phoneno")
                                .getValue(String.class);
                        String Age = snapshot.child(userKey).child("UserInfo").child("age").getValue(String.class);
                        String Height = snapshot.child(userKey).child("UserInfo").child("height")
                                .getValue(String.class);
                        String Weight = snapshot.child(userKey).child("UserInfo").child("weight")
                                .getValue(String.class);
                        String Tweight = snapshot.child(userKey).child("UserInfo").child("Tweight")
                                .getValue(String.class);

                        tvName.setText(Name);
                        tvVitamin.setText(Vitamins);

                        tvPhone.setText(Phone);
                        tvAge.setText(Age);
                        tvHeight.setText(Height);
                        tvWeight.setText(Weight);
                        tvTargetWeight.setText(Tweight);

                    }

                    @Override
                    public void onCancelled(@NonNull DatabaseError error) {

                    }

                });

            }
        });

        BtnUpdate.setOnClickListener(new View.OnClickListener() {
            @Override

            public void onClick(View v) {

                Intent intent = new Intent(getActivity().getApplicationContext(), UpdateInfo.class);
                startActivity(intent);

            }

        });

        return view;
    }
}