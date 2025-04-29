//JobSeekerInfo.java
package com.nt.model;

import org.springframework.web.multipart.MultipartFile;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Data
public class JobSeeker {
	private String  jsName;
	private  String jsAddrs;
	private MultipartFile  resume;
	private MultipartFile  photo;
	

}
