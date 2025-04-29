package com.nt.service;

import com.nt.document.DrivingLicense;
import com.nt.document.Person;

public interface IRTAMgmtService {
     public    String  registerPerson(Person person);
     public   String  registerDrivingLicense(DrivingLicense license);
}
