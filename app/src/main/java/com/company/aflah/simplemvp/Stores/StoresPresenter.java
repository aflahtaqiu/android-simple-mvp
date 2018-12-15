package com.company.aflah.simplemvp.Stores;

import android.util.Log;

import com.company.aflah.simplemvp.data.StoreDataSource;
import com.company.aflah.simplemvp.data.StoreRepository;
import com.company.aflah.simplemvp.model.Store;

import java.util.List;

public class StoresPresenter implements StoresContract.presenter {

    private StoreRepository storeRepository;
    private StoresContract.view view;

    public StoresPresenter(StoreRepository storeRepository, StoresContract.view view) {
        this.storeRepository = storeRepository;
        this.view = view;
    }

    @Override
    public void getListDataStore() {
        Log.e("errorTayo", "masuk get list data");

        view.showProgress();
        storeRepository.getStoreLIst(new StoreDataSource.GetStoresListCallback() {
            @Override
            public void onSuccess(Store stores) {
                view.hideProgress();
                view.showListData(stores);
            }

            @Override
            public void onFailure(String errorMessage) {
                view.hideProgress();
                view.showError(errorMessage);
            }
        });
    }
}
