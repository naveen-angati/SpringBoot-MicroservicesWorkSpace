package com.nt.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.nt.entity.JobSeekerInfo;

public interface IJobSeekerInfoRepository extends JpaRepository<JobSeekerInfo, Integer> {
	 @Query("SELECT resumePath FROM JobSeekerInfo WHERE jsId=:id")
    public     String  getResumePathById(@Param("id") Integer id);
	 
	 @Query("SELECT photoPath FROM JobSeekerInfo WHERE jsId=:id")
	    public     String  getPhotoPathById(@Param("id") Integer id);
}
