package com.example.appmobile.presentation.controller;

import android.content.SharedPreferences;
import android.widget.Toast;

import com.example.appmobile.Constants;
import com.example.appmobile.Singletons;
import com.example.appmobile.presentation.model.Matchs;
import com.example.appmobile.presentation.model.RestMatchResponse;
import com.example.appmobile.presentation.view.MainActivity;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainController {

    private SharedPreferences sharedPreferences;
    private Gson gson;
    private MainActivity view;

    public MainController(MainActivity mainActivity, Gson gson, SharedPreferences sharedPreferences) {
        this.view = mainActivity;
        this.gson = gson;
        this.sharedPreferences = sharedPreferences;
    }

    public void onStart(){
        List<Matchs> matchsList = getDataFromCache();

        if(matchsList != null){
            view.showList(matchsList);
        } else {
            makeApiCall();
        }

    }

    private void makeApiCall(){



        Call<RestMatchResponse> call = Singletons.getFootAPI().getMatchResponse();
        call.enqueue(new Callback<RestMatchResponse>() {
            @Override
            public void onResponse(Call<RestMatchResponse> call, Response<RestMatchResponse> response) {
                if(response.isSuccessful() && response.body() != null){
                    List<Matchs> matchsList = response.body().getResults();
                    Toast.makeText(view.getApplicationContext(), "API Success", Toast.LENGTH_SHORT).show();
                    saveList(matchsList);
                    view.showList(matchsList);
                } else {
                    view.showError();
                }
            }

            @Override
            public void onFailure(Call<RestMatchResponse> call, Throwable t) {
                view.showError();
            }
        });

    }

    private void saveList(List<Matchs> matchsList) {

        String jsonString = gson.toJson(matchsList);
        sharedPreferences
                .edit()
                .putString(Constants.KEY_MATCH_LIST, jsonString)
                .apply();

        Toast.makeText(view.getApplicationContext(), "List saved", Toast.LENGTH_SHORT).show();

    }


    private List<Matchs> getDataFromCache(){
        String jsonMatchs = sharedPreferences.getString(Constants.KEY_MATCH_LIST, null);

        if(jsonMatchs == null){
            return null;
        } else {
            Type listType = new TypeToken<List<Matchs>>(){}.getType();
            return gson.fromJson(jsonMatchs, listType);
        }

    }
}
