package com.nt.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nt.entity.JobSeekerInfo;
import com.nt.model.JobSeeker;
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

	@Override
	public List<JobSeekerInfo> getAllJobSeekersInfo() {
		return jsRepo.findAll();
	}

	@Override
	public String findResumePathById(Integer id) {
		return jsRepo.getResumePathById(id);
	}

	@Override
	public String findPhotoPathById(Integer id) {
		return jsRepo.getPhotoPathById(id);
	}

}
