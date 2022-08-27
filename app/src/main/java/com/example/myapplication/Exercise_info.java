package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.webkit.WebViewClient;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.bumptech.glide.request.target.Target;
import com.example.myapplication.databinding.ActivityExercisesBinding;

public class Exercise_info extends AppCompatActivity {
    ActivityExercisesBinding binding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getSupportActionBar().hide();

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

           // Glide.with(getApplicationContext()).asGif().load(gifurl).into(binding.gifurl);
            binding.gifurl.getSettings().setJavaScriptEnabled(true);
            binding.gifurl.setWebViewClient(new WebViewClient());
            binding.gifurl.loadUrl(gifurl);
            Log.i("test" , gifurl);



            binding.bodypart.setText(bodypart);
            binding.equipment.setText(equipment);
            //binding.gifurl.setImageResource(Gifurl);
            binding.name.setText(name);
            binding.target.setText(target);
        }


    }
}
