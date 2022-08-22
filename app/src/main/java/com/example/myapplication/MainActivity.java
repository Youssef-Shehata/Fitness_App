package com.example.myapplication;

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

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    FoodViewModel fModel = new FoodViewModel();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Intent intent = new Intent(this,AllExercises.class);
        startActivity(intent);





        fModel = ViewModelProviders.of(this ).get(fModel.getClass());
        //food you wanna search for
        String searchQuery = "banana";
        fModel.getFood(searchQuery);
        fModel.food.observe(this, new Observer<Food>() {
            @Override
            public void onChanged(Food food) {
                //set Food view element here
                //test toast
               Toast.makeText(MainActivity.this, food.getItems()[0].getCalories(), Toast.LENGTH_LONG).show();
            }
        });


    }}

