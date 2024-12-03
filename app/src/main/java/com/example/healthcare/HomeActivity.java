package com.example.healthcare;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;

public class HomeActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        SharedPreferences sharedPreferences=getSharedPreferences("shared_prefs", Context.MODE_PRIVATE);
        sharedPreferences.getString("username", "");
        //Toast.makeText(getApplicationContext(), "WELCOME!!", Toast.LENGTH_SHORT).show();

        CardView exit=findViewById(R.id.cardExit);
        exit.setOnClickListener(view -> {
            SharedPreferences.Editor editor=sharedPreferences.edit();
            editor.clear();
            editor.apply();
            startActivity(new Intent(HomeActivity.this,LoginActivity.class));
        });
        CardView findDoctor=findViewById(R.id.cardFindDoctor);
        findDoctor.setOnClickListener(view -> startActivity(new Intent(HomeActivity.this,FindDoctorActivity.class)));
        CardView labTest=findViewById(R.id.cardLabTest);
        labTest.setOnClickListener(view -> startActivity(new Intent(HomeActivity.this,LabTestActivity.class)));
    }
}