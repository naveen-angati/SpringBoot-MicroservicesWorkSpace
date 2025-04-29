//ActorOperationsController.java
package com.nt.rest;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.nt.model.Actor;

@RestController
@RequestMapping("/actor-api")
public class ActorOperationsController {
	
	@GetMapping("/wish")
	public ResponseEntity<String>  sendWishMessage(){
		
		return new  ResponseEntity<String>("Good Morning::",HttpStatus.OK);
		
	}
	
	@GetMapping("/wish/{id}/{name}/{addrs}")
	public ResponseEntity<String>  sendWishMessage1(@PathVariable("name") String name,
			                                                                                  @PathVariable("id") Integer id,
			                                                                                  @PathVariable("addrs") String addrs){
		
		return new  ResponseEntity<String>("Good Morning::"+name+" "+id+" "+addrs,HttpStatus.OK);
		
	}
	
	@PostMapping("/register")
	public     ResponseEntity<String> registerActor(@RequestBody Actor actor){
		
		return new ResponseEntity<String>(actor.toString()+" is registered",HttpStatus.CREATED);
	}
	
	@GetMapping("/report")
	public    ResponseEntity<Actor>  reportActorData(){
		 Actor actor=new Actor(1001,"raja","hyd",80000.0f);
		return new ResponseEntity<Actor>(actor, HttpStatus.OK);
	}
	
	@GetMapping("/reportAll")
	public   ResponseEntity<List<Actor>>  reportAllActorsData(){
		List<Actor> list=List.of(new Actor(111,"rajesh","hyd",54545.7f),
				                               new Actor(112,"suresh","vizag",454566.6f));
		return new ResponseEntity<List<Actor>>(list,HttpStatus.OK);
		
	}
  
}
