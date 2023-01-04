//package com.example.mealmyplan;
//
//import androidx.annotation.NonNull;
//import androidx.appcompat.app.AppCompatActivity;
//
//import android.content.Intent;
//import android.os.Bundle;
//import android.view.View;
//import android.widget.AdapterView;
//import android.widget.ArrayAdapter;
//import android.widget.Button;
//import android.widget.EditText;
//import android.widget.Spinner;
//import android.widget.Toast;
//
//import com.google.android.gms.tasks.OnSuccessListener;
//import com.google.firebase.auth.FirebaseAuth;
//import com.google.firebase.auth.FirebaseUser;
//import com.google.firebase.database.DataSnapshot;
//import com.google.firebase.database.DatabaseError;
//import com.google.firebase.database.DatabaseReference;
//import com.google.firebase.database.FirebaseDatabase;
//import com.google.firebase.database.ValueEventListener;
//
//import java.util.ArrayList;
//import java.util.HashMap;
//import java.util.List;
//
//public class UpdateA extends AppCompatActivity {
//
//    @Override
//    protected void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_update);
//        EditText ta,tb,tl,td,tr,to,tp;
//        Spinner spinner6,spinner7,spinner8;
//        Button btn;
//        String etBreak,etLunch,etDinner;
////        ta = findViewById(R.id.ta);
////        tb = findViewById(R.id.tb);
//        tl = findViewById(R.id.tl);
////        td = findViewById(R.id.td);
////        tr = findViewById(R.id.tr);
////
////        tp = findViewById(R.id.tp);
//        btn = findViewById(R.id.up);
//        List<String> list6 = new ArrayList<String>();
//        list6.add("7AM");
//        list6.add("8AM");
//        list6.add("9AM");
//        list6.add("10AM");
//
//        spinner6 = (Spinner)findViewById(R.id.spinner6);
//        ArrayAdapter<String> arrayAdapter6 = new ArrayAdapter<String>(UpdateA.this, android.R.layout.simple_spinner_item, list6);
//        arrayAdapter6.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
//        spinner6.setAdapter(arrayAdapter6);
//        spinner6.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
//            @Override
//            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
//
//                spinner6.setSelection(position);
//         etBreak = parent.getItemAtPosition(position).toString();
//
//              //  Toast.makeText(parent.getContext(), "Selected: " + item, Toast.LENGTH_LONG).show();
//
//
//
//
//            }
//            @Override
//            public void onNothingSelected(AdapterView<?> parent) {
//
//            }
//        });
//        List<String> list8 = new ArrayList<String>();
//        list8.add("7PM");
//        list8.add("8PM");
//        list8.add("9PM");
//        list8.add("10PM");
//
//        spinner8 = (Spinner)findViewById(R.id.spinner8);
//        ArrayAdapter<String> arrayAdapter8 = new ArrayAdapter<String>(Testing.this, android.R.layout.simple_spinner_item, list8);
//        arrayAdapter8.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
//        spinner8.setAdapter(arrayAdapter8);
//        spinner8.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
//            @Override
//            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
//
//                spinner8.setSelection(position);
//             String   etDinner = parent.getItemAtPosition(position).toString();
//                Dinner = etDinner;
//
//                Toast.makeText(parent.getContext(), "Selected: " + item, Toast.LENGTH_LONG).show();
//
//
//
//
//            }
//            @Override
//            public void onNothingSelected(AdapterView<?> parent) {
//
//            }
//        });
//        List<String> list7 = new ArrayList<String>();
//        list7.add("1PM");
//        list7.add("2PM");
//        list7.add("3PM");
//        spinner7 = (Spinner)findViewById(R.id.spinner7);
//        ArrayAdapter<String> arrayAdapter7 = new ArrayAdapter<String>(Testing.this, android.R.layout.simple_spinner_item, list7);
//        arrayAdapter7.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
//        spinner7.setAdapter(arrayAdapter7);
//        spinner7.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
//            @Override
//            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
//
//                spinner7.setSelection(position);
//               String etLunch = parent.getItemAtPosition(position).toString();
//
//                Toast.makeText(parent.getContext(), "Selected: " + item, Toast.LENGTH_LONG).show();
//
//           Lunch = etLunch;
//
//
//            }
//            @Override
//            public void onNothingSelected(AdapterView<?> parent) {
//
//            }
//        });
//
//
//
//        btn.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//
//            }
//        });
//
//    }
//
//    private void pus(String lt){
//        DatabaseReference databaseReference;
//        FirebaseAuth firebaseAuth = FirebaseAuth.getInstance();
//        FirebaseUser user = firebaseAuth.getCurrentUser();
//        String userKey = user.getUid();
//        databaseReference = FirebaseDatabase.getInstance().getReference("hotel");
//        databaseReference.addValueEventListener(new ValueEventListener() {
//            @Override
//            public void onDataChange(@NonNull DataSnapshot snapshot) {
//                if(snapshot.child("directOrder").hasChild(userKey)){
//                    //Toast.makeText(getActivity().getApplicationContext(), "order already exist " , Toast.LENGTH_SHORT).show();
//
//                    databaseReference.child("directOrder").child(userKey).child("LunchTime").setValue(lt);
//
//
//                }else if(snapshot.child("CustomOrder").hasChild(userKey)){
//                    // Toast.makeText(getActivity().getApplicationContext(), "order already exist " , Toast.LENGTH_SHORT).show();
//                    String getEdate = snapshot.child("CustomOrder").child(userKey).child("expDate").getValue(String.class);
//                    String getName = snapshot.child("CustomOrder").child(userKey).child("name").getValue(String.class);
//                    String getUserkey = snapshot.child("CustomOrder").child(userKey).child("UserKey").getValue(String.class);
//                    String getCalc = snapshot.child("CustomOrder").child(userKey).child("cal").getValue(String.class);
//                    String Food = snapshot.child("CustomOrder").child(userKey).child("Food").getValue(String.class);
////                    String Goal = snapshot.child("CustomOrder").child(userKey).child("Goal").getValue(String.class);
////
////                    String Vitamin = snapshot.child("CustomOrder").child(userKey).child("Vitamin").getValue(String.class);
//
//                    String getLunchTime = Lunch;
//                    String getDinnerTime = snapshot.child("CustomOrder").child(userKey).child("DinnerTime").getValue(String.class);
//                    String getBreakfastTime = etBreak;
//                    String getAdd = snapshot.child("CustomOrder").child(userKey).child("Address").getValue(String.class);
//                    String getRegion = snapshot.child("CustomOrder").child(userKey).child("Region").getValue(String.class);
//                    String getPhoneNumber = snapshot.child("CustomOrder").child(userKey).child("phoneno").getValue(String.class);
//
//                    DatabaseReference databaseReference;
//                    databaseReference = FirebaseDatabase.getInstance().getReference("hotel").child("CustomOrder").child(userKey);
//                    databaseReference.addValueEventListener(new ValueEventListener() {
//                        @Override
//                        public void onDataChange(@NonNull DataSnapshot snapshot) {
//
//                            HashMap<String,Object> save = new HashMap<>();
//
//                            String getOstate = "resume";
//                            save.put("expDate",getEdate);
//                            save.put("UserKey",getUserkey);
//                            save.put("name",getName);
//                            save.put("Address",getAdd);
//                            save.put("BreakfastTime",getBreakfastTime);
//                            save.put("LunchTime",getLunchTime);
//                            save.put("DinnerTime",getDinnerTime);
//                            save.put("phoneno",getPhoneNumber);
//                            save.put("Region",getRegion);
//                            save.put("cal",getCalc);
//                            save.put("Ostate",getOstate);
//
//
//                            databaseReference.setValue(save).addOnSuccessListener(new OnSuccessListener<Void>() {
//                                @Override
//                                public void onSuccess(Void unused) {
//                                    Toast.makeText(UpdateA.this,"Success ",Toast.LENGTH_LONG).show();
//                                    Intent i=new Intent(UpdateA.this,MainActivity.class);
//                                    startActivity(i);
//
//                                }
//                            });
//                        }
//
//                        @Override
//                        public void onCancelled(@NonNull DatabaseError error) {
//                            Toast.makeText(UpdateA.this,"error ",Toast.LENGTH_SHORT).show();
//                        }
//                    });
//
//
//
//
//
//
//                }else{
//                    Toast.makeText(getApplicationContext(), "order Not exist " , Toast.LENGTH_SHORT).show();
//                }
//            }
//
//            @Override
//            public void onCancelled(@NonNull DatabaseError error) {
//
//            }
//        });
//    }
//
//
//}