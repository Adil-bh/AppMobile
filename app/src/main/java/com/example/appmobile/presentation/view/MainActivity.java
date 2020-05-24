package com.example.appmobile.presentation.view;

import android.app.Activity;
import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.Toast;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.appmobile.Constants;
import com.example.appmobile.presentation.model.Matchs;
import com.example.appmobile.R;
import com.example.appmobile.data.FootAPI;
import com.example.appmobile.presentation.model.RestMatchResponse;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends Activity {
    private RecyclerView recyclerView;
    private RecyclerView.Adapter mAdapter;
    private RecyclerView.LayoutManager layoutManager;
    private SharedPreferences sharedPreferences;
    private Gson gson;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        sharedPreferences = getSharedPreferences("application_foot", Context.MODE_PRIVATE);
        gson = new GsonBuilder()
                .setLenient()
                .create();
        List<Matchs> matchsList = getDataFromCache();

        if(matchsList != null){
            showList(matchsList);
        } else {
            makeApiCall();
        }

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


    private void showList(List<Matchs> matchsList) {

        recyclerView = (RecyclerView) findViewById(R.id.recycler_view);
        recyclerView.setHasFixedSize(true);
        // use a linear layout manager
        layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);


        // define an adapter
        mAdapter = new ListAdapter(matchsList);
        recyclerView.setAdapter(mAdapter);

    }

    private static final String BASE_URL = "https://raw.githubusercontent.com/Adil-bh/AppMobile/master/";
    private void makeApiCall(){


        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create(gson))
                .build();

        FootAPI footapi = retrofit.create(FootAPI.class);

        Call<RestMatchResponse> call = footapi.getMatchResponse();
        call.enqueue(new Callback<RestMatchResponse>() {
            @Override
            public void onResponse(Call<RestMatchResponse> call, Response<RestMatchResponse> response) {
                if(response.isSuccessful() && response.body() != null){
                    List<Matchs> matchsList = response.body().getResults();
                    Toast.makeText(getApplicationContext(), "API Success", Toast.LENGTH_SHORT).show();
                    saveList(matchsList);
                    showList(matchsList);
                } else {
                    showError();
                }
            }

            @Override
            public void onFailure(Call<RestMatchResponse> call, Throwable t) {
                showError();
            }
        });

    }

    private void saveList(List<Matchs> matchsList) {


        String jsonString = gson.toJson(matchsList);
        sharedPreferences
                .edit()
                .putString(Constants.KEY_MATCH_LIST, jsonString)
                .apply();

        Toast.makeText(this, "List saved", Toast.LENGTH_SHORT).show();

    }

    private void showError() {
        Toast.makeText(getApplicationContext(), "API Error", Toast.LENGTH_SHORT).show();
    }
}