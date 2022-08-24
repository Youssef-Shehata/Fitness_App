package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Toast;

import com.example.myapplication.Utils.ExViewModel;
import com.example.myapplication.Utils.Exercise;
import com.example.myapplication.databinding.ActivityAllExercisesBinding;
import com.example.myapplication.databinding.ActivityMainBinding;

import java.util.ArrayList;
import java.util.List;

public class AllExercises extends AppCompatActivity {
    ArrayList<User> userArrayList = new ArrayList<>();
ActivityAllExercisesBinding  binding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        binding = ActivityAllExercisesBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

//        int[] imageid = {R.drawable.a , R.drawable.a , R.drawable.a};
//        String[] bodypart = {"back" ,"leg" , "shoulder"};
//        String[] equipment = {"cable" , "machine", "dumble"};
//        int[] gifurl =  {R.drawable.a , R.drawable.a , R.drawable.a};
//        String[] ExerciseId = {"a" , "b" ,"c"};
//        String[] name = {"first","second","third"};
//        String[] target = {"kratos","joel","nate"};


        ExViewModel eModel = new ExViewModel();
        eModel = ViewModelProviders.of(this ).get(eModel.getClass());


        eModel.getExercises();
        eModel.exercises.observe(this, new Observer<ArrayList<User>>() {
            @Override
            public void onChanged(ArrayList<User> userArrayList) {
                //set Exercises view element here
                //test toast
                if (userArrayList != null) {
                    ListAdapter listAdapter = new ListAdapter(AllExercises.this, userArrayList );
                    binding.ListView.setAdapter(listAdapter);
                    binding.ListView.setClickable(true);
                    binding.ListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                        @Override
                        public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                            Intent i = new Intent(AllExercises.this, Exercises.class);
                            i.putExtra("bodypart", userArrayList.get(position).getBodyPart());
                            i.putExtra("equipment", userArrayList.get(position).getEquipment());
                            i.putExtra("gifurl", userArrayList.get(position).getGifUrl());
                            i.putExtra("ExerciseId", userArrayList.get(position).getId());
                            i.putExtra("name", userArrayList.get(position).getName());
                            i.putExtra("target", userArrayList.get(position).getTarget());

                            startActivity(i);

// intial Ui
                        }
                    });
                }
//                if (userArrayList == null) Toast.makeText(AllExercises.this, "null", Toast.LENGTH_SHORT).show();
//                if (userArrayList != null) Toast.makeText(AllExercises.this, "!null", Toast.LENGTH_SHORT).show();


            }
        });
//
//
//        for (int i = 0 ; i < gifurl.length ;i++){
//            User user = new User(bodypart[i],equipment[i],gifurl[i], ExerciseId[i],name[i],target[i]);
//            userArrayList.add(user);
//        }


    }
}