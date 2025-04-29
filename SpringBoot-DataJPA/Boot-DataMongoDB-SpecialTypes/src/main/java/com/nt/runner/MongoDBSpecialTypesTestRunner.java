package com.nt.runner;

import java.util.List;
import java.util.Map;
import java.util.Properties;
import java.util.Random;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.nt.document.PlayerInfo;
import com.nt.service.IPlayerMgmtService;

@Component
public class MongoDBSpecialTypesTestRunner implements CommandLineRunner {
	@Autowired
	private  IPlayerMgmtService  playerService;

	@Override
	public void run(String... args) throws Exception {
		/*	//create PlayerInfo  object
			PlayerInfo info=new PlayerInfo();
			info.setPid(new Random().nextInt(10000));
			info.setPname("babu"); info.setNickNames(new String[] {"ra1j","king1","mahraj1"});
			info.setFriends(List.of("srinivas1","mahesh1","suresh1"));
			info.setPhoneNumbers(Set.of(9999999L,4553453535L,6645654664L));
			Properties  props=new Properties();
			props.put("Bat","SG"); props.put("Batting Pads", "SS1"); props.put("ball","kookbura1");
			info.setKitInfo(props);
			info.setIdDetails(Map.of("aadhar",45354354L,"voterId",5454355453L));
			try {
				System.out.println(playerService.registerPlayer(info));
			}
			catch(Exception e) {
				e.printStackTrace();
			}*/
		
		try {
			playerService.showAllPlayers().forEach(System.out::println);
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		

	}

}
