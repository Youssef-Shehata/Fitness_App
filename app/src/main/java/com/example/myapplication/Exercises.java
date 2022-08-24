package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.bumptech.glide.request.target.Target;
import com.example.myapplication.databinding.ActivityExercisesBinding;

public class Exercises extends AppCompatActivity {
    ActivityExercisesBinding binding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityExercisesBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        Intent intent = this.getIntent();

        if (intent != null) {

            String bodypart = intent.getStringExtra("bodypart");
            String equipment = intent.getStringExtra("equipment");
            String gifurl = intent.getStringExtra("gifurl");
            String ExerciseId = intent.getStringExtra("ExerciseId");
            String name = intent.getStringExtra("name");
            String target = intent.getStringExtra("target");

            ImageView Gifurl;
            Gifurl = findViewById(R.id.gifurl);
            Glide.with(Exercises.this)
                    .load(gifurl)
                                    .diskCacheStrategy(DiskCacheStrategy.ALL)
                                            .into(Gifurl);


            binding.bodypart.setText(bodypart);
            binding.equipment.setText(equipment);
            //binding.gifurl.setImageResource(Gifurl);
            binding.ExerciseId.setText(ExerciseId);
            binding.name.setText(name);
            binding.target.setText(target);
        }


    }
}
