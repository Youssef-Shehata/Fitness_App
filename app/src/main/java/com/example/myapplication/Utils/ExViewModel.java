package com.example.myapplication.Utils;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.myapplication.exercise;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public  class ExViewModel extends ViewModel {
    public MutableLiveData<ArrayList<exercise>> exercises = new MutableLiveData<>();
    public void getExercises(){
        ExerciseClient.getInstance().getExercises().enqueue(new Callback<ArrayList<exercise>>() {
            @Override
            public void onResponse(Call<ArrayList<exercise>> call, Response<ArrayList<exercise>> response) {
                exercises.setValue(response.body());
            }

            @Override
            public void onFailure(Call<ArrayList<exercise>> call, Throwable t) {
                call.cancel();

            }
        });
    }




}