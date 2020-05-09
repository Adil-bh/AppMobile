package com.example.appmobile;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface FootAPI {

    @GET("matchs.json")
    Call<RestMatchResponse> getMatchResponse();
}
