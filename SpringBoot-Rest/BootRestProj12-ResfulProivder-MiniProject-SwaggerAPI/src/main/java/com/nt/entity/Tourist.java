package com.nt.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

@Entity
@Table(name="REST_TOURIST_TAB")
@NoArgsConstructor
@AllArgsConstructor
@Data
@RequiredArgsConstructor
public class Tourist {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer tid;
	@Column(length = 20)
	@NonNull
	private  String  tname;
	@Column(length = 20)
	@NonNull
   private  String  place;
	@Column(length = 30)
	@NonNull
	private  String packageType;
	@NonNull
	private Double  budget;
}
