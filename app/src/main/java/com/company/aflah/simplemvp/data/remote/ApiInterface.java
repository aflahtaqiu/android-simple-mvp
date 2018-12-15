package com.company.aflah.simplemvp.data.remote;

import com.company.aflah.simplemvp.model.Store;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface ApiInterface {

    @GET("store")
    Call<Store> getListStore();

    @GET("store/{id}")
    Call<Store.detailStore> getStoreById(
            @Path("id") int id
    );
}
