package com.nt.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

import com.nt.entity.Doctor;



public interface IDoctorRepository extends JpaRepository<Doctor,Integer> {
	//@Query("FROM Doctor WHERE income>=?1 AND income<=?2")
	//@Query("FROM com.nt.entity.Doctor WHERE income>=?1 AND income<=?2")
	//@Query("FROM Doctor doc WHERE doc.income>=?1 AND doc.income<=?2")
	//@Query("FROM Doctor doc WHERE doc.income>=? AND doc.income<=?")  //---> Throws the IllegalArgumentException
	/*@Query("SELECT doc FROM Doctor doc WHERE doc.income>=?2 AND doc.income<=?1")
	public List<Doctor>  searchDoctorsByIncomeRange(double startRange, double endRange);*/
	
	/*@Query(" FROM Doctor  WHERE income>=:start AND income<=:end")
	public List<Doctor>  searchDoctorsByIncomeRange(@Param("start")double startRange,@Param("end") double endRange);
	*/
	
	/*@Query(" FROM Doctor  WHERE income>=:start AND income<=:end")
	public List<Doctor>  searchDoctorsByIncomeRange(double start, double end);*/
		
		
    // -------------------  Select -- Entity Query ----------------------------
	@Query("FROM  Doctor WHERE specialization IN(:sp1,:sp2) ORDER BY specialization")
	public  List<Doctor>   searchDoctorsBySpecializations(String  sp1,String sp2);
	
	 // -------------------  Select -- Projection Query with specific multiple col values ----------------------------
	  @Query("SELECT docId,docName,income FROM  Doctor WHERE income between :start and :end")
	   public  List<Object[]>  searchDoctorDataByIncome(double start, double end);
	   
	// -------------------  Select -- Projection Query with specific single col values ----------------------------
	   @Query("SELECT docName FROM  Doctor WHERE income between :min and :max")
	   public  List<String>   searchAllDoctorNamesByIncomeRange(double min ,double max);
		
		
		//  ---------------------Entity Query giving single record -------------------------------------
         @Query("FROM  Doctor where docName=:name ")   //assume that doctor 
		public  Optional<Doctor>    showDoctorInfoByName(String name);
         
     //  ---------------------Scalar Query giving single record  multiple col values -------------------------------------
         @Query("SELECT  docId,docName FROM  Doctor where docName=:name ")   
         public  Object  showDoctorDataByName(String name);
         
         //  ---------------------Scalar Query giving single record  single col value -------------------------------------
         @Query("SELECT  specialization FROM  Doctor where docName=:name ")   
         public  String  showSpecializationByName(String name);
         
         
         @Query( "SELECT  count(distinct docName) FROM Doctor")
         public  int  fetchDoctorsNameCount();
         
         @Query( "SELECT  count(*) ,max(income),min(income),avg(income),sum(income) from Doctor")
         public   Object   fetchAggregateData();
         
         
         // --------------------------------- Non-select Operations using  HQL/JPQL -----------------------------
         @Query( "update Doctor SET income=income+(income * :percentage/100.0) WHERE specialization=:sp")
         @Modifying
         @Transactional
         public  int   hikeDoctorsIncomeBySpecialization(String sp, double percentage);
         
         @Query( "DELETE FROM Doctor  WHERE income>=:start AND  income<=:end")
         @Modifying
         @Transactional
         public  int     removeDoctorsByIncomeRange(double start, double end);
         
         //-------------------------------  native SQL Queries -------------------------
         
         @Query(value = "INSERT INTO JPA_DOCTOR_INFO VALUES(DOCID_SEQ.NEXTVAL,:name,:income,:special)",nativeQuery =true)
         @Modifying
         @Transactional
         public  int   registerDoctor(String name, String special, double income );
         
         
         @Query(value="SELECT SYSDATE FROM DUAL",nativeQuery = true)
         public    String   showSystemDate();
         
         @Query(value="CREATE TABLE TEMP (col1 number(5))",nativeQuery = true)
         @Modifying
         @Transactional
         public  int  createTempTable();
         
		
		
}
