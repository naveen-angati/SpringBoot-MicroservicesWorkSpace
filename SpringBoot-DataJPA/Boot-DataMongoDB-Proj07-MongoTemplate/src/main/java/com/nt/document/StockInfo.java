//StockInfo.java
package com.nt.document;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Document(collection = "STOCK_INFO")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class StockInfo {
	@Id
	private Integer stockId;
	private  String stockName;
	private  String vendor;
	private  Double price;
	private  String exchangeName;
	

}
