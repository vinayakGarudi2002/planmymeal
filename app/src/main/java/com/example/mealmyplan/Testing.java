package com.example.mealmyplan;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Objects;

public class Testing extends AppCompatActivity implements AdapterView.OnItemSelectedListener {
    String Vitamin, Gender, Activity, item,Region,Food;
    EditText etAge, etHeight, etName, etPhoneno, etSurname,etAddress, etWeight, etTargetWeight;
    Button BtnDone;
    private DatabaseReference databaseReference;
    int cals=0, prot=0, carb=0, fat=0, X, Y;
    private String mUserId;
    TextView text;
    FirebaseUser user;
    FirebaseAuth auth;
    String etBreak,etLunch,etDinner;
    Spinner spinner6,spinner7,spinner8;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_testing);

        List<String> list6 = new ArrayList<String>();
        list6.add("7AM");
        list6.add("8AM");
        list6.add("9AM");
        list6.add("10AM");

        spinner6 = (Spinner)findViewById(R.id.spinnerbU);
        ArrayAdapter<String> arrayAdapter6 = new ArrayAdapter<String>(Testing.this, android.R.layout.simple_spinner_item, list6);
        arrayAdapter6.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner6.setAdapter(arrayAdapter6);
        spinner6.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

                spinner6.setSelection(position);
                etBreak = parent.getItemAtPosition(position).toString();

               // Toast.makeText(parent.getContext(), "Selected: " + item, Toast.LENGTH_LONG).show();




            }
            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
        List<String> list8 = new ArrayList<String>();
        list8.add("7PM");
        list8.add("8PM");
        list8.add("9PM");
        list8.add("10PM");

        spinner8 = (Spinner)findViewById(R.id.spinnerdU);
        ArrayAdapter<String> arrayAdapter8 = new ArrayAdapter<String>(Testing.this, android.R.layout.simple_spinner_item, list8);
        arrayAdapter8.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner8.setAdapter(arrayAdapter8);
        spinner8.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

                spinner8.setSelection(position);
                etDinner = parent.getItemAtPosition(position).toString();

              //  Toast.makeText(parent.getContext(), "Selected: " + item, Toast.LENGTH_LONG).show();




            }
            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
        List<String> list7 = new ArrayList<String>();
        list7.add("1PM");
        list7.add("2PM");
        list7.add("3PM");
        spinner7 = (Spinner)findViewById(R.id.spinnerlU);
        ArrayAdapter<String> arrayAdapter7 = new ArrayAdapter<String>(Testing.this, android.R.layout.simple_spinner_item, list7);
        arrayAdapter7.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner7.setAdapter(arrayAdapter7);
        spinner7.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

                spinner7.setSelection(position);
                etLunch = parent.getItemAtPosition(position).toString();

               // Toast.makeText(parent.getContext(), "Selected: " + item, Toast.LENGTH_LONG).show();




            }
            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });


        final Spinner spinner = (Spinner) findViewById(R.id.spinnerU); // check
        spinner.setOnItemSelectedListener((AdapterView.OnItemSelectedListener) this);
        final Spinner spinner1 = (Spinner) findViewById(R.id.spinner1U); // check
        spinner1.setOnItemSelectedListener((AdapterView.OnItemSelectedListener) this);
        final Spinner spinner2 = (Spinner) findViewById(R.id.spinner2U); // check
        spinner2.setOnItemSelectedListener((AdapterView.OnItemSelectedListener) this);
        final Spinner spinner3 = (Spinner) findViewById(R.id.spinner3U); // check
        spinner3.setOnItemSelectedListener((AdapterView.OnItemSelectedListener) this);
        final Spinner spinner4 = (Spinner) findViewById(R.id.spinner4U); // check
        spinner4.setOnItemSelectedListener((AdapterView.OnItemSelectedListener) this);

        BtnDone = findViewById(R.id.buttonOKU);
        FirebaseDatabase firebaseDatabase = FirebaseDatabase.getInstance();
        databaseReference = firebaseDatabase.getReference();

        etName = findViewById(R.id.EditTextNameU);

        etAge = findViewById(R.id.UserAgeU);


        etAddress=findViewById(R.id.editTextTextPersonName3U);



        EditText etHeight = findViewById(R.id.userHeightU);

        EditText etWeight = (EditText) findViewById(R.id.editTextWeightU);
        EditText etTargetWeight = (EditText) findViewById(R.id.editTextWeightTargetU);

        etPhoneno = findViewById(R.id.EditTextPhoneNoU);
        List<String> list = new ArrayList<String>();
        list.add("A");
        list.add("B");
        list.add("C");
        list.add("D");
        list.add("E");
        list.add("K");
        list.add("NotSure");


        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(Testing
                .this, android.R.layout.simple_spinner_item,
                list);
        arrayAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(arrayAdapter);
        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

                spinner.setSelection(position);
                String item = parent.getItemAtPosition(position).toString();

               // Toast.makeText(parent.getContext(), "Selected: " + item, Toast.LENGTH_LONG).show();
                Vitamin = item;
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
        List<String> list1 = new ArrayList<String>();
        list1.add("Male");
        list1.add("Female");

        ArrayAdapter<String> arrayAdapter1 = new ArrayAdapter<String>(Testing.this,
                android.R.layout.simple_spinner_item, list1);
        arrayAdapter1.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner1.setAdapter(arrayAdapter1);
        spinner1.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

                spinner1.setSelection(position);
                String item1 = parent.getItemAtPosition(position).toString();

                Toast.makeText(parent.getContext(), "Selected: " + item1, Toast.LENGTH_LONG).show();
                Gender = item1;
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
        List<String> list2 = new ArrayList<String>();
        list2.add("Very");
        list2.add("Light");
        list2.add("Moderate");

        ArrayAdapter<String> arrayAdapter2 = new ArrayAdapter<String>(Testing.this, android.R.layout.simple_spinner_item, list2);
        arrayAdapter2.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner2.setAdapter(arrayAdapter2);
        spinner2.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

                spinner2.setSelection(position);
                item = parent.getItemAtPosition(position).toString();

               // Toast.makeText(parent.getContext(), "Selected: " + item, Toast.LENGTH_LONG).show();
                Activity = item;

            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
        List<String> list3 = new ArrayList<String>();
        list3.add("Goregoan");
        list3.add("Kandivali");
        list3.add("Malad");
        list3.add("Borivali");

        ArrayAdapter<String> arrayAdapter3 = new ArrayAdapter<String>(Testing.this, android.R.layout.simple_spinner_item, list3);
        arrayAdapter3.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner3.setAdapter(arrayAdapter3);
        spinner3.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

                spinner3.setSelection(position);
                item = parent.getItemAtPosition(position).toString();

               // Toast.makeText(parent.getContext(), "Selected: " + item, Toast.LENGTH_LONG).show();
                Region = item;

            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
        List<String> list4 = new ArrayList<String>();
        list4.add("Veg");
        list4.add("NonVeg");


        ArrayAdapter<String> arrayAdapter4 = new ArrayAdapter<String>(Testing.this, android.R.layout.simple_spinner_item, list4);
        arrayAdapter4.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner4.setAdapter(arrayAdapter4);
        spinner4.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

                spinner4.setSelection(position);
                item = parent.getItemAtPosition(position).toString();

                //Toast.makeText(parent.getContext(), "Selected: " + item, Toast.LENGTH_LONG).show();
                Food = item;

            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        BtnDone.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String Height = etHeight.getText().toString();
                String Tweight = etTargetWeight.getText().toString();
                String Weight = etWeight.getText().toString();
                String Breakfast = etBreak;
                String Lunch = etLunch;
                String Dinner = etDinner;
                String Address = etAddress.getText().toString();
                String Phonenumber = etPhoneno.getText().toString();
                String Name = etName.getText().toString();
                String Age = etAge.getText().toString();
                auth = FirebaseAuth.getInstance();

                if (TextUtils.isEmpty(Height)) {
                    Toast.makeText(getApplicationContext(), "Enter your Height", Toast.LENGTH_SHORT).show();
                    return;
                }
                if (TextUtils.isEmpty(Tweight)) {
                    Toast.makeText(getApplicationContext(), "Enter your TargetWeight", Toast.LENGTH_SHORT).show();
                    return;
                }if (TextUtils.isEmpty(Weight)) {
                    Toast.makeText(getApplicationContext(), "Enter your Weight", Toast.LENGTH_SHORT).show();
                    return;
                }if (TextUtils.isEmpty(Address)) {
                    Toast.makeText(getApplicationContext(), "Enter your Address", Toast.LENGTH_SHORT).show();
                    return;
                }if (TextUtils.isEmpty(Phonenumber)) {
                    Toast.makeText(getApplicationContext(), "Enter your PhoneNumber", Toast.LENGTH_SHORT).show();
                    return;
                }if (TextUtils.isEmpty(Name)) {
                    Toast.makeText(getApplicationContext(), "Enter your Name", Toast.LENGTH_SHORT).show();
                    return;
                }if (TextUtils.isEmpty(Age)) {
                    Toast.makeText(getApplicationContext(), "Enter your Age", Toast.LENGTH_SHORT).show();
                    return;
                }
                if ((Phonenumber.length() !=  10)) {
                    Toast.makeText(getApplicationContext(), "PhoneNumber must 10 digit", Toast.LENGTH_LONG).show();
                }
                if ((Height.length() !=  3)) {
                    Toast.makeText(getApplicationContext(), "PhoneNumber must 10 digit", Toast.LENGTH_LONG).show();
                }
                if ((Weight.length() !=  2)) {
                    Toast.makeText(getApplicationContext(), "PhoneNumber must 10 digit", Toast.LENGTH_LONG).show();
                }
                if (Tweight.length() !=  2) {
                    Toast.makeText(getApplicationContext(), "PhoneNumber must 10 digit", Toast.LENGTH_LONG).show();
                }
                if (Age.length() !=  2) {
                    Toast.makeText(getApplicationContext(), "PhoneNumber must 10 digit", Toast.LENGTH_LONG).show();
                }



                String cWeight = ((EditText) (findViewById(R.id.editTextWeightU))).getText().toString();
                String tWeight = ((EditText) (findViewById(R.id.editTextWeightTargetU))).getText().toString();
                String q = Activity;

                X = Integer.parseInt(cWeight);
                Y = Integer.parseInt(tWeight);

                int a = Integer.parseInt(etWeight.getText().toString());

                int b = Integer.parseInt(etHeight.getText().toString());
                int s = Integer.parseInt(etAge.getText().toString());

                if (X > Y) {

                    String str = Gender;
                    switch (str) {
                        case "Male": {
                            cals = userFemale(a, b, s, q);
                            cals = cals + (int) (cals * 0.20);
                            prot = (int) (cals * (0.1981));
                            carb = (int) (cals * (0.5516));
                            fat = (int) (cals * (0.25));

                            Insert(cals, prot, carb, fat);
                        }
                        // System.out.println("The sum of a and b is= " + cals + " " + prot + " " + carb
                        // + " " + fat);

                        break;
                        case "Female": {
                            cals = userFemale(a, b, s, q);
                            cals = cals + (int) (cals * 0.20);
                            prot = (int) (cals * (0.1981));
                            carb = (int) (cals * (0.5516));
                            fat = (int) (cals * (0.25));

                            Insert(cals, prot, carb, fat);
                            // System.out.println("The sum of a and b is= " + cals);
                            break;
                        }

                    }

                }

                if (X == Y) {

                    String str = Gender;
                    switch (str) {
                        case "Male": {
                            cals = userFemale(a, b, s, q);

                            prot = (int) (cals * (0.1981));
                            carb = (int) (cals * (0.5516));
                            fat = (int) (cals * (0.25));

                            Insert(cals, prot, carb, fat);
                        }
                        break;
                        case "Female": {
                            cals=0;
                            prot=0;
                            carb=0;
                            fat=0;
                            cals = userFemale(a, b, s, q);

                            prot = (int) (cals * (0.1981));
                            carb = (int) (cals * (0.5516));
                            fat = (int) (cals * (0.25));

                            Insert(cals, prot, carb, fat);
                            // System.out.println("The sum of a and b is= " + cals);

                            break;
                        }

                    }

                }

                if (X < Y) {

                    String str = Gender;
                    switch (str) {
                        case "Male": {
                            cals = userFemale(a, b, s, q);
                            cals = cals - (int) (cals * 0.20);
                            prot = (int) (cals * (0.1981));
                            carb = (int) (cals * (0.5516));
                            fat = (int) (cals * (0.25));

                            Insert(cals, prot, carb, fat);
                        }
                        // System.out.println("The sum of a and b is= " + cals + " " + prot + " " + carb
                        // + " " + fat);
                        break;
                        case "Female": {
                            cals = userFemale(a, b, s, q);
                            cals = cals - (int) (cals * 0.20);
                            prot = (int) (cals * (0.1981));
                            carb = (int) (cals * (0.5516));
                            fat = (int) (cals * (0.25));

                            Insert(cals, prot, carb, fat);
                            // System.out.println("The sum of a and b is= " + cals);
                            break;
                        }

                    }

                }

                String getAge = etAge.getText().toString();
                String getGender = Gender;
                String getWeight = etWeight.getText().toString();
                String getHeight = etHeight.getText().toString();
                String getVitamin = Vitamin;
                String getRegion = Region;
                String getFood=Food;
                String getName = etName.getText().toString();
                String getLunch=etLunch;
                String getDinner=etDinner;
                String getTargetWeight = tWeight;
                String getBreak = etBreak;
                String getAdd=etAddress.getText().toString();
                String getPhoneno = etPhoneno.getText().toString();

                HashMap<String, Object> hashmap = new HashMap<>();
                hashmap.put("name", getName);
                hashmap.put("BreakfastTime", getBreak);
                hashmap.put("LunchTime",getLunch);
                hashmap.put("DinnerTime",getDinner);
                hashmap.put("Address",getAdd);
                hashmap.put("age", getAge);
                hashmap.put("Region",getRegion);
                hashmap.put("Food",getFood);

                hashmap.put("phoneno", getPhoneno);
                hashmap.put("Vitamins", getVitamin);

                hashmap.put("Tweight", getTargetWeight);
                hashmap.put("gender", getGender);
                hashmap.put("weight", getWeight);
                hashmap.put("height", getHeight);
                user = FirebaseAuth.getInstance().getCurrentUser();

                databaseReference.child("Users").child(Objects.requireNonNull(user).getUid().toString())
                        .child("UserInfo").setValue(hashmap).addOnSuccessListener(new OnSuccessListener<Void>() {
                    @Override
                    public void onSuccess(@NonNull Void unused) {
                        Toast.makeText(Testing.this, "Sucess", Toast.LENGTH_LONG).show();

                        Intent i = new Intent(Testing.this, MainActivity.class);

                        startActivity(i);

                    }
                }).addOnFailureListener(new OnFailureListener() {
                    @Override
                    public void onFailure(@NonNull Exception e) {

                        Toast.makeText(Testing.this, "Error critical", Toast.LENGTH_LONG).show();
                        Intent i = new Intent(Testing.this, MainActivity.class);
                        startActivity(i);

                    }
                });

            }

        });

    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

        String item = parent.getItemAtPosition(position).toString();

        Toast.makeText(parent.getContext(), "Selected: " + item, Toast.LENGTH_LONG).show();

        String getItem = item;
        HashMap<String, Object> hashmap = new HashMap<>();

        hashmap.put("Vitamin", getItem);

        user = FirebaseAuth.getInstance().getCurrentUser();
        databaseReference.child("Users").child(Objects.requireNonNull(user).getUid().toString()).child("UserInfo")
                .setValue(hashmap).addOnSuccessListener(new OnSuccessListener<Void>() {
            @Override
            public void onSuccess(@NonNull Void unused) {

            }
        }).addOnFailureListener(new OnFailureListener() {
            @Override
            public void onFailure(@NonNull Exception e) {

                Toast.makeText(Testing.this, "Error critical", Toast.LENGTH_LONG).show();

            }
        });

    }

    //

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }

    public void Insert(int cals, int prot, int carb, int fat) {

        FirebaseUser user;
        DatabaseReference databaseReference;
        String getCalorie = Integer.toString(cals);
        String getProtein = Integer.toString(prot);
        String getCarbs = Integer.toString(carb);
        String getTargetFat = Integer.toString(fat);

        HashMap<String, Object> hashmap = new HashMap<>();

        hashmap.put("targetCalorie", getCalorie);
        hashmap.put("targetProtein", getProtein);
        hashmap.put("targetCarbs", getCarbs);
        hashmap.put("targetFat", getTargetFat);

        user = FirebaseAuth.getInstance().getCurrentUser();
        FirebaseDatabase firebaseDatabase = FirebaseDatabase.getInstance();
        databaseReference = firebaseDatabase.getReference();


        databaseReference.child("Userid").child(Objects.requireNonNull(user).getUid().toString()).child("UserInfo")
                .setValue(hashmap).addOnSuccessListener(new OnSuccessListener<Void>() {
            @Override
            public void onSuccess(@NonNull Void unused) {
                // Toast.makeText(Testing.this, "Sucess", Toast.LENGTH_LONG).show();
                ;
            }
        }).addOnFailureListener(new OnFailureListener() {
            @Override
            public void onFailure(@NonNull Exception e) {

                Toast.makeText(Testing.this, "Error critical", Toast.LENGTH_LONG).show();

            }
        });

    }

    public static int userFemale(float w, float h, float a, String physicalActive) // n1 and n2 are formal parameters
    {
        float ree;
        float tee = 0;
        int cals;

        ree = (float) ((10 * w) + (6.25 * h) - (5 * a) - 161);

        String str = physicalActive;
        switch (str) {
            case "Light":
                tee = (float) (ree * 1.375);
                break;
            case "Moderate":
                tee = (float) (ree * 1.55);
                break;
            case "Very":
                tee = (float) (ree * 1.725);
                break;

        }

        cals = (int) (ree + tee);
        return cals; // returning the sum
    }

    public static int userMale(float w, float h, float a, String physicalActive) // n1 and n2 are formal parameters
    {
        float ree;
        float tee = 0;
        int cals;

        ree = (float) ((10 * w) + (6.25 * h) - (5 * a) + 5);

        String str = physicalActive;
        switch (str) {
            case "Light":
                tee = (float) (ree * 1.375);
                break;
            case "Moderate":
                tee = (float) (ree * 1.55);
                break;
            case "Very":
                tee = (float) (ree * 1.725);
                break;

        }

        cals = (int) (ree + tee);
        return cals; // returning the sum
    }

}