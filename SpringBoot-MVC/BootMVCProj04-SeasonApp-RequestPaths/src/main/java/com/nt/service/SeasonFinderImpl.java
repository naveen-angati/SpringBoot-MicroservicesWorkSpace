package com.nt.service;

import java.time.LocalDateTime;

import org.springframework.stereotype.Service;

@Service("sfService")
public class SeasonFinderImpl implements ISeasonFinder {
	

	@Override
	public String findSeason() {
		//get current date and time
		  LocalDateTime  ldt=LocalDateTime.now();
		  //get current month of the year
		  int month=ldt.getMonthValue();  //gives  1-12
		  //generate the season name
		  if(month>=3 && month<=6)
			  return  "Summer Season";
		  else if(month>=7 && month<=10)
			  return "Rainy Season";
		  else
			  return  "Winter Season";
		}

}
