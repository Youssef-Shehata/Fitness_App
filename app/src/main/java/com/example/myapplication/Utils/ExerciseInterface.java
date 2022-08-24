package com.example.myapplication.Utils;

import android.database.Observable;

import com.example.myapplication.User;
import com.example.myapplication.Utils.Exercise;

import java.lang.reflect.Array;
import java.net.UnknownServiceException;
import java.util.ArrayList;
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
            "X-RapidAPI-Key: 21c474ebd6mshd4f70ae2297f89ep107189jsn777d5dc78494",
            "X-RapidAPI-Host: exercisedb.p.rapidapi.com"

    })
    @GET("exercises")


    public Call<ArrayList<User>> getExercise ();

}
