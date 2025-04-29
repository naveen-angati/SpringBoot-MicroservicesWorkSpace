package com.nt.service;

import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.nt.model.UsersInfo;
import com.nt.repository.IUserOperationsRepository;

@Service("userService")
public class UserInfoMgmtServiceImpl implements IUserInfoMgmtService {
	@Autowired
	private IUserOperationsRepository userRepo;
	@Autowired
	private BCryptPasswordEncoder   passwordEncoder;
	
	
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		//get  User Details by Username
		 UsersInfo info=userRepo.findByUname(username);
		 //convert UserInfo obj data to  User object  of spring security
		 User user=new User(info.getUname(),info.getPwd(),info.getRoles().stream().map(role->new SimpleGrantedAuthority(role)).collect(Collectors.toSet()));
		return user;
	}

	@Override
	public String registerUser(UsersInfo user) {
		user.setPwd(passwordEncoder.encode(user.getPwd()));
		//save the object
		int idVal=userRepo.save(user).getUnid();
		return "User is registered with the id value::"+idVal;
	}

}
