package com.ltrsoft.policeapp;
import static java.lang.Thread.sleep;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkCapabilities;
import android.net.NetworkInfo;
import android.os.Build;
import android.util.Log;
public class Splash_Screen extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_screen);


        Thread t = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    sleep(4000);


                    Intent main_activity_intent = new Intent(Splash_Screen.this, MainActivity.class);
                    startActivity(main_activity_intent);
                    finish();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });
        t.start();
    }



}
