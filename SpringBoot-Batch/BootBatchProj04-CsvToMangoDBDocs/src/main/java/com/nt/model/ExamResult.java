package com.nt.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Document(collection = "SuperBrains")
@NoArgsConstructor
@AllArgsConstructor
public class ExamResult {
	@Id
	private Integer id;
	private   String dob;
	private  Integer semester;
	private Float  percentage;

}
