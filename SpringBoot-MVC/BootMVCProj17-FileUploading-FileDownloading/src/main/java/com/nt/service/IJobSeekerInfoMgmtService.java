package com.nt.service;

import java.util.List;

import com.nt.entity.JobSeekerInfo;
import com.nt.model.JobSeeker;

public interface IJobSeekerInfoMgmtService {
    public  String registerJobSeeker(JobSeekerInfo jsInfo);
    public  List<JobSeekerInfo>  getAllJobSeekersInfo();
    
    public String findResumePathById(Integer id);
    public String findPhotoPathById(Integer id);
    
}
