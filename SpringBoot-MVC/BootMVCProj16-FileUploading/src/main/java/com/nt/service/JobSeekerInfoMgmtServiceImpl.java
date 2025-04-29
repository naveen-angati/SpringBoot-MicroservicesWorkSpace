package com.nt.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nt.entity.JobSeekerInfo;
import com.nt.repository.IJobSeekerInfoRepository;

@Service("jsService")
public class JobSeekerInfoMgmtServiceImpl implements IJobSeekerInfoMgmtService {
	@Autowired
	private IJobSeekerInfoRepository jsRepo;

	@Override
	public String registerJobSeeker(JobSeekerInfo jsInfo) {
		int idVal=jsRepo.save(jsInfo).getJsId();
		return  "Job seeker is registered with id Value ::"+idVal;
	}

}
