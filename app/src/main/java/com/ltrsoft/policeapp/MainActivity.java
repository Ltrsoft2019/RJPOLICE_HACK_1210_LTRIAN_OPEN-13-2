package com.ltrsoft.policeapp;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import com.ltrsoft.policeapp.LoinRegistration.LoginFragment;
import com.ltrsoft.policeapp.Navigation.NavigationFragment;
public class MainActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        SharedPreferences pref = getSharedPreferences("login", MODE_PRIVATE);
        SharedPreferences.Editor editor = pref.edit();
        if (pref.getBoolean("flag",false)){
            getSupportFragmentManager().beginTransaction()
                    .replace(R.id.main_container, new NavigationFragment())
                    .commit();
        }
        else {
            getSupportFragmentManager().beginTransaction()
                    .replace(R.id.main_container, new LoginFragment())
                    .commit();
        }

    }
}