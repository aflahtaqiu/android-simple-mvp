package com.company.aflah.simplemvp.Stores;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.company.aflah.simplemvp.R;
import com.company.aflah.simplemvp.model.Store;

import java.util.List;

public class StoreAdapter extends RecyclerView.Adapter<StoreAdapter.MyViewHolder> {

    List<Store.detailStore> detailStores;

    public StoreAdapter(List<Store.detailStore> detailStores) {
        this.detailStores = detailStores;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {

        View viewRoot = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.cardview_store, viewGroup, false);
        return new MyViewHolder(viewRoot);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder myViewHolder, int i) {
        Store.detailStore store = detailStores.get(i);
        myViewHolder.bind(store);
    }

    @Override
    public int getItemCount() {
        return detailStores.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder{

        public TextView itemNama, itemLokasi, itemPhone;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);

            itemNama = (TextView) itemView.findViewById(R.id.item_name);
            itemLokasi = (TextView) itemView.findViewById(R.id.item_lokasi);
            itemPhone = (TextView) itemView.findViewById(R.id.item_phonr);
        }

        private void bind(final Store.detailStore data){
            itemNama.setText(data.name);
            itemPhone.setText(data.phone);
            itemLokasi.setText(data.location);
        }
    }
}
