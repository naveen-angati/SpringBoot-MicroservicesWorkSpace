//Doctor.java
package com.nt.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import jakarta.persistence.Transient;
import lombok.Data;

@Entity
@Table(name="JPA_DOCTOR_INFO")
@Data
public class Doctor {
	@Column(name="DOC_ID")
	@Id
	@SequenceGenerator(name="gen1",sequenceName = "DOCID_SEQ",initialValue = 1,allocationSize = 1)
	@GeneratedValue(generator = "gen1",strategy = GenerationType.SEQUENCE)
	//@GeneratedValue(strategy = GenerationType.AUTO)
	private  Integer  docId;
	@Column(name="DOC_NAME",length = 25)
	private  String  docName;
	@Column(name="SPECIALIZATION",length = 20)
    private  String  specialization;
	
	//@Transient
	@Column(name="INCOME")
	private  Double  income;
	//setters  &&  getters
	public Integer getDocId() {
		return docId;
	}
	public void setDocId(Integer docId) {
		this.docId = docId;
	}
	public String getDocName() {
		return docName;
	}
	public void setDocName(String docName) {
		this.docName = docName;
	}
	public String getSpecialization() {
		return specialization;
	}
	public void setSpecialization(String specialization) {
		this.specialization = specialization;
	}
	public Double getIncome() {
		return income;
	}
	public void setIncome(Double income) {
		this.income = income;
	}
	//toString
	@Override
	public String toString() {
		return "Doctor [docId=" + docId + ", docName=" + docName + ", specialization=" + specialization + ", income="
				+ income + "]";
	}
	
}
