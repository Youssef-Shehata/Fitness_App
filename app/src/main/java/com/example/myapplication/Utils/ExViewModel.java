package com.example.myapplication.Utils;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public  class ExViewModel extends ViewModel {
    public MutableLiveData<List<Exercise>> exercises = new MutableLiveData<>();
    public void getExercises(){
        ExerciseClient.getInstance().getExercises().enqueue(new Callback<List<Exercise>>() {
            @Override
            public void onResponse(Call<List<Exercise>> call, Response<List<Exercise>> response) {
                exercises.setValue(response.body());
            }

            @Override
            public void onFailure(Call<List<Exercise>> call, Throwable t) {
                call.cancel();
            }
        });
    }




}