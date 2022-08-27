package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;

import com.example.myapplication.Utils.ExViewModel;
import com.example.myapplication.databinding.ActivityAllExercisesBinding;

import java.util.ArrayList;

public class AllExercises extends AppCompatActivity {
    ArrayList<exercise> exerciseArrayList = new ArrayList<>();
ActivityAllExercisesBinding  binding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        getSupportActionBar().hide();
        super.onCreate(savedInstanceState);
        binding = ActivityAllExercisesBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        ExViewModel eModel = new ExViewModel();
        eModel = ViewModelProviders.of(this ).get(eModel.getClass());

        eModel.getExercises();
        eModel.exercises.observe(this, new Observer<ArrayList<exercise>>() {
            @Override
            public void onChanged(ArrayList<exercise> exerciseArrayList) {
                //set Exercises view element here
                //test toast
                if (exerciseArrayList != null) {
                    ListAdapter listAdapter = new ListAdapter(AllExercises.this, exerciseArrayList);
                    binding.ListView.setAdapter(listAdapter);
                    binding.ListView.setClickable(true);
                    binding.ListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                        @Override
                        public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                            Intent i = new Intent(AllExercises.this, Exercise_info.class);
                            i.putExtra("bodypart", exerciseArrayList.get(position).getBodyPart());
                            i.putExtra("equipment", exerciseArrayList.get(position).getEquipment());
                            i.putExtra("gifurl", exerciseArrayList.get(position).getGifUrl());
                            i.putExtra("ExerciseId", exerciseArrayList.get(position).getId());
                            i.putExtra("name", exerciseArrayList.get(position).getName());
                            i.putExtra("target", exerciseArrayList.get(position).getTarget());

                            startActivity(i);

                        }
                    });
                }


            }
        });
    }
}
