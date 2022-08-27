package com.example.myapplication;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;

import com.example.myapplication.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {
    @NonNull
    ActivityMainBinding binding;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        getSupportActionBar().hide();

        binding.ExerciseId.setOnClickListener(view -> {

        Intent intent = new Intent(this,AllExercises.class);
        startActivity(intent);

        });

        binding.FoodId.setOnClickListener(view -> {

            Intent intent = new Intent(this,Food_page.class);
            startActivity(intent);

        });

        binding.BmiId.setOnClickListener(view -> {

            Intent intent = new Intent(this,BMI_Page.class);
            startActivity(intent);

        });

        binding.InfoId.setOnClickListener(view -> {

//        Toast.makeText(MainActivity.this , "App That Help You To Gain Muscles", Toast.LENGTH_LONG).show();
            Intent intent = new Intent(this,Info_page.class);
            startActivity(intent);

        });




    }}

