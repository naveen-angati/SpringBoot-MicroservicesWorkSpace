package com.nt.service;

import java.util.List;

import com.nt.document.StockInfo;

public interface IStockInfoMgmt {
	public   String registerStock(StockInfo info);
	public   List<StockInfo>  searchStocksByExchange(String exchange);
	public   List<StockInfo>   searchStockByStockPriceRanage(double start,double end);
	public     String     updateStockDetailsById(int stockId , double newPrice,String newExchange );
	public     String   updateStockExchangeNameByPriceRange(double start,double end,String newExchangeName);
	public      String   saveOrUpdateStock(String stockName, double  newPrice, String newExchange);
	public      String   removeStocksByPriceRange(double start,double end);

}
