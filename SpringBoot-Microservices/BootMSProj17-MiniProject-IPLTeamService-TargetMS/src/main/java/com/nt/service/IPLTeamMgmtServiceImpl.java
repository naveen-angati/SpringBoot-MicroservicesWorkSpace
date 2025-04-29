package com.nt.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.netflix.discovery.converters.Auto;
import com.nt.entity.IPLTeam;
import com.nt.repository.IPLTeamRepository;

import lombok.extern.slf4j.Slf4j;

@Service("IPLTeamService")
@Slf4j
public class IPLTeamMgmtServiceImpl implements IPLTeamMgmtService {
	@Autowired
	private IPLTeamRepository teamRepo;

	@Override
	public String registerIPLTeam(IPLTeam team) {
		log.info("registerIPLTeam method (service)");
		int idVal=teamRepo.save(team).getTeamId();
		return "IPLTeam is saved with id value:"+idVal;
	}

	@Override
	public List<IPLTeam> getAllTeams() {
		log.info("getAllTeams method (service)");
		return  teamRepo.findAll();
	}

	@Override
	public IPLTeam getTeamById(int teamId) {
		log.info("getTeamById(-) method (service)");
		return teamRepo.findById(teamId).orElseThrow(()->new IllegalArgumentException("invalid team id"));
	}

}
