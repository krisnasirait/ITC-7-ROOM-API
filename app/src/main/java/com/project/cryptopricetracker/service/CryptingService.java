package com.project.cryptopricetracker.service;

import com.project.cryptopricetracker.model.CryptingResponse;
import com.project.cryptopricetracker.model.MarketsItem;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class CryptingService {
    private Retrofit retrofit = null;

    public CryptingAPI getAPI(){
        if(retrofit == null){
            retrofit = new Retrofit
                    .Builder()
                    .baseUrl(CryptingAPI.URL_BASE)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
        }
        return retrofit.create(CryptingAPI.class);
    }

    public void getMarkets(final CryptingListener<List<MarketsItem>> listener){
        getAPI().getCrypto().enqueue(new Callback<CryptingResponse>() {
            @Override
            public void onResponse(Call<CryptingResponse> call, Response<CryptingResponse> response) {
                CryptingResponse data = response.body();

                if(data != null && data.getMarkets() != null){
                    listener.onSuccess(data.getMarkets());
                }
            }

            @Override
            public void onFailure(Call<CryptingResponse> call, Throwable t) {
                listener.onFailed(t.getMessage());
            }
        });
    }
}
