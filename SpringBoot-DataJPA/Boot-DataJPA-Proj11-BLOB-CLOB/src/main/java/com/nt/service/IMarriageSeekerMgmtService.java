package com.nt.service;

import com.nt.entity.MarriageSeeker;

public interface IMarriageSeekerMgmtService {
         public  String   saveMarriageSeeker(MarriageSeeker seeker);
         public   MarriageSeeker  findMarriageSeekerById(int id);
}
