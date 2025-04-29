package com.nt.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.nt.entity.Tourist;
import com.nt.service.ITouristMgmtService;

@RestController
@RequestMapping("/tourist-api")
public class ToursitOperationsController {
	@Autowired
	private ITouristMgmtService  touristService;
	
	@PostMapping("/register")
	public  ResponseEntity<String> registerTourist(@RequestBody Tourist tourist){
		try {
		//use serivce
		String resultMsg=touristService.registerTourist(tourist);
		return new ResponseEntity<String>(resultMsg, HttpStatus.CREATED);
		}
		catch(Exception e) {
			return new ResponseEntity<String>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@GetMapping("/report")
	public  ResponseEntity<?>  showAllTourists(){
		try {
			//use service
			List<Tourist> list=touristService.getAllTourists();
			return new ResponseEntity<List<Tourist>>(list,HttpStatus.OK);
		}
		catch(Exception e) {
			return new ResponseEntity<String>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@GetMapping("/find/{id}")
	public  ResponseEntity<?>  findTouristById(@PathVariable("id") int id){
		try {
			//use service
			Tourist tourist=touristService.getTouristById(id);
			return new ResponseEntity<Tourist>(tourist,HttpStatus.OK);
		}
		catch(Exception e) {
			return new ResponseEntity<String>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@GetMapping("/findWithName/{name}")
	public  ResponseEntity<?>  findToursistsByName(@PathVariable("name") String name){
		try {
			//use service
			List<Tourist> tourist=touristService.findAllTouristsByName(name);
			return new ResponseEntity<List<Tourist>>(tourist,HttpStatus.OK);
		}
		catch(Exception e) {
			return new ResponseEntity<String>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}//method
	
	@PutMapping("/modify")
	public  ResponseEntity<?>   modifyTouristDetails(@RequestBody Tourist tourist){
		
		try {
			//use service
			String resultMsg=touristService.updateTouristDetails(tourist);
			return  new ResponseEntity<String>(resultMsg,HttpStatus.OK);
		}
		catch(Exception e) {
			return  new ResponseEntity<String>(e.getMessage(),HttpStatus.INTERNAL_SERVER_ERROR);
		}
		
	}//method
	
	@PatchMapping("/pupdate/{id}/{percentage}")
	public  ResponseEntity<?>   modifyTouristBudgetDetailsById(@PathVariable("id") int id, 
			                                                                                                      @PathVariable("percentage") double percentage){
		
		try {
			//use service
			String resultMsg=touristService.updateTouristBudgetById(id, percentage);
			return  new ResponseEntity<String>(resultMsg,HttpStatus.OK);
		}
		catch(Exception e) {
			return  new ResponseEntity<String>(e.getMessage(),HttpStatus.INTERNAL_SERVER_ERROR);
		}
		
	}//method
	
	
	@DeleteMapping("/delete/{id}")
	public  ResponseEntity<?>  deleteTouristById(@PathVariable("id") int id){
		try {
			//use service
			String resultMsg=touristService.removeTouristById(id);
			return  new ResponseEntity<String>(resultMsg,HttpStatus.OK);
		}
		catch(Exception e) {
			return  new ResponseEntity<String>(e.getMessage(),HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	

	@DeleteMapping("/delete/{start}/{end}")
	public  ResponseEntity<?>  deleteTouristByBudgetRange(@PathVariable("start") double start,
			                                                                                          @PathVariable ("end") double end){
		try {
			//use service
			String resultMsg=touristService.removeTouristsByBudgetRange(start, end);
			return  new ResponseEntity<String>(resultMsg,HttpStatus.OK);
		}
		catch(Exception e) {
			return  new ResponseEntity<String>(e.getMessage(),HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	
}
