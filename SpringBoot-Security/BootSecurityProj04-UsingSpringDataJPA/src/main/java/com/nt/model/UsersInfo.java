package com.nt.model;

import java.util.Set;

import javax.persistence.CollectionTable;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Table;

import lombok.Data;

@Table(name="Security_users")
@Entity
@Data
public class UsersInfo {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer unid;
	@Column(length = 30)
	private String uname;
	@Column(length = 100)
	private String pwd;
	@Column(length = 30)
	private String email;
	@Column(length = 2)
	private boolean status=true;
	
	@ElementCollection(fetch = FetchType.EAGER)
	@CollectionTable(name="SECURITY_ROLES",joinColumns = @JoinColumn(name="user_id",referencedColumnName ="unid" ))
	@Column(name="role")
	private  Set<String> roles;

}
