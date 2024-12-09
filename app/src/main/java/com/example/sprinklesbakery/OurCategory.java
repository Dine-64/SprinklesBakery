package com.example.sprinklesbakery;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class OurCategory extends AppCompatActivity {

    Button ClassicCupCake, AnniversaryCupCake, ValentineCupCake, BirthdayCupCake, ThemedCupCake, GraduationCupCake;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_our_category);

        ClassicCupCake = findViewById(R.id.btnClassicCupCake);
        AnniversaryCupCake = findViewById(R.id.btnAnniversaryCupCake);
        ValentineCupCake = findViewById(R.id.btnValentineCupcake);
        BirthdayCupCake = findViewById(R.id.btnbirthdayCake);
        ThemedCupCake = findViewById(R.id.btnThemedCupcake);
        GraduationCupCake = findViewById(R.id.btnGraduationCupcake);

        ClassicCupCake.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getApplicationContext(), ClassicCupCakePage.class);
                startActivity(i);
            }
        });

        AnniversaryCupCake.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getApplicationContext(), AnniversaryCupCakePage.class);
                startActivity(i);
            }
        });

        ValentineCupCake.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getApplicationContext(), ValentineCupCakePage.class);
                startActivity(i);
            }
        });

        BirthdayCupCake.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getApplicationContext(), BirthdayCupCakePage.class);
                startActivity(i);
            }
        });

        ThemedCupCake.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getApplicationContext(), ThemedCupCakePage.class);
                startActivity(i);
            }
        });

        GraduationCupCake.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getApplicationContext(), GradutionCupCake.class);
                startActivity(i);
            }
        });
    }
}
