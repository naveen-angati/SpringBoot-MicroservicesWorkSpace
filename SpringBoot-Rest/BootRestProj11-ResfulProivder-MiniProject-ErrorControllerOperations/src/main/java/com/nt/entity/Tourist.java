package com.nt.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
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
