package com.nt.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nt.document.Sport;

import com.nt.document.Player;
import com.nt.repository.IPlayerRepository;

@Service("RTAService")
public class PlayerMgmtServiceImpl implements IPlayerMgmtService {
	@Autowired
	private  IPlayerRepository  playerRepo;
	
	
	@Override
	public String registerPlayer(Player player) {
	    return " player with Sports info and MedalInfo is saved  with the id Value:"+playerRepo.insert(player).getPid();
	}

}
