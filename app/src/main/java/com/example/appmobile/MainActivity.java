package com.example.appmobile;

import android.app.Activity;
import android.os.Bundle;
import android.widget.Toast;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.util.ArrayList;
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

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

    makeApiCall();
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
        Gson gson = new GsonBuilder()
                .setLenient()
                .create();

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

    private void showError() {
        Toast.makeText(getApplicationContext(), "API Error", Toast.LENGTH_SHORT).show();
    }
}