package com.company.aflah.simplemvp;

import com.company.aflah.simplemvp.data.StoreRepository;
import com.company.aflah.simplemvp.data.remote.StoreRemoteDataSource;

public class Injection {

    public static StoreRepository provideRepository(){

        return new StoreRepository(new StoreRemoteDataSource());
    }
}
