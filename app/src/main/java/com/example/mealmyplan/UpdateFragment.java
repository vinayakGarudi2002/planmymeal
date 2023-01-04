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

import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.HashMap;


public class UpdateFragment extends Fragment{
    TextView tEdat, tltime, tdtim, tbtim, tAdr, trg,tweight,tot;

    //    EditText Edat, ltime, dtim, btim, Adr;
    Button BtnViewPlan,BtPlan;
    // final Spinner spinner = (Spinner) findViewById(R.id.spinner);

    Button ClickToUp,BtnShow;
    FirebaseUser user;



    public UpdateFragment() {
        // Required empty public constructor
    }
    public static UpdateFragment newInstance(String param1, String param2) {
        UpdateFragment fragment = new UpdateFragment();
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
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_update, container, false);
        tEdat = view.findViewById(R.id.tE);
        tltime=view.findViewById(R.id.textView7);
        tbtim=view.findViewById(R.id.textView3);
        tdtim=view.findViewById(R.id.textView89);
        tAdr=view.findViewById(R.id.T94);
        trg=view.findViewById(R.id.textViewS);
        tot=view.findViewById(R.id.textViewS56);
//        tweight=view.findViewById(R.id.);



        ClickToUp =view.findViewById(R.id.btPlan);
        BtnShow =view.findViewById(R.id.Btshow);

        // Inflate the layout for this fragment

