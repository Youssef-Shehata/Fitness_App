package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;

import com.example.myapplication.databinding.ActivityAllExercisesBinding;
import com.example.myapplication.databinding.ActivityMainBinding;

import java.util.ArrayList;

public class AllExercises extends AppCompatActivity {
ActivityAllExercisesBinding  binding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityAllExercisesBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        int[] imageid = {R.drawable.a , R.drawable.a , R.drawable.a};
        String[] bodypart = {"back" ,"leg" , "shoulder"};
        String[] equipment = {"cable" , "machine", "dumble"};
        int[] gifurl =  {R.drawable.a , R.drawable.a , R.drawable.a};
        String[] ExerciseId = {"a" , "b" ,"c"};
        String[] name = {"first","second","third"};
        String[] target = {"kratos","joel","nate"};


        ArrayList<User> userArrayList = new ArrayList<>();
        for (int i = 0 ; i < gifurl.length ;i++){
            User user = new User(bodypart[i],equipment[i],gifurl[i], ExerciseId[i],name[i],target[i]);
            userArrayList.add(user);
        }

        ListAdapter listAdapter = new ListAdapter(AllExercises.this,userArrayList);
        binding.ListView.setAdapter(listAdapter);
        binding.ListView.setClickable(true);
        binding.ListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent i = new Intent(AllExercises.this,Exercises.class);
                i.putExtra("bodypart",bodypart[position]);
                i.putExtra("equipment",equipment[position]);
                i.putExtra("ExerciseId",ExerciseId[position]);
                i.putExtra("name",name[position]);
                i.putExtra("target",target[position]);
                startActivity(i);

// intial Ui
            }
        });

    }
}