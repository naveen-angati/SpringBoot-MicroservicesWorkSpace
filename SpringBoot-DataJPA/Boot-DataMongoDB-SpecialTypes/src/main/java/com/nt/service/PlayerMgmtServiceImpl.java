package com.nt.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nt.document.PlayerInfo;
import com.nt.repository.PlayerInfoRepository;

@Service("playerService")
public class PlayerMgmtServiceImpl implements IPlayerMgmtService {
	@Autowired
	private PlayerInfoRepository playerRepo;

	@Override
	public String registerPlayer(PlayerInfo player) {
		int idVal=playerRepo.insert(player).getPid();
		return "Player is saved with the id Value:"+idVal;
	}

	@Override
	public List<PlayerInfo> showAllPlayers() {
		return playerRepo.findAll();
	}

}
