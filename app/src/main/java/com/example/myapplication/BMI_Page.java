package com.example.myapplication;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.SeekBar;
import android.widget.Toast;

import com.example.myapplication.databinding.ActivityBmiPageBinding;

import java.util.ArrayList;

public class BMI_Page extends AppCompatActivity {

    @NonNull ActivityBmiPageBinding binding;
    int intialWeight = 50;
    int intialِAge= 20;
    int intialHeight = 170;
    boolean everyThingIsRigyt = true;
    String currentHeaight = "170";
    String currentWeight = "50";
    String typeOfUser = "0";
    String currentAge= "20";
    private Button but;

    DBHelper myDB;
    ArrayList<String> BMI, height, weight, age;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityBmiPageBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        getSupportActionBar().hide();
        binding.calculateBmi.setOnClickListener(view -> {
            calculateBmi();
        });
        binding.male.setOnClickListener(view -> {
            binding.male.setBackground(ContextCompat.getDrawable(getApplicationContext(), R.drawable.selected_gender));
            binding.female.setBackground(ContextCompat.getDrawable(getApplicationContext(), R.drawable.card_back));
            typeOfUser = "Male";

        });
        binding.female.setOnClickListener(view -> {
            binding.female.setBackground(ContextCompat.getDrawable(getApplicationContext(), R.drawable.selected_gender));
            binding.male.setBackground(ContextCompat.getDrawable(getApplicationContext(), R.drawable.card_back));
            typeOfUser = "Female";

        });
        binding.seekbar.setMax(280);
        binding.seekbar.setProgress(170);
        binding.seekbar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int i, boolean b) {
                intialHeight = i;
                currentHeaight = String.valueOf(intialHeight);
                binding.currentHeight.setText(currentHeaight);
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }

        });
        binding.incrementAge.setOnClickListener(view -> {
            intialِAge = intialِAge+1;
            currentAge= String.valueOf(intialِAge);
            binding.currentAge.setText(currentAge);
        });
        binding.decrementAge.setOnClickListener(view -> {
            intialِAge = intialِAge-1;
            currentAge= String.valueOf(intialِAge);
            binding.currentAge.setText(currentAge);
        });
        binding.incrementWeight.setOnClickListener(view -> {
            intialWeight = intialWeight+1;
            currentWeight= String.valueOf(intialWeight);
            binding.currentWeight.setText(currentWeight);
        });
        binding.decrementWeight.setOnClickListener(view -> {
            intialWeight = intialWeight-1;
            currentWeight= String.valueOf(intialWeight);
            binding.currentWeight.setText(currentWeight);
        });

        myDB = new DBHelper(this);
        BMI = new ArrayList<>();
        height = new ArrayList<>();
        weight = new ArrayList<>();
        age = new ArrayList<>();



        displayData();
        but=(Button) findViewById(R.id.viewhistory);
        but.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                open_history();
            }
        });

    }
    public void open_history(){
        Intent intent =new Intent(this,BMI_History.class);
        startActivity(intent);
    }

    private void calculateBmi() {
        if(typeOfUser.equals("0")){
            Toast.makeText(this, "Please Enter Reasonable Data", Toast.LENGTH_SHORT).show();
            everyThingIsRigyt = false;
        }
        if (intialHeight <= 0 || currentHeaight.equals("0")){
            Toast.makeText(this, "Please Enter Reasonable Data", Toast.LENGTH_SHORT).show();
            everyThingIsRigyt = false;
        }
        if  (intialWeight<=0|| currentWeight.equals("0")){
            Toast.makeText(this, "Please Enter Reasonable Data", Toast.LENGTH_SHORT).show();
            everyThingIsRigyt = false;
        }
        if (currentAge.equals("0")||intialِAge<=0){
            Toast.makeText(this, "Please Enter Reasonable Data", Toast.LENGTH_SHORT).show();
            everyThingIsRigyt = false;
        }
        if (everyThingIsRigyt){
            Intent intent = new Intent(this,BMI_Result.class);
            intent.putExtra("gender", typeOfUser);
            intent.putExtra("height",currentHeaight );
            intent.putExtra("weight", currentWeight);
            intent.putExtra("age", currentAge);

            startActivity(intent);

        }
        else {
            everyThingIsRigyt = true;
        }

    }

    void displayData(){
        Cursor cursor = myDB.readAllData(); //store there result from our readAllData in our cursor obj
        if (cursor.getCount() == 0){ //there is no data
            Toast.makeText(this, "No Data. ", Toast.LENGTH_SHORT).show();
        }
        else {
            while (cursor.moveToNext()){ //read all data from our cursor
                BMI.add(cursor.getString(4)); //0 means the 1st column
                height.add(cursor.getString(2)); //1 means the 2nd column
                weight.add(cursor.getString(1)); //2 means the 3rd column
                age.add(cursor.getString(3)); //3 means the 4th column
            }
        }
    }

}