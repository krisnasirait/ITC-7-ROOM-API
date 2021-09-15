package com.project.cryptopricetracker.model;

import java.util.List;
import com.google.gson.annotations.SerializedName;

public class CryptingResponse{

	@SerializedName("markets")
	private List<MarketsItem> markets;

	@SerializedName("pagination")
	private Pagination pagination;

	public void setMarkets(List<MarketsItem> markets){
		this.markets = markets;
	}

	public List<MarketsItem> getMarkets(){
		return markets;
	}

	public void setPagination(Pagination pagination){
		this.pagination = pagination;
	}

	public Pagination getPagination(){
		return pagination;
	}

	@Override
 	public String toString(){
		return 
			"CryptingResponse{" + 
			"markets = '" + markets + '\'' + 
			",pagination = '" + pagination + '\'' + 
			"}";
		}
}