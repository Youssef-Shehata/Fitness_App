package com.example.myapplication.Utils;

import android.view.View;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import java.nio.channels.MulticastChannel;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class FoodViewModel extends ViewModel {
    public MutableLiveData<Food> food = new MutableLiveData<>();
    //public MutableLiveData<Food> food=null;
    public void getFood(String searchQuery){
        FoodClient.getInstance().getFood(searchQuery).enqueue(new Callback<Food>() {
            @Override
            public void onResponse(Call<Food> call, Response<Food> response) {
                if (response.isSuccessful())
                {
                    food.setValue(response.body());
                }

            }

            @Override
            public void onFailure(Call<Food> call, Throwable t) {
                call.cancel();


            }
        });







    }










}
