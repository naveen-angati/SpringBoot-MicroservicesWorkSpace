package com.nt.runner;

import java.time.LocalDate;
import java.util.Map;
import java.util.Random;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.nt.document.Medal;
import com.nt.document.Player;
import com.nt.document.Sport;
import com.nt.service.IPlayerMgmtService;


@Component
public class OneToManyAssociationTestRunner implements CommandLineRunner {
	@Autowired
	private IPlayerMgmtService  playerService;

	@Override
	public void run(String... args) throws Exception {
		//save object using parent
		try {
			//parent object
		      Player player=new Player();
		      player.setPid(new Random().nextInt(10000));  player.setPname("raja"); player.setPaddrs("hyd");
			//child1 objects
			Sport sport1=new Sport();
			sport1.setSid(new Random().nextInt(10));  sport1.setType("Batminton");  sport1.setKitItems(new String[] {"cock","bat","net"});
			Sport sport2=new Sport();
			sport2.setSid(new Random().nextInt(20));  sport2.setType("Tennis");  sport2.setKitItems(new String[] {"ball","bat","net"});
			
			//child2 objs
			Medal  m1=new Medal();
			m1.setMid(1001); m1.setMname("Gold-Batminton");  m1.setEvent("World Championship"); m1.setPlace("newyork");
			Medal  m2=new Medal();
			m2.setMid(1002); m2.setMname("Silver-Tennis");  m2.setEvent("World Championship"); m2.setPlace("tokyo");
			
			//perform associations
			  player.setSports(Set.of(sport1,sport2));
			  player.setMedals(Map.of("Gold",m1,"silver",m2));
			//use service
			System.out.println(playerService.registerPlayer(player));
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		

		

	}//method

}//class
