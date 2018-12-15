package com.company.aflah.simplemvp.data.remote;

import android.util.Log;

import com.company.aflah.simplemvp.data.StoreDataSource;
import com.company.aflah.simplemvp.model.Store;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class StoreRemoteDataSource implements StoreDataSource {

    private ApiInterface apiInterface = ApiClient.getClient().create(ApiInterface.class);

    @Override
    public void getStoreLIst(final GetStoresListCallback callback) {

        Call<Store> call = apiInterface.getListStore();
        call.enqueue(new Callback<Store>() {
            @Override
            public void onResponse(Call<Store> call, Response<Store> response) {
                callback.onSuccess(response.body());
                Log.e("errorTayo", response.body().toString());
            }

            @Override
            public void onFailure(Call<Store> call, Throwable t) {
                callback.onFailure(t.getMessage());
            }
        });
    }

    @Override
    public void getStoreById(int idStore, final GetStoreByIdCallBack callBack) {

        Call<Store.detailStore> call = apiInterface.getStoreById(idStore);
        call.enqueue(new Callback<Store.detailStore>() {
            @Override
            public void onResponse(Call<Store.detailStore> call, Response<Store.detailStore> response) {
                callBack.onSuccess(response.body());
            }

            @Override
            public void onFailure(Call<Store.detailStore> call, Throwable t) {
                callBack.onFailure(t.getMessage());
            }
        });
    }

}
