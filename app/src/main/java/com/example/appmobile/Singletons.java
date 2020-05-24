package com.example.appmobile;

import android.content.Context;
import android.content.SharedPreferences;

import com.example.appmobile.Constants;
import com.example.appmobile.data.FootAPI;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class Singletons {

    private static Gson gsonInstance;
    private static FootAPI footAPiInstance;
    private static SharedPreferences sharedPreferencesInstance;

    public static Gson getGson(){
        if(gsonInstance == null) {
            gsonInstance = new GsonBuilder()
                    .setLenient()
                    .create();
        }
        return gsonInstance;

    }

    public static FootAPI getFootAPI() {

        if(footAPiInstance == null){
            Retrofit retrofit = new Retrofit.Builder()
                    .baseUrl(Constants.BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create(getGson()))
                    .build();

            footAPiInstance = retrofit.create(FootAPI.class);
        }
        return footAPiInstance;
    }


    public static SharedPreferences getSharedPreferences(Context context){
        if(sharedPreferencesInstance == null){

            sharedPreferencesInstance = context.getSharedPreferences("application_foot", Context.MODE_PRIVATE);
        }
        return sharedPreferencesInstance;
    }
}