        BtnShow.setOnClickListener(new View.OnClickListener() {
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
                            //Toast.makeText(getActivity().getApplicationContext(), "order already exist " , Toast.LENGTH_SHORT).show();
                            String Edat = snapshot.child("directOrder").child(userKey).child("expDate").getValue(String.class);
                            String ltime = snapshot.child("directOrder").child(userKey).child("LunchTime").getValue(String.class);
                            String dtim = snapshot.child("directOrder").child(userKey).child("DinnerTime").getValue(String.class);
                            String btim = snapshot.child("directOrder").child(userKey).child("BreakfastTime").getValue(String.class);
                            String Adr = snapshot.child("directOrder").child(userKey).child("Address").getValue(String.class);
                            String rg = snapshot.child("directOrder").child(userKey).child("Region").getValue(String.class);
                            String Ost = snapshot.child("directOrder").child(userKey).child("Ostate").getValue(String.class);

                            tEdat.setText(Edat);
                            tltime.setText(ltime);
                            tdtim.setText(dtim);
                            tbtim.setText(btim);
                            tAdr.setText(Adr);
                            trg.setText(rg);
                            tot.setText(Ost);


                        }else if(snapshot.child("CustomOrder").hasChild(userKey)){
                            // Toast.makeText(getActivity().getApplicationContext(), "order already exist " , Toast.LENGTH_SHORT).show();
                            String Edat = snapshot.child("CustomOrder").child(userKey).child("expDate").getValue(String.class);
                            String ltime = snapshot.child("CustomOrder").child(userKey).child("LunchTime").getValue(String.class);
                            String dtim = snapshot.child("CustomOrder").child(userKey).child("DinnerTime").getValue(String.class);
                            String btim = snapshot.child("CustomOrder").child(userKey).child("BreakfastTime").getValue(String.class);
                            String Adr = snapshot.child("CustomOrder").child(userKey).child("Address").getValue(String.class);
                            String rg = snapshot.child("CustomOrder").child(userKey).child("Region").getValue(String.class);
                            String Ost = snapshot.child("CustomOrder").child(userKey).child("Ostate").getValue(String.class);
                            tot.setText(Ost);
                            tEdat.setText(Edat);
                            tltime.setText(ltime);
                            tdtim.setText(dtim);
                            tbtim.setText(btim);
                            tAdr.setText(Adr);
                            trg.setText(rg);
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



        ClickToUp.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {

                DatabaseReference databaseReference,df1;
                FirebaseAuth firebaseAuth = FirebaseAuth.getInstance();
                FirebaseUser user = firebaseAuth.getCurrentUser();
                String userKey = user.getUid();
                databaseReference = FirebaseDatabase.getInstance().getReference("hotel");
                databaseReference.addValueEventListener(new ValueEventListener() {
                    @Override
                    public void onDataChange(@NonNull DataSnapshot snapshot) {
                        if(snapshot.child("directOrder").hasChild(userKey)){
//                            String ltime = snapshot.child("directOrder").child(userKey).child("LunchTime").getValue(String.class);
//                            String dtim = snapshot.child("directOrder").child(userKey).child("DinnerTime").getValue(String.class);
//                            String btim = snapshot.child("directOrder").child(userKey).child("BreakfastTime").getValue(String.class);
//                            String Edat = snapshot.child("directOrder").child(userKey).child("expDate").getValue(String.class);
//                            //Toast.makeText(getActivity().getApplicationContext(), "order already exist " , Toast.LENGTH_SHORT).show();
//                            //  insert(Edat);
//                            String Adr = snapshot.child("directOrder").child(userKey).child("Address").getValue(String.class);
//                            String rg = snapshot.child("directOrder").child(userKey).child("Region").getValue(String.class);
                            Intent intent = new Intent(getActivity().getApplicationContext(), UpdateAQ.class);
                            intent.putExtra("Type","directOrder");
//                            intent.putExtra("Bf",btim);
//                            intent.putExtra("Lt",ltime);
//                            intent.putExtra("Dt",dtim);
//                            intent.putExtra("Adr",Adr);

                            intent.addFlags(Intent.FLAG_ACTIVITY_SINGLE_TOP);
                            startActivity(intent);

                        }else if(snapshot.child("CustomOrder").hasChild(userKey)){

                            //  String Edat = snapshot.child("directOrder").child(userKey).child("expDate").getValue(String.class);
                            //Toast.makeText(getActivity().getApplicationContext(), "order already exist " , Toast.LENGTH_SHORT).show();
                            //  insert1(Edat);
                            Intent intent = new Intent(getActivity().getApplicationContext(), UpdateAQ.class);
                            intent.putExtra("Type","CustomOrder");
                            intent.addFlags(Intent.FLAG_ACTIVITY_SINGLE_TOP);
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


        return view;

    }
    private  void insert(String Edate){
        FirebaseAuth firebaseAuth = FirebaseAuth.getInstance();
        FirebaseUser user = firebaseAuth.getCurrentUser();
        String userKey = user.getUid();
        DatabaseReference databaseReference;
        databaseReference = FirebaseDatabase.getInstance().getReference("History");
        databaseReference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot1) {


                DatabaseReference df1;

                df1 = FirebaseDatabase.getInstance().getReference();
                df1.addValueEventListener(new ValueEventListener() {
                    @Override
                    public void onDataChange(@NonNull DataSnapshot snapshot) {
                        String getName = snapshot.child("Users").child(userKey).child("UserInfo").child("name").getValue(String.class);
                        String getAdd = snapshot.child("Users").child(userKey).child("UserInfo").child("Address").getValue(String.class);
                        String getBreakfastTime = snapshot.child("Users").child(userKey).child("UserInfo").child("BreakfastTime").getValue(String.class);
                        String getLunchTime = snapshot.child("Users").child(userKey).child("UserInfo").child("LunchTime").getValue(String.class);
                        String getDinnerTime = snapshot.child("Users").child(userKey).child("UserInfo").child("DinnerTime").getValue(String.class);
                        String getPhoneNumber = snapshot.child("Users").child(userKey).child("UserInfo").child("phoneno").getValue(String.class);
                        String getRegion = snapshot.child("Users").child(userKey).child("UserInfo").child("Region").getValue(String.class);
                        String   Food=snapshot.child("Users").child(userKey).child("UserInfo").child("Food").getValue(String.class);
                        String   Vitamin=snapshot.child("Users").child(userKey).child("UserInfo").child("Vitamins").getValue(String.class);
                        String tWeight=snapshot.child("Users").child(userKey).child("UserInfo").child("Tweight").getValue(String.class);
                        String cWeight=snapshot.child("Users").child(userKey).child("UserInfo").child("weight").getValue(String.class);

                        int x=Integer.parseInt(cWeight);
                        int y=Integer.parseInt(tWeight);
                        String Goal;

                        if(x<y){
                            Goal="WeightGain";
                        }
                        else if (y<x){
                            Goal="LossWeight";
                        }
                        else{
                            Goal="MaintainWeight";
                        }

                        String getUserkey=userKey;
                        String getCalc =  snapshot.child("Userid").child(userKey).child("UserInfo").child("targetCalorie").getValue(String.class);



                        HashMap<String,Object> save = new HashMap<>();

                        String getOstate = "resume";
                        save.put("expDate",Edate);

                        save.put("name",getName);
                        save.put("Address",getAdd);
                        save.put("BreakfastTime",getBreakfastTime);
                        save.put("LunchTime",getLunchTime);
                        save.put("DinnerTime",getDinnerTime);
                        save.put("phoneno",getPhoneNumber);
                        save.put("Region",getRegion);
                        save.put("cal",getCalc);
                        save.put("Goal",Goal);
                        save.put("Ostate",getOstate);
                        save.put("Vitamin",Vitamin);
                        save.put("Food",Food);





                        databaseReference.child(userKey).setValue(save).addOnSuccessListener(new OnSuccessListener<Void>() {
                            @Override
                            public void onSuccess(Void unused) {
                                Toast.makeText(getActivity().getApplicationContext(),"Success ",Toast.LENGTH_LONG).show();


                                DatabaseReference ref;
                                ref = FirebaseDatabase.getInstance().getReference("hotel").child("directOrder");
                                ref.child(userKey).removeValue();


                                Intent intent = new Intent(getActivity(), MainActivity.class);
                                intent.addFlags(Intent.FLAG_ACTIVITY_SINGLE_TOP);
                                startActivity(intent);

                            }
                        });
                    }





                    @Override
                    public void onCancelled(@NonNull DatabaseError error) {


                        Toast.makeText(getActivity().getApplicationContext(),"error ",Toast.LENGTH_SHORT).show();
                    }
                });
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });

    }
    private  void insert1(String Edate){
        FirebaseAuth firebaseAuth = FirebaseAuth.getInstance();
        FirebaseUser user = firebaseAuth.getCurrentUser();
        String userKey = user.getUid();
        DatabaseReference databaseReference;
        databaseReference = FirebaseDatabase.getInstance().getReference("History");
        databaseReference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot1) {


                DatabaseReference df1;

                df1 = FirebaseDatabase.getInstance().getReference();
                df1.addValueEventListener(new ValueEventListener() {
                    @Override
                    public void onDataChange(@NonNull DataSnapshot snapshot) {
                        String getName = snapshot.child("Users").child(userKey).child("UserInfo").child("name").getValue(String.class);
                        String getAdd = snapshot.child("Users").child(userKey).child("UserInfo").child("Address").getValue(String.class);
                        String getBreakfastTime = snapshot.child("Users").child(userKey).child("UserInfo").child("BreakfastTime").getValue(String.class);
                        String getLunchTime = snapshot.child("Users").child(userKey).child("UserInfo").child("LunchTime").getValue(String.class);
                        String getDinnerTime = snapshot.child("Users").child(userKey).child("UserInfo").child("DinnerTime").getValue(String.class);
                        String getPhoneNumber = snapshot.child("Users").child(userKey).child("UserInfo").child("phoneno").getValue(String.class);
                        String getRegion = snapshot.child("Users").child(userKey).child("UserInfo").child("Region").getValue(String.class);
                        String   Food=snapshot.child("Users").child(userKey).child("UserInfo").child("Food").getValue(String.class);
                        String   Vitamin=snapshot.child("Users").child(userKey).child("UserInfo").child("Vitamins").getValue(String.class);
                        String tWeight=snapshot.child("Users").child(userKey).child("UserInfo").child("Tweight").getValue(String.class);
                        String cWeight=snapshot.child("Users").child(userKey).child("UserInfo").child("weight").getValue(String.class);

                        int x=Integer.parseInt(cWeight);
                        int y=Integer.parseInt(tWeight);
                        String Goal;

                        if(x<y){
                            Goal="WeightGain";
                        }
                        else if (y<x){
                            Goal="LossWeight";
                        }
                        else{
                            Goal="MaintainWeight";
                        }

                        String getUserkey=userKey;
                        String getCalc =  snapshot.child("Userid").child(userKey).child("UserInfo").child("targetCalorie").getValue(String.class);



                        HashMap<String,Object> save = new HashMap<>();

                        String getOstate = "resume";
                        save.put("expDate",Edate);

                        save.put("name",getName);
                        save.put("Address",getAdd);
                        save.put("BreakfastTime",getBreakfastTime);
                        save.put("LunchTime",getLunchTime);
                        save.put("DinnerTime",getDinnerTime);
                        save.put("phoneno",getPhoneNumber);
                        save.put("Region",getRegion);
                        save.put("cal",getCalc);
                        save.put("Goal",Goal);
                        save.put("Ostate",getOstate);
                        save.put("Vitamin",Vitamin);
                        save.put("Food",Food);





                        databaseReference.child(userKey).setValue(save).addOnSuccessListener(new OnSuccessListener<Void>() {
                            @Override
                            public void onSuccess(Void unused) {
                                Toast.makeText(getActivity().getApplicationContext(),"Success ",Toast.LENGTH_LONG).show();


                                DatabaseReference ref;
                                ref = FirebaseDatabase.getInstance().getReference("hotel").child("CustomOrder");
                                ref.child(userKey).removeValue();


                                Intent intent = new Intent(getActivity(), MainActivity.class);
                                intent.addFlags(Intent.FLAG_ACTIVITY_SINGLE_TOP);
                                startActivity(intent);

                            }
                        });
                    }





                    @Override
                    public void onCancelled(@NonNull DatabaseError error) {


                        Toast.makeText(getActivity().getApplicationContext(),"error ",Toast.LENGTH_SHORT).show();
                    }
                });
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });

    }

//    private void insert1(String Edate){
//        FirebaseAuth firebaseAuth = FirebaseAuth.getInstance();
//        FirebaseUser user = firebaseAuth.getCurrentUser();
//        String userKey = user.getUid();
//DatabaseReference df1,databaseReference1;
//        df1 = FirebaseDatabase.getInstance().getReference("Users");
//        df1.addValueEventListener(new ValueEventListener() {
//            @Override
//            public void onDataChange(@NonNull DataSnapshot snapshot) {
//                String getName = snapshot.child(userKey).child("UserInfo").child("name").getValue(String.class);
//                String getAdd = snapshot.child(userKey).child("UserInfo").child("Address").getValue(String.class);
//                String getBreakfastTime = snapshot.child(userKey).child("UserInfo").child("BreakfastTime").getValue(String.class);
//                String getLunchTime = snapshot.child(userKey).child("UserInfo").child("LunchTime").getValue(String.class);
//                String getDinnerTime = snapshot.child(userKey).child("UserInfo").child("DinnerTime").getValue(String.class);
//                String getPhoneNumber = snapshot.child(userKey).child("UserInfo").child("phoneno").getValue(String.class);
//                String getRegion = snapshot.child(userKey).child("UserInfo").child("Region").getValue(String.class);
//                String getUserkey=userKey;
//                String getCalc =  snapshot.child("Userid").child(userKey).child("UserInfo").child("targetCalorie").getValue(String.class);
//                databaseReference1 = FirebaseDatabase.getInstance().getReference("hotel").child("CustomOrder").child(userKey);
//                databaseReference1.addValueEventListener(new ValueEventListener() {
//                    @Override
//                    public void onDataChange(@NonNull DataSnapshot snapshot) {
//
//                        HashMap<String,Object> save = new HashMap<>();
//
//                        String getOstate = "resume";
//                        save.put("expDate",getEdate);
//                        save.put("UserKey",getUserkey);
//                        save.put("name",getName);
//                        save.put("Address",getAdd);
//                        save.put("BreakfastTime",getBreakfastTime);
//                        save.put("LunchTime",getLunchTime);
//                        save.put("DinnerTime",getDinnerTime);
//                        save.put("phoneno",getPhoneNumber);
//                        save.put("Region",getRegion);
//                        save.put("cal",getCalc);
//                        save.put("Ostate",getOstate);
//
//
//                        databaseReference.setValue(save).addOnSuccessListener(new OnSuccessListener<Void>() {
//                            @Override
//                            public void onSuccess(Void unused) {
//                                Toast.makeText(Pay2.this,"Success ",Toast.LENGTH_LONG).show();
//                                Intent i=new Intent(Pay2.this,MainActivity.class);
//                                startActivity(i);
//
//                            }
//                        });
//                    }
//
//                    @Override
//                    public void onCancelled(@NonNull DatabaseError error) {
//                        Toast.makeText(Pay2.this,"error ",Toast.LENGTH_SHORT).show();
//                    }
//                });
//            }
//
//            @Override
//            public void onCancelled(@NonNull DatabaseError error) {
//
//            }
//        });
//
//
//
//    }
}