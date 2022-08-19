package com.example.myapplication.Utils;


//todo Edit The Colors

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class FoodClient {
        private static final String URL = "https://calorieninjas.p.rapidapi.com/v1/";
        private foodApiInterface foodapiInterface;
        private static FoodClient instance;

        public FoodClient() {
                Retrofit retrofit = new Retrofit.Builder()
                        .baseUrl(URL)
                        .addConverterFactory(GsonConverterFactory.create())
                        .build();

                foodapiInterface  = retrofit.create(foodApiInterface.class);


        }
        public static FoodClient getInstance() {
                if(instance == null){
                        instance = new FoodClient();
                }
                return instance;
        }


        public Call<Food> getFood(String query){
                return foodapiInterface.getFood(query);
        }



}