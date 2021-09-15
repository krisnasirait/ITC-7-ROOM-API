package com.project.cryptopricetracker;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Adapter;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.project.cryptopricetracker.database.CryptoEntity;

import java.util.ArrayList;

public class CryptoAdapter extends RecyclerView.Adapter<CryptoAdapter.ViewHolder> {

    ArrayList<CryptoEntity> cryptoEntities;
    private onRecycleViewClickListener listener;

    public interface onRecycleViewClickListener{
        void onItemClick(int position);
    }

    public void onRecycleViewClickListener(onRecycleViewClickListener listener){
        this.listener = listener;
    }

    public CryptoAdapter(ArrayList<CryptoEntity> cryptoEntities){
        this.cryptoEntities = cryptoEntities;
    }

    @NonNull
    @Override
    public CryptoAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.crypto_list, parent, false);
        return new ViewHolder(v, listener);
    }

    @Override
    public void onBindViewHolder(@NonNull CryptoAdapter.ViewHolder holder, int position) {
        holder.onBind(cryptoEntities.get(position));
    }

    @Override
    public int getItemCount() {
        return cryptoEntities.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder{
        TextView tvPrice, tvPair, tvExchange;

        public ViewHolder(@NonNull View itemView, onRecycleViewClickListener listener){
            super(itemView);
            tvPrice = itemView.findViewById(R.id.tv_Prices);
            tvPair = itemView.findViewById(R.id.tv_Pair);
            tvExchange = itemView.findViewById(R.id.tv_Exchange);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if(listener != null && getAdapterPosition() != RecyclerView.NO_POSITION){
                        listener.onItemClick(getAdapterPosition());
                    }
                }
            });
        }



        void onBind(CryptoEntity cryptoEntity){
            TextView symbol = itemView.findViewById(R.id.tv_symbol);
            symbol.setText(cryptoEntity.getSymbol());

            TextView price = itemView.findViewById(R.id.tv_price);
            price.setText(cryptoEntity.getPrice());
        }
    }
}
