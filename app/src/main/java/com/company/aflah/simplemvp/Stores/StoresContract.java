package com.company.aflah.simplemvp.Stores;

import com.company.aflah.simplemvp.model.Store;

import java.util.List;

public interface StoresContract {

    interface presenter{
        void getListDataStore();
    }

    interface view{
        void showProgress();
        void hideProgress();
        void showListData(Store stores);
        void showError(String err);
    }
}
