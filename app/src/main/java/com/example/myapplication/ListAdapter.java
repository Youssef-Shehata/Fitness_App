package com.example.myapplication;

import android.content.Context;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.DisplayContext;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.target.Target;
import com.example.myapplication.Utils.Exercise;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

public class ListAdapter extends ArrayAdapter<User> {

    public ListAdapter(Context context , ArrayList<User> userArrayList){
        
        super(context , R.layout.list_item , userArrayList);
        if (userArrayList != null) System.out.println("JJJJJJJJJJJJJJKJJJJJJJJJJJJJJJJJJJJJJJJJ") ;

        if (userArrayList != null) System.out.println(userArrayList.get(10).getGifUrl()) ;
        if (userArrayList == null) System.out.println("JJJJJJJJJJJJJJJJJJJJJJJJJJJJJJJJJJJJJJJJJJJJJJ") ;

    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent  ) {

        User user = getItem(position);

        if (convertView == null){
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.list_item,parent, false);

        }
//        if (userArrayList == null) Toast.makeText(AllExercises.this, "null", Toast.LENGTH_SHORT).show();
        ImageView imageView = convertView.findViewById(R.id.training_image);
        TextView TrainigName = convertView.findViewById(R.id.training_name);
        TextView info = convertView.findViewById(R.id.info);
//        imageView.setImageResource(Integer.parseInt(user.gifurl));
        TrainigName.setText(user.getName());
        info.setText(user.getTarget());
//        Picasso.get().load(user.getGifUrl()).into(imageView);
        Glide.with(super.getContext())
                .load(user.getGifUrl())
                .override(Target.SIZE_ORIGINAL, Target.SIZE_ORIGINAL)
//                .placeholder(R.drawable.male)
                .into(imageView);

        return convertView;
    }
}
