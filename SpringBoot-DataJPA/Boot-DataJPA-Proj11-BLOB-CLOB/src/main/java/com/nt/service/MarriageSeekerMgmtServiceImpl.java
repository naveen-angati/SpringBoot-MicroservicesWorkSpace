package com.nt.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nt.entity.MarriageSeeker;
import com.nt.repository.IMarriageSeekerRepository;

@Service("marriageService")
public class MarriageSeekerMgmtServiceImpl implements IMarriageSeekerMgmtService {
	@Autowired
	private  IMarriageSeekerRepository  msRepo;

	@Override
	public String saveMarriageSeeker(MarriageSeeker seeker) {
		int idVal=msRepo.save(seeker).getMsId();
		return "Marriage Seeker is registered with the id value ::"+idVal;
	}

	@Override
	public MarriageSeeker findMarriageSeekerById(int id) {
	     
		return msRepo.findById(id).orElseThrow(()-> new IllegalArgumentException());
	}

}
