package com.example.myapplication;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.database.Cursor;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

import java.util.ArrayList;

public class BMI_History extends AppCompatActivity {

    RecyclerView recyclerView;
    DBHelper myDB;
    ArrayList<String> height, weight, date, Bmi;
    private BMI_AD.RecylceviewClicklistner listner;
    @NonNull

    BMI_AD bmi_ad;

    @Override
    public boolean onCreateOptionsMenu(@NonNull Menu menu) {
        MenuInflater inflater =getMenuInflater();
        inflater.inflate(R.menu.delete_menu,menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        myDB.DeleteALlData();
        setContentView(R.layout.activity_bmi_history);
        recyclerView= findViewById(R.id.recylerview);
        myDB = new DBHelper(BMI_History.this);
        height = new ArrayList<>();
        weight = new ArrayList<>();
        date = new ArrayList<>();
        Bmi = new ArrayList<>();
        displayData();
        setOnClickListner();
        bmi_ad = new BMI_AD(BMI_History.this,height,weight,date,Bmi,listner);
        recyclerView.setAdapter(bmi_ad);
        recyclerView.setLayoutManager(new LinearLayoutManager(BMI_History.this));

        return super.onOptionsItemSelected(item);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bmi_history);
        getSupportActionBar().setTitle("BmI Records");  // provide compatibility to all the versions

        recyclerView= findViewById(R.id.recylerview);
        myDB = new DBHelper(BMI_History.this);
        height = new ArrayList<>();
        weight = new ArrayList<>();
        date = new ArrayList<>();
        Bmi = new ArrayList<>();
        displayData();
        setOnClickListner();
        bmi_ad = new BMI_AD(BMI_History.this,height,weight,date,Bmi,listner);
        recyclerView.setAdapter(bmi_ad);
        recyclerView.setLayoutManager(new LinearLayoutManager(BMI_History.this));

    }

    private void setOnClickListner() {
        listner = new BMI_AD.RecylceviewClicklistner() {


            @Override
            public void onclick(View V, int postion) {

            }
        };
    }

    void displayData() {
        Cursor cursor = myDB.readAllData(); //store there result from our readAllData in our cursor obj
        if (cursor.getCount() == 0) { //there is no data
            Toast.makeText(this, "No Data. ", Toast.LENGTH_SHORT).show();
        } else {
            while (cursor.moveToNext()) { //read all data from our cursor
                Bmi.add(cursor.getString(5)); //0 means the 1st column
                height.add(cursor.getString(2)); //1 means the 2nd column
                weight.add(cursor.getString(3)); //2 means the 3rd column
                date.add(cursor.getString(4)); //3 means the 4th column
            }
        }
    }
}
