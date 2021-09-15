package com.project.cryptopricetracker.service;

import com.project.cryptopricetracker.model.CryptingResponse;

import retrofit2.Call;
import retrofit2.http.GET;

public interface CryptingAPI {
    String URL_BASE = "https://www.cryptingup.com/api/";

    @GET("markets")
    Call<CryptingResponse> getCrypto();
}
