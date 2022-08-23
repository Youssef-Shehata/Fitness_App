package com.example.myapplication.Utils;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Headers;
import retrofit2.http.Query;


import com.example.myapplication.Utils.Food;

public interface foodApiInterface {

    @Headers({
            "Accept: application/json",
            "X-RapidAPI-Key: ",
            "X-RapidAPI-Host: calorieninjas.p.rapidapi.com",



    })
    @GET("nutrition")


    public Call<Food> getFood (@Query("query") String one);

}