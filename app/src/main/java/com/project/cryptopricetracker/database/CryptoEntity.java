package com.project.cryptopricetracker.database;

import androidx.room.ColumnInfo;
import androidx.room.Ignore;
import androidx.room.PrimaryKey;

@androidx.room.Entity(tableName = "Crypto")

public class CryptoEntity {
    public static final String TABLE_NAME = "Crypto";
    @PrimaryKey(autoGenerate = true)
    private int id;
    @ColumnInfo(name = "Symbol")
    private String symbol;
    @ColumnInfo(name = "Price")
    private String price;

    public int getId(){
        return id;
    }

    public void setId(int id){
        this.id = id;
    }

    public String getSymbol(){
        return symbol;
    }

    public void setSymbol(String symbol){
        this.symbol = symbol;
    }

    public String getPrice(){
        return price;
    }

    public void setPrice(String price){
        this.price = price;
    }

    public CryptoEntity(int id, String symbol, String price){
        this.id = id;
        this.symbol = symbol;
        this.price = price;

    }

    @Ignore
    public CryptoEntity(String symbol, String price){
        this.symbol = symbol;
        this.price = price;
    }
}
