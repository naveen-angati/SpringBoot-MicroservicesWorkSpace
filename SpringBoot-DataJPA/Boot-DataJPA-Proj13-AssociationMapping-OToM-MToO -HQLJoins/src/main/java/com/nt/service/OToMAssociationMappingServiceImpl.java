//service Impl class
package com.nt.service;

import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nt.entity.Person;
import com.nt.entity.PhoneNumber;
import com.nt.repository.IPersonRepostitory;
import com.nt.repository.IPhoneNumberRepository;

@Service("OToMService")
public class OToMAssociationMappingServiceImpl implements IOToMAssociationMgmtService {
	@Autowired
   private  IPersonRepostitory  personRepo;
	@Autowired
	private  IPhoneNumberRepository  phoneRepo;
	
	
	@Override
	public List<Object[]> fetchDataUsingJoins() {
		
		return personRepo.getDataUsingJoins();
	}



}//class
