package com.project.cryptopricetracker.service;

public interface CryptingListener <T>{
    void onSuccess(T items);
    void onFailed(String msg);
}
