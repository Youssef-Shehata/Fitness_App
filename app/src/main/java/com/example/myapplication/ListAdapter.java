package com.example.myapplication;

import android.content.Context;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;

public class ListAdapter extends ArrayAdapter<User> {

    public ListAdapter(Context context , ArrayList<User> userArrayList){
        super(context , R.layout.list_item , userArrayList);
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {

        User user = getItem(position);

        if (convertView == null){
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.list_item,parent, false);

        }
        ImageView imageView = convertView.findViewById(R.id.training_image);
        TextView TrainigName = convertView.findViewById(R.id.training_name);
        TextView info = convertView.findViewById(R.id.info);
        imageView.setImageResource(user.gifurl);
        TrainigName.setText(user.name);
        info.setText(user.target);
        //Picasso.get().load(user.gifurl).into(imageView);
        return convertView;
    }
}
