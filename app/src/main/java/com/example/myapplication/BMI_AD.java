package com.example.myapplication;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ListView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class BMI_AD extends RecyclerView.Adapter<BMI_AD.MyViewHolder> {
    private Context context;
    private ArrayList height, weight,bmi,date;
    private  RecylceviewClicklistner listner;

    public BMI_AD(Context context, ArrayList height, ArrayList weight,  ArrayList date,ArrayList bmi,RecylceviewClicklistner listner) {
        this.context = context;
        this.height = height;
        this.weight = weight;
        this.bmi = bmi;
        this.date = date;
        this.listner = listner;
    }

    @NonNull
    @Override
    public BMI_AD.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.historyv,parent,false);
        return new MyViewHolder(view);
    }


    @Override
    public void onBindViewHolder(@NonNull BMI_AD.MyViewHolder holder, int position) {
        holder.height_txt.setText(String.valueOf(height.get(position)));
        holder.weight_txt.setText(String.valueOf(weight.get(position)));
        holder.bmi_txt.setText(String.valueOf(bmi.get(position)));
        holder.date_txt.setText(String.valueOf(date.get(position)));

    }

    @Override
    public int getItemCount() {
        return height.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{
        TextView height_txt,weight_txt,bmi_txt,date_txt;
        public MyViewHolder(@NonNull View itemView) {

            super(itemView);
            height_txt = itemView.findViewById(R.id.High);
            weight_txt = itemView.findViewById(R.id.Weight);
            bmi_txt = itemView.findViewById(R.id.BMIs);
            date_txt = itemView.findViewById(R.id.date);
            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View view) {listner.onclick(view,getAdapterPosition());
        }
    }
    public interface RecylceviewClicklistner{
        void onclick(View V,int postion);

    }
}


