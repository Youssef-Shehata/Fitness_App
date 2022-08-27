package com.example.myapplication;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.target.Target;

import java.util.ArrayList;

public class ListAdapter extends ArrayAdapter<exercise> {

    public ListAdapter(Context context , ArrayList<exercise> exerciseArrayList){
        
        super(context , R.layout.list_item , exerciseArrayList);

    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent  ) {

        exercise exercise = getItem(position);

        if (convertView == null){
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.list_item,parent, false);

        }
//        if (userArrayList == null) Toast.makeText(AllExercises.this, "null", Toast.LENGTH_SHORT).show();
        ImageView imageView = convertView.findViewById(R.id.training_image);
        TextView TrainigName = convertView.findViewById(R.id.training_name);
        TextView info = convertView.findViewById(R.id.info);
//        imageView.setImageResource(Integer.parseInt(user.gifurl));
        TrainigName.setText(exercise.getName());
        info.setText(exercise.getTarget());
//        Picasso.get().load(user.getGifUrl()).into(imageView);
        Glide.with(super.getContext())
                .load(exercise.getGifUrl())
                .override(Target.SIZE_ORIGINAL, Target.SIZE_ORIGINAL)
//                .placeholder(R.drawable.male)
                .into(imageView);

        return convertView;
    }
}
