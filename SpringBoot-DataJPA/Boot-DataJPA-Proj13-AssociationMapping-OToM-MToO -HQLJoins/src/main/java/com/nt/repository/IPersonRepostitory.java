package com.nt.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.nt.entity.Person;

public interface IPersonRepostitory extends JpaRepository<Person, Integer> {
        
	//@Query("SELECT p.pid,p.pname,p.paddrs,ph.regNo,ph.mobileNo,ph.provider,ph.numberType  from Person p inner join p.contactDetails  ph")
	//@Query("SELECT p.pid,p.pname,p.paddrs,ph.regNo,ph.mobileNo,ph.provider,ph.numberType  from Person p right join p.contactDetails  ph")
	@Query("SELECT p.pid,p.pname,p.paddrs,ph.regNo,ph.mobileNo,ph.provider,ph.numberType  from Person p full join p.contactDetails  ph")

	public   List<Object[]>  getDataUsingJoins();
}
