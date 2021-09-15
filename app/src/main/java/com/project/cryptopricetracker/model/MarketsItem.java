package com.project.cryptopricetracker.model;

import com.google.gson.annotations.SerializedName;

public class MarketsItem{

	@SerializedName("price_unconverted")
	private double priceUnconverted;

	@SerializedName("symbol")
	private String symbol;

	@SerializedName("exchange_id")
	private String exchangeId;

	@SerializedName("base_asset")
	private String baseAsset;

	@SerializedName("price")
	private double price;

	@SerializedName("change_24h")
	private double change24h;

	@SerializedName("volume_24h")
	private double volume24h;

	@SerializedName("quote_asset")
	private String quoteAsset;

	@SerializedName("time")
	private String time;

	@SerializedName("spread")
	private double spread;

	@SerializedName("status")
	private String status;

	public void setPriceUnconverted(double priceUnconverted){
		this.priceUnconverted = priceUnconverted;
	}

	public double getPriceUnconverted(){
		return priceUnconverted;
	}

	public void setSymbol(String symbol){
		this.symbol = symbol;
	}

	public String getSymbol(){
		return symbol;
	}

	public void setExchangeId(String exchangeId){
		this.exchangeId = exchangeId;
	}

	public void setPrice(double price){
		this.price = price;
	}

	public double getPrice(){
		return price;
	}

	public void setChange24h(double change24h){
		this.change24h = change24h;
	}

	public double getChange24h(){
		return change24h;
	}

	public void setVolume24h(double volume24h){
		this.volume24h = volume24h;
	}

	public double getVolume24h(){
		return volume24h;
	}

	public void setQuoteAsset(String quoteAsset){
		this.quoteAsset = quoteAsset;
	}

	public String getQuoteAsset(){
		return quoteAsset;
	}

	public void setTime(String time){
		this.time = time;
	}

	public String getTime(){
		return time;
	}

	public void setSpread(double spread){
		this.spread = spread;
	}

	public double getSpread(){
		return spread;
	}

	public void setStatus(String status){
		this.status = status;
	}

	public String getStatus(){
		return status;
	}

	@Override
 	public String toString(){
		return 
			"MarketsItem{" + 
			"price_unconverted = '" + priceUnconverted + '\'' + 
			",symbol = '" + symbol + '\'' + 
			",exchange_id = '" + exchangeId + '\'' + 
			",base_asset = '" + baseAsset + '\'' + 
			",price = '" + price + '\'' + 
			",change_24h = '" + change24h + '\'' + 
			",volume_24h = '" + volume24h + '\'' + 
			",quote_asset = '" + quoteAsset + '\'' + 
			",time = '" + time + '\'' + 
			",spread = '" + spread + '\'' + 
			",status = '" + status + '\'' + 
			"}";
		}
}