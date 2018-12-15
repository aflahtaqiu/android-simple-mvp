package com.company.aflah.simplemvp.model;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class Store {

    @SerializedName("stores")
    public List<detailStore> detailStores;

    public static class detailStore{
        @SerializedName("id")
        public int id;
        @SerializedName("name")
        public String name;
        @SerializedName("phone")
        public String phone;
        @SerializedName("location")
        public String location;
    }
}
