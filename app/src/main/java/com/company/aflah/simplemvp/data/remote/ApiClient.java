package com.company.aflah.simplemvp.data.remote;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class ApiClient {

    private static Retrofit retrofit = null;

    public static Retrofit getClient(){

        retrofit  = new Retrofit.Builder()
                .baseUrl("https://still-spire-77258.herokuapp.com/api/v1/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        return retrofit;
    }
}
