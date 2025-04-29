package com.nt.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nt.entity.Tourist;
import com.nt.error.TouristNotFoundException;
import com.nt.repository.ITouristRepository;

@Service("touristService")
public class TouristMgmtServiceImpl implements ITouristMgmtService {
	@Autowired
	private ITouristRepository touristRepo;

	@Override
	public String registerTourist(Tourist toursit) {
		  //use repo
		int idVal=touristRepo.save(toursit).getTid();
		return "tourist is saved with the id Value ::"+idVal;
	}

	@Override
	public List<Tourist> getAllTourists() {
		  //use repo
		List<Tourist> list=touristRepo.findAll();
		list.sort((t1,t2)->t1.getTid().compareTo(t2.getTid()));  //sorting
		return list;	
		}

	@Override
	public Tourist getTouristById(int id) throws TouristNotFoundException {
		//use repo
		 Tourist tourist=touristRepo.findById(id).orElseThrow(()->new TouristNotFoundException("Tourist with "+id+" is not avaiable"));
		return tourist;
	}

	@Override
	public List<Tourist> findAllTouristsByName(String name) {
		//use repo
		return touristRepo.getTouristsByName(name);
	}

	@Override
	public String updateTouristDetails(Tourist tourist) throws TouristNotFoundException {
		Optional<Tourist> trst=touristRepo.findById(tourist.getTid());
		if(trst.isPresent()) {
			touristRepo.save(tourist);
			return  "Torusit is updated with new details";
		}
		else {
		  throw new TouristNotFoundException(tourist.getTid()+"  is not found  for updation");	
		}
		
	}//method

	@Override
	public String updateTouristBudgetById(int tid, double hikePercentage)throws TouristNotFoundException {
		//get  the Tourist by id
		Optional<Tourist> opt=touristRepo.findById(tid);
		if(opt.isPresent()) {
			//get  existing budget of the Toursit
			Tourist tourist=opt.get();
			double budget=tourist.getBudget();
			double newBudget=budget+ (budget*hikePercentage/100.0);
			//update  Toursit with new Budget
			tourist.setBudget(newBudget);
			touristRepo.save(tourist);
			return " Toursit budget is hiked ...and the new budget is"+newBudget;
		}
		else {
			 throw new TouristNotFoundException(tid+" tid  tourist is not found for updation");
		}
		
	
	}//method
	
	@Override
	public String removeTouristById(int id) throws TouristNotFoundException {
		//get  the Tourist by id
		Optional<Tourist> opt=touristRepo.findById(id);
		if(opt.isPresent()) {
		       //use repo
			touristRepo.deleteById(id);
			return id+" tid Tourist found and deleted"; 
		}
		else {
			 throw new TouristNotFoundException(id+" tid  tourist is not found for deletion");
		}
	}

	@Override
	public String removeTouristsByBudgetRange(double start, double end) {
		   //use  repo
		 int count=touristRepo.removeTouristsByBudgetRange(start, end);
		 
		return count==0?" Tourists not found for deletion":count+" no.of Tourists are found and deleted";
	}

}//class
