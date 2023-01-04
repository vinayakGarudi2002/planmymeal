package com.example.mealmyplan;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

import java.util.Objects;

public class Signup extends AppCompatActivity {

    EditText SignUpMail,SignUpPass;
    Button SignUpButton,LoginButton;
    private FirebaseAuth auth;
    FirebaseUser user;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);                                    //check

        auth = FirebaseAuth.getInstance();

//        if (auth.getCurrentUser() != null) {
//            Intent intent = new Intent(SignUp.this, SignUpInfo.class);         //         vvvvvv
//            startActivity(intent);
//            finish();
//        }


        SignUpMail = findViewById(R.id.Smail);
        SignUpPass = findViewById(R.id.Spass);
        auth = FirebaseAuth.getInstance();
        SignUpButton = (Button) findViewById(R.id.SignUpButton);
        LoginButton = (Button) findViewById(R.id.LButton);
        SignUpButton.setOnClickListener(v -> {
            String email = SignUpMail.getText().toString();
            String pass = SignUpPass.getText().toString();

            if (TextUtils.isEmpty(email)) {
                Toast.makeText(getApplicationContext(), "Please enter your E-mail address", Toast.LENGTH_LONG).show();
                return;
            }
            if (TextUtils.isEmpty(pass)) {
                Toast.makeText(getApplicationContext(), "Please enter your Password", Toast.LENGTH_LONG).show();
            }
            if (pass.length() == 0) {
                Toast.makeText(getApplicationContext(), "Please enter your Password", Toast.LENGTH_LONG).show();
            }
            if (pass.length() < 8) {
                Toast.makeText(getApplicationContext(), "Password must be more than 8 digit", Toast.LENGTH_LONG).show();
            } else {
                auth.createUserWithEmailAndPassword(email, pass)
                        .addOnCompleteListener(Signup.this, new OnCompleteListener<AuthResult>() {
                            public void onComplete(@NonNull Task<AuthResult> task) {

                                if (!task.isSuccessful()) {
                                    Toast.makeText(Signup.this, "ERROR", Toast.LENGTH_LONG).show();
                                } else {
                                    startActivity(new Intent(Signup.this, Testing.class));       //  vvvvvvv
                                    finish();
                                }
                            }
                        });
            }
        });


        LoginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String email = SignUpMail.getText().toString();
                 String password = SignUpPass.getText().toString();

                auth = FirebaseAuth.getInstance();

                if (TextUtils.isEmpty(email)) {
                    Toast.makeText(getApplicationContext(), "Enter your mail address", Toast.LENGTH_SHORT).show();
                    return;
                }
                if (TextUtils.isEmpty(password)) {
                    Toast.makeText(getApplicationContext(), "Enter your password", Toast.LENGTH_SHORT).show();
                    return;
                }

                //authenticate user
                auth.signInWithEmailAndPassword(email, password)
                        .addOnCompleteListener(Signup.this, new OnCompleteListener<AuthResult>() {
                            @Override
                            public void onComplete(@NonNull Task<AuthResult> task) {
                                if (!task.isSuccessful()) {
                                    // there was an error
                                    if (password.length() < 8) {
                                        Toast.makeText(getApplicationContext(),"Password must be more than 8 digit",Toast.LENGTH_SHORT).show();
                                    } else {
                                        Toast.makeText(getApplicationContext(),"Error",Toast.LENGTH_SHORT).show();
                                    }
                                } else {
                                    user = FirebaseAuth.getInstance().getCurrentUser();
                                    String mUserId = Objects.requireNonNull(user).getUid();
                                    //  String str = 123456abcd@;
                                    Toast.makeText(getApplicationContext(),mUserId,Toast.LENGTH_SHORT).show();


//                                private Firebase firebaseRef;
//                                Firebase.setAndroidContext(this);
//                                 user = firebaseRef.getAuth().getUid().toString();
                                    Intent intent = new Intent(Signup.this, MainActivity.class);
                                    startActivity(intent);
                                    finish();
                                }

                            }
                        });

            }
        });
    }

}