package com.company.aflah.simplemvp.data;

import com.company.aflah.simplemvp.model.Store;

import java.util.List;

public interface StoreDataSource {

    void getStoreLIst(GetStoresListCallback callback);

    void getStoreById(int idStore, GetStoreByIdCallBack callBack);

    interface GetStoresListCallback{

        void onSuccess(Store store);

        void onFailure(String errorMessage);
    }

    interface GetStoreByIdCallBack{

        void onSuccess(Store.detailStore store);

        void onFailure(String errorMessage);
    }
}
