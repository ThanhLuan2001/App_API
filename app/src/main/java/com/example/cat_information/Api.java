package com.example.cat_information;

import com.example.cat_information.model.Detail;
import com.example.cat_information.model.ModelApi;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface Api {


    @GET("search?limit=10&breed_ids=beng&api_key=REPLACE_ME")
    Call<ArrayList<ModelApi>> getListMeoCall();

    @GET("{position}")
    Call<Detail> getDetails(@Path(value = "position") String position );


}
