package com.example.myapplication.Utils;

import android.widget.Toast;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.myapplication.MainActivity;
import com.example.myapplication.User;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public  class ExViewModel extends ViewModel {
    public MutableLiveData<ArrayList<User>> exercises = new MutableLiveData<>();
    public void getExercises(){
        ExerciseClient.getInstance().getExercises().enqueue(new Callback<ArrayList<User>>() {
            @Override
            public void onResponse(Call<ArrayList<User>> call, Response<ArrayList<User>> response) {
                exercises.setValue(response.body());
            }

            @Override
            public void onFailure(Call<ArrayList<User>> call, Throwable t) {
                call.cancel();

            }
        });
    }




}