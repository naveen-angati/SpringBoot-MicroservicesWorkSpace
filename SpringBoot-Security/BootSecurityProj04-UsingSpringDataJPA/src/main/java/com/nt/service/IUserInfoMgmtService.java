package com.nt.service;

import org.springframework.security.core.userdetails.UserDetailsService;

import com.nt.model.UsersInfo;

public interface IUserInfoMgmtService extends UserDetailsService {
       public  String registerUser(UsersInfo user);
}
