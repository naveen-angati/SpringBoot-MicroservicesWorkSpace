package com.nt.service;

import java.util.List;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Service;

import com.mongodb.client.result.UpdateResult;
import com.nt.document.StockInfo;

@Service("stockService")
public  class StockInfoMgmtImpl implements IStockInfoMgmt {
	@Autowired
	private MongoTemplate  template;

	@Override
	public String registerStock(StockInfo info) {
	    int idVal=template.save(info).getStockId();
		return "StockInfo Object is saved with id value ::"+idVal;
	}

	@Override
	public List<StockInfo> searchStocksByExchange(String exchange) {
		// prepare Query object
		 Query query=new Query();
		 query.addCriteria(Criteria.where("exchangeName").is(exchange));  //where  exchange=?0
		//execute query
		 List<StockInfo>  list=template.find(query,StockInfo.class);
		return list;
	}

	@Override
	public List<StockInfo> searchStockByStockPriceRanage(double start, double end) {
		// prepare Query object
				 Query query=new Query();
				 query.addCriteria(Criteria.where("price").gte(start).lte(end));  //where price>=? and price<=?
				//execute query
				 List<StockInfo>  list=template.find(query,StockInfo.class);
				return list;
	}

	@Override
	public String updateStockDetailsById(int stockId, double newPrice, String newExchange) {
		//prepare  Query object 
		Query query=new Query();
		 query.addCriteria(Criteria.where("stockId").is(stockId));
		 
		 //prepare  Update object
		 Update  update =new Update();
		 update.set("price", newPrice);
		 update.set("exchangeName", newExchange);
		 
		 //execute the query
		 template.findAndModify(query, update, StockInfo.class);
		 
		return  "Document is updated";
	}

	@Override
	public String updateStockExchangeNameByPriceRange(double start, double end, String newExchangeName) {
		//prepare  Query object 
		Query query=new Query();
		 query.addCriteria(Criteria.where("price").gte(start).lte(end));
		//create Update object
		 Update  update=new Update();
		 update.set("exchangeName", newExchangeName);
		// execute the logics
		 UpdateResult result=template.updateMulti(query, update, StockInfo.class);
		 
		return result.getModifiedCount()+" docs are updated";
	}

	@Override
	public String saveOrUpdateStock(String stockName, double newPrice, String newExchange) {
		Query query=new Query();
		 query.addCriteria(Criteria.where("stockName").is(stockName));
		 
		 //create  Update Object
		 Update update =new Update();
		 update.set("exchangeName", newExchange);
		 update.set("price", newPrice);
		 update.setOnInsert("stockName", stockName);
		 update.setOnInsert("stockId",new Random().nextInt(60000));
		 
		 //execute the logics
		 UpdateResult result=template.upsert(query, update, StockInfo.class);
		 
		 return  result.getMatchedCount()==0?" doument is inserted":"document is updated";
		 
		 
	}

	@Override
	public String removeStocksByPriceRange(double start, double end) {
		Query query=new Query();
		 query.addCriteria(Criteria.where("price").gte(start).lte(end));
		 int  count=template.findAllAndRemove(query, StockInfo.class).size();
		 return  count+" no.of docs are removed";
				 
	}

}
