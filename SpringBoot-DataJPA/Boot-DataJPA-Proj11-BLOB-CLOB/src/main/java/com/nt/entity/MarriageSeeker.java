package com.nt.entity;

import java.io.Serializable;
import java.time.LocalDateTime;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Lob;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

@Entity
@Table(name="LOB_MARRIAGE_SEEKER")
@Data
@NoArgsConstructor
@RequiredArgsConstructor
@AllArgsConstructor
public class MarriageSeeker implements Serializable {
	@Id
	@GeneratedValue
	private Integer msId;
	
	@Column(length = 20)
	@NonNull
	private  String msName;
	
	@Column(length = 20)
	@NonNull
	private  String msAddrs;
	
	@NonNull
	private  boolean indian;
	@NonNull
	private LocalDateTime  dob;
	@NonNull
	@Lob
	private  byte[]  msPhoto;
	@NonNull
	@Lob
	private   char[]  msResume;

}
