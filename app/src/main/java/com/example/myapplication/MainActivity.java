package com.example.myapplication;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;

import android.content.Intent;
import android.os.Bundle;

import android.widget.Toast;

import com.example.myapplication.DBHelper;
import com.example.myapplication.R;
import com.example.myapplication.Utils.ExViewModel;
import com.example.myapplication.Utils.Exercise;
import com.example.myapplication.Utils.Food;
import com.example.myapplication.Utils.FoodViewModel;
import com.example.myapplication.databinding.ActivityBmiPageBinding;
import com.example.myapplication.databinding.ActivityMainBinding;

import java.util.ArrayList;
import java.util.List;

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

//        Intent intent = new Intent(this,AllExercises.class);
//        startActivity(intent);




//
//        FoodViewModel fModel = new FoodViewModel();
//        fModel = ViewModelProviders.of(this ).get(fModel.getClass());
//        //food you wanna search for
//        String searchQuery = "banana";
//        fModel.getFood(searchQuery);
//        fModel.food.observe(this, new Observer<Food>() {
//            @Override
//            public void onChanged(Food food) {
//                //set Food view element here
//                //test toast
//               Toast.makeText(MainActivity.this, food.getItems()[0].getCalories(), Toast.LENGTH_LONG).show();
//            }
//        });


    }}

