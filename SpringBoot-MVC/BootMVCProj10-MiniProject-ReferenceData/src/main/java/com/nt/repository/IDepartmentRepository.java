package com.nt.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.nt.Entity.Department;

public interface IDepartmentRepository extends JpaRepository<Department, Integer> {
	
	@Query("SELECT deptno from Department")
	public  List<Integer>  getAllDeptnos();

}
