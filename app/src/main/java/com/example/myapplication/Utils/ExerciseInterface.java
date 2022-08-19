package com.example.myapplication.Utils;

import android.database.Observable;

import com.example.myapplication.Utils.Exercise;

import java.util.List;

import retrofit2.Call;
import retrofit2.Response;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.Headers;
import retrofit2.http.PATCH;
import retrofit2.http.Path;

public interface ExerciseInterface {


    @Headers({

            "Accept: application/json",
            "X-RapidAPI-Key: RAPID_API_KEY",
            "X-RapidAPI-Host: exercisedb.p.rapidapi.com"


    })
    @GET("exercises")


    public Call<List<Exercise>> getExercise ();

}