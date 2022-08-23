package com.example.myapplication;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.EditText;
import android.widget.ImageButton;

import com.example.myapplication.databinding.ActivityBmiPageBinding;
import com.example.myapplication.databinding.ActivityFoodPageBinding;

public class Food_page extends AppCompatActivity {
    @NonNull
//    ActivityFoodPageBinding binding;
//  ImageButton search_btn=(ImageButton) findViewById(R.id.searchButton);
//  EditText search_tx=(EditText) findViewById(R.id.search_tx);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_food_page);
//        binding = ActivityFoodPageBinding.inflate(getLayoutInflater());

        //setContentView(binding.getRoot());
      //  getSupportActionBar().hide();
//        binding.searchTx.setVisibility(View.INVISIBLE);
//        binding.searchButton.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                binding.searchTx.setVisibility(View.VISIBLE);
//            }
//        });

    }

}