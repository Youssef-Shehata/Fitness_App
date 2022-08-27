package com.example.myapplication.Utils;


import com.example.myapplication.exercise;

import java.util.ArrayList;

import retrofit2.Call;
        import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class ExerciseClient {
    private static final String URL = "https://exercisedb.p.rapidapi.com/";
    private com.example.myapplication.Utils.ExerciseInterface apiInterface;
    private static ExerciseClient instance;

public ExerciseClient(){
    Retrofit retrofit = new Retrofit.Builder()
            .baseUrl(URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build();

    apiInterface= retrofit.create(ExerciseInterface.class);

}
    public static ExerciseClient getInstance() {
    if(instance == null){
        instance = new ExerciseClient();
    }
        return instance;
    }

    public Call<ArrayList<exercise>> getExercises(){
    return apiInterface.getExercise();
    }






























}




