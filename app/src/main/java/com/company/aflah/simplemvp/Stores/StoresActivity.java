package com.company.aflah.simplemvp.Stores;

import android.app.ProgressDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.widget.Toast;

import com.company.aflah.simplemvp.Injection;
import com.company.aflah.simplemvp.R;
import com.company.aflah.simplemvp.model.Store;


import java.util.ArrayList;
import java.util.List;

public class StoresActivity extends AppCompatActivity implements StoresContract.view {

    private ProgressDialog progressDialog;
    private RecyclerView recyclerView;
    private StoreAdapter adapter;
    private List<Store.detailStore> stores = new ArrayList<>();

    private StoresPresenter presenter = new StoresPresenter(Injection.provideRepository(),this);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_stores);
        recyclerView = (RecyclerView) findViewById(R.id.recyclerView);
        presenter.getListDataStore();
        initAdapter();
    }

    @Override
    public void showProgress() {

        progressDialog = new ProgressDialog(StoresActivity.this);
        progressDialog.setTitle("LOading");
        progressDialog.setMessage("Tunggu sebentar ya ...");
        progressDialog.show();
    }

    @Override
    public void hideProgress() {
        progressDialog.dismiss();
    }

    @Override
    public void showListData(Store stores) {
        this.stores.addAll(stores.detailStores);
        adapter.notifyDataSetChanged();
    }

    @Override
    public void showError(String err) {
        Toast.makeText(StoresActivity.this, "Error: " + err, Toast.LENGTH_LONG).show();
        Log.e("errorTayo", err);
    }

    private void initAdapter(){
        Log.e("errorTayo", "masuk adapter");
        adapter = new StoreAdapter(stores);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.setAdapter(adapter);
    }
}
