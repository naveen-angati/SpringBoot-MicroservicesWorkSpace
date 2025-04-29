package com.nt.service;

public interface IPurchaseOrderService {
   public  String purchase(String items[], double prices[] , String ToEmails[])throws Exception;
}
