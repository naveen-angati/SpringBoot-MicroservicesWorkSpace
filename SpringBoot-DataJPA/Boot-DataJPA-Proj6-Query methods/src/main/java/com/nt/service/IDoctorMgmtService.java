package com.nt.service;

import java.util.List;

import org.springframework.data.jpa.repository.Query;

import com.nt.entity.Doctor;

public interface IDoctorMgmtService {
   public List<Doctor>   searchDoctorsBySpecialization(String  sp1, String sp2);
   public  List<Object[]>  showDoctorsDataByIncome(double start, double end);
   public   List<String>  showDoctorosDataByIncomeRange(double min,double max);
   
   
   public   Doctor   searchDoctorByNameDocName(String  docName);
   public   Object    searchDoctorDataByName(String docName);
   public   String    searchSpecilizationByName(String docName);
   
   public    int   showDoctorNamesCount();
   public   Object  showAggregateData();
   
   public  int    appraiseDoctorsIncomeBySpecialization(String specialization, double hikePercentage);
   public   int    fireDoctorsByIncomeRange(double start, double end);
   
   public    String   insertDoctor(String name, double income,String specialization);
   public     String   showSystemDate();
   
  public   String    createTempDBtable();

}
