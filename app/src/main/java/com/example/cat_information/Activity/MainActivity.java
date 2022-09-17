package com.example.cat_information.Activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;

import com.example.cat_information.Adapter.MeoAdapter;
import com.example.cat_information.Api;
import com.example.cat_information.R;
import com.example.cat_information.model.ModelApi;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.util.ArrayList;
import java.util.List;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {

    RecyclerView recyclerView;
    Api api;
    MeoAdapter meoAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView = findViewById(R.id.recyView);

        Gson gson = new GsonBuilder().serializeNulls().create();

        HttpLoggingInterceptor loggingInterceptor = new HttpLoggingInterceptor();
        loggingInterceptor.setLevel(HttpLoggingInterceptor.Level.BODY);

        OkHttpClient okHttpClient = new OkHttpClient.Builder()
                .addInterceptor(loggingInterceptor)
                .build();

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://api.thecatapi.com/v1/images/")
                .addConverterFactory(GsonConverterFactory.create(gson))
                .client(okHttpClient)
                .build();

        api = retrofit.create(Api.class);


        Call<ArrayList<ModelApi>> listCall = api.getListMeoCall();

        listCall.enqueue(new Callback<ArrayList<ModelApi>>() {
            @Override
            public void onResponse(Call<ArrayList<ModelApi>> call, Response<ArrayList<ModelApi>> response) {

                List<ModelApi> modelApis = new ArrayList<>();

                modelApis = response.body();
                recyclerView.setHasFixedSize(true);
                recyclerView.setLayoutManager(new LinearLayoutManager(getApplicationContext(),RecyclerView.VERTICAL,false));
                meoAdapter = new MeoAdapter(modelApis, MainActivity.this);
                recyclerView.setAdapter(meoAdapter);


            }
            @Override
            public void onFailure(Call<ArrayList<ModelApi>> call, Throwable t) {
            }
        });
    }

    public void DetailsMeo(String id){
        Intent intent = new Intent(MainActivity.this, MainActivity2.class);
        intent.putExtra("_id",id);
        startActivity(intent);

    }
}