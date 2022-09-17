package com.example.cat_information.Activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.cat_information.Api;
import com.example.cat_information.R;
import com.example.cat_information.model.Detail;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity2 extends AppCompatActivity {

    private ImageView imgDetail;
    private TextView tvName;
    private TextView tvOrigin;
    private TextView tvDescription;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        imgDetail = (ImageView) findViewById(R.id.imgDetail);
        tvName = (TextView) findViewById(R.id.tvName);
        tvOrigin = (TextView) findViewById(R.id.tvOrigin);
        tvDescription = (TextView) findViewById(R.id.tvDescription);

        Intent i = getIntent();

        String idMeo = i.getStringExtra("_id");
        getApiDetails(idMeo);
    }

    private void getApiDetails(String idMeo) {

        Gson gson = new GsonBuilder()
                .setLenient ()
                .create ();
        Retrofit retrofit = new Retrofit.Builder().baseUrl("https://api.thecatapi.com/v1/images/")
                .addConverterFactory(GsonConverterFactory.create(gson))
                .build();

        Api api = retrofit.create(Api.class);

        Call<Detail> call = api.getDetails(idMeo);
        call.enqueue(new Callback<Detail>() {
            @Override
            public void onResponse(Call<Detail> call, Response<Detail> response) {
                List<Detail.Breed> list = response.body().getBreeds();
                for(int i = 0 ;  i < list.size();  i++ ){
                    Glide.with(MainActivity2.this).load(response.body().getUrl()).into(imgDetail);
                    tvName.setText(list.get(i).getName());
                    tvOrigin.setText(list.get(i).getOrigin());
                    tvDescription.setText(list.get(i).getDescription());
                }
            }

            @Override
            public void onFailure(Call<Detail> call, Throwable t) {

            }
        });


    }
}