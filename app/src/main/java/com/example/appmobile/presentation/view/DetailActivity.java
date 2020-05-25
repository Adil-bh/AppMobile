package com.example.appmobile.presentation.view;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;

import androidx.recyclerview.widget.RecyclerView;

import com.example.appmobile.R;
import com.example.appmobile.presentation.controller.MainController;
import com.example.appmobile.presentation.model.Matchs;
import com.google.gson.Gson;

public class DetailActivity extends Activity {
    private RecyclerView recyclerView;
    private RecyclerView.Adapter mAdapter;
    private RecyclerView.LayoutManager layoutManager;
    private SharedPreferences sharedPreferences;
    private Gson gson;

    private MainController controller;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.custompopup);




    }
}