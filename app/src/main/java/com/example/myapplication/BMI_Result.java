package com.example.myapplication;

import static java.lang.Math.pow;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.widget.RelativeLayout;


import com.example.myapplication.databinding.ActivityBmiResultBinding;

public class BMI_Result extends AppCompatActivity {
    ActivityBmiResultBinding binding;

    String currentBMI ="26";
    double intialBMI =26;
    String height;
    String weight;
    String age , gender;
    double intialHeight, intialWeight;
    RelativeLayout mBackground;
    Intent intent ;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        DBHelper db = new DBHelper(this);
        binding = ActivityBmiResultBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        mBackground = findViewById(R.id.content_layout) ;
        intent = getIntent();
        height = intent.getStringExtra("height");
        weight = intent.getStringExtra("weight");
        age = intent.getStringExtra("age");
        gender = intent.getStringExtra("gender");

        intialWeight = Float.parseFloat(weight);
        intialHeight = Float.parseFloat(height);
        //intHeight=intHeight/100;
        intialBMI = intialWeight /pow(intialHeight /100 , 2);
        currentBMI =  Double.toString(intialBMI);

        db.insert(gender, height, weight, age,  currentBMI.substring(0,4));



        getSupportActionBar().hide();


        if (intialBMI < 18.5){
            binding.bmiCategory.setText("underweight");
            mBackground.setBackgroundColor(Color.parseColor("#DA8181"));
            binding.imageView.setImageResource(R.drawable.ic_baseline_highlight_off_24);
        }
        else   if (intialBMI <39.9&& intialBMI >30){
            binding.bmiCategory.setText("Moderate Thiness");
            mBackground.setBackgroundColor(Color.parseColor("#C1B35B"));

        }
        else   if (intialBMI <24.9 && intialBMI >18.5){
            binding.bmiCategory.setText("Healthy");
//            mBackground.setBackgroundColor(Color.YELLOW);
            binding.imageView.setImageResource(R.drawable.ic_baseline_check_circle_outline_24);
        }
        else   if (intialBMI <29.9&& intialBMI >25){
            binding.bmiCategory.setText("Over Weight");
            mBackground.setBackgroundColor(Color.parseColor("#C1B35B"));

        }

        else  {
            binding.bmiCategory.setText("obese");
            mBackground.setBackgroundColor(Color.parseColor("#C1B35B"));
            binding.imageView.setImageResource(R.drawable.ic_baseline_highlight_off_24);
        }

        binding.genderDisplay.setText(gender);

        binding.bmiDisplay.setText(currentBMI.substring(0,5));

        binding.reCalculateBmi.setOnClickListener(view -> {
            startActivity(new Intent(this, BMI_Page.class));
        });


    }
}
