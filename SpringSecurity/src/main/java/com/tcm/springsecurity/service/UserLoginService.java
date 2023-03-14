package com.tcm.springsecurity.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.tcm.springsecurity.model.UserLoginDetails;
import com.tcm.springsecurity.repository.UserDetailsRepository;

@Service
public class UserLoginService {
	
	@Autowired
	UserDetailsRepository userDetailsRepository;
	
	PasswordEncoder passwordEncoder;
	
    public UserLoginService(UserDetailsRepository userDetailsRepository, PasswordEncoder passwordEncoder) {
	   this.userDetailsRepository = userDetailsRepository;
	   this.passwordEncoder = passwordEncoder;
	}
    
	public UserLoginDetails saveUserLoginDetails(UserLoginDetails userLoginDetails) {
		userLoginDetails.setUserPassword(this.passwordEncoder.encode(userLoginDetails.getUserPassword()));
		return this.userDetailsRepository.save(userLoginDetails);
	}
	

}
