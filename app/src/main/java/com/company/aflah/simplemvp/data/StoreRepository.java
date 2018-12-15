package com.company.aflah.simplemvp.data;

import com.company.aflah.simplemvp.data.remote.StoreRemoteDataSource;
import com.company.aflah.simplemvp.model.Store;

import java.util.List;

public class StoreRepository implements StoreDataSource {

    private StoreRemoteDataSource remoteDataSource;

    public StoreRepository(StoreRemoteDataSource remoteDataSource) {
        this.remoteDataSource = remoteDataSource;
    }

    @Override
    public void getStoreLIst(final GetStoresListCallback callback) {

        remoteDataSource.getStoreLIst(new GetStoresListCallback() {
            @Override
            public void onSuccess(Store store) {
                callback.onSuccess(store);
            }

            @Override
            public void onFailure(String errorMessage) {
                callback.onFailure(errorMessage);
            }
        });

    }

    @Override
    public void getStoreById(int idStore, final GetStoreByIdCallBack callBack) {
        remoteDataSource.getStoreById(idStore, new GetStoreByIdCallBack() {
            @Override
            public void onSuccess(Store.detailStore store) {
                callBack.onSuccess(store);
            }

            @Override
            public void onFailure(String errorMessage) {
                callBack.onFailure(errorMessage);
            }
        });
    }
}
