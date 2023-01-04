package com.example.mealmyplan;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;

import java.util.Objects;

public class SplashActivity<SlashActivity> extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
        Objects.requireNonNull(getSupportActionBar()).hide();

        Thread thread=new Thread(){
            public void run(){

                try {
                    sleep(4000);

                }
                catch(Exception e){
                    e.printStackTrace();
                }
                finally {
                    Intent i = new Intent(SplashActivity.this,ChooseOne.class);
                    startActivity(i);
                    finish();
                }
            }

        }; thread.start();
    }
}