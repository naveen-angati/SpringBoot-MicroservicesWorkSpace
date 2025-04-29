package com.nt.service;

import java.util.List;

import com.nt.entity.Tourist;
import com.nt.error.TouristNotFoundException;

public interface ITouristMgmtService {
   public  String  registerTourist(Tourist  toursit);
   public  List<Tourist>  getAllTourists();
   public  Tourist  getTouristById(int id)throws TouristNotFoundException;
   public   List<Tourist>  findAllTouristsByName(String name);
   public  String   updateTouristDetails(Tourist tourist)throws TouristNotFoundException;
   public  String   updateTouristBudgetById(int tid, double hikePercentage)throws TouristNotFoundException;
   public  String    removeTouristById(int id)throws TouristNotFoundException;
   public  String    removeTouristsByBudgetRange(double start,double end);
}
