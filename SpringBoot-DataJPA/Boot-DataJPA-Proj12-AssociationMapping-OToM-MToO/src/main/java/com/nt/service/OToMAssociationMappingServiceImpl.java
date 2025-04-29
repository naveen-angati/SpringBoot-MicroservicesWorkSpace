//service Impl class
package com.nt.service;

import java.util.HashSet;
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
	public void saveDataUsingParent() {
	   //create Parent object
		 Person per=new Person("raja", "hyd");
		 //create child objects
		PhoneNumber ph1=new PhoneNumber(9999999L, "airtel", "personal");
		PhoneNumber ph2=new PhoneNumber(88888888L, "vi", "office");
	    
		//add parent to child
		ph1.setPersonInfo(per); ph2.setPersonInfo(per);
		
		 //add  childs to parent
		Set<PhoneNumber> phonesSet=new HashSet();
		phonesSet.add(ph1); phonesSet.add(ph2);
		per.setContactDetails(phonesSet);
		
		//save the parent object
		personRepo.save(per);
		System.out.println("Person and his associated phoneNumbers are saved(parent to child)");
	}//method

	@Override
	public void saveDataUsingChild() {
		 //create Parent object
		 Person per=new Person("ramesh", "vizag");
		 //create child objects
		PhoneNumber ph1=new PhoneNumber(88888888L, "airtel", "personal");
		PhoneNumber ph2=new PhoneNumber(77777777L, "vi", "office");
	    
		//add parent to child
		ph1.setPersonInfo(per); ph2.setPersonInfo(per);
		
		 //add  childs to parent
		Set<PhoneNumber> phonesSet=new HashSet();
		phonesSet.add(ph1); phonesSet.add(ph2);
		per.setContactDetails(phonesSet);
		
		//save the parent object
		phoneRepo.save(ph1); phoneRepo.save(ph2);
		System.out.println("Person and his associated phoneNumbers are saved(child to parent)");
		
	}

	@Override
	public void loadDataUsingParent() {
           Iterable<Person> it=personRepo.findAll();
           it.forEach(per->{
        	   System.out.println("parent::"+per);
        	   //get childs of each parent
				/* Set<PhoneNumber> childs=per.getContactDetails();
				 System.out.println("childs count ::"+childs.size());*/
				/*  childs.forEach(ph->{
				   System.out.println("child ::"+ph.getMobileNo());
				  });*/
        	   
           });

		
	}

	@Override
	public void deleteDataUsingParentById(int id) {
		// Load parent object by Id
		Optional<Person> opt=personRepo.findById(id);
		if(opt.isPresent()) {
			Person per=opt.get();
			personRepo.delete(per);
			System.out.println("Parent and the associated child objects are deleted");
		}
		else {
			System.out.println(id+" person not found for deletion");
		}
	}//method
	
	@Override
	public void deleteAllChildsOfAPrentById(int id) {
		// Load parent object by Id
		Optional<Person> opt=personRepo.findById(id);
		if(opt.isPresent()) {
			Person per=opt.get();
		     //get  all childs of  a Person
			Set<PhoneNumber> childs=per.getContactDetails();
			//remove parent link from  childs
			childs.forEach(ph->{
				ph.setPersonInfo(null);
			});
			//delete all child objs
			phoneRepo.deleteAll(childs);
			
			System.out.println("Only the childs of a Parent  are deleted");
		}
		else {
			System.out.println(id+" person not found for deletion");
		}
		
	}//method
	
	@Override
	public void addNewChildToAParentById(int id) {
		  //Load parent object
		Optional<Person> opt=personRepo.findById(id);
		if(opt.isPresent()) {
			Person per=opt.get();
			//get childs of a Parent
			Set<PhoneNumber> childs=per.getContactDetails();
			//create the new child object
			PhoneNumber ph=new PhoneNumber(7777777L, "vodafone","personal");
			//link  child to parent
			ph.setPersonInfo(per);
			childs.add(ph);
			phoneRepo.save(ph);
			System.out.println("New Child is added to the existing childs of a Parent");
		}
		else {
			System.out.println(id+" person not found for operation");
		}
		
		
	}//method

}//class
