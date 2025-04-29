package com.nt.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.nt.entity.Tourist;

import jakarta.transaction.Transactional;

public interface ITouristRepository extends JpaRepository<Tourist, Integer> {
	
	@Query(" from Tourist where tname=:name")
	public List<Tourist>   getTouristsByName(@Param("name") String name);
	
	
	@Query(" delete from Tourist where budget>=:start and budget<=:end")
	@Modifying
	@Transactional
	public  int   removeTouristsByBudgetRange(double start,double end);

}
