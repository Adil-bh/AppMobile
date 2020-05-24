package com.example.appmobile.data;

import com.example.appmobile.presentation.model.RestMatchResponse;

import retrofit2.Call;
import retrofit2.http.GET;

public interface FootAPI {

    @GET("matchs.json")
    Call<RestMatchResponse> getMatchResponse();
}
