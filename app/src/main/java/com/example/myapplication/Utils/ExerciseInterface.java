package com.example.myapplication.Utils;

import com.example.myapplication.exercise;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Headers;

public interface ExerciseInterface {


    @Headers({

            "Accept: application/json",
            "X-RapidAPI-Key: 21c474ebd6mshd4f70ae2297f89ep107189jsn777d5dc78494",
            "X-RapidAPI-Host: exercisedb.p.rapidapi.com"

    })
    @GET("exercises")


    public Call<ArrayList<exercise>> getExercise ();

}
