package com.oauth2.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import com.oauth2.dao.UserInfoRepository;
import com.oauth2.entity.UserInfo;

@Service
public class UserInfoService {
	
	@Autowired
	UserInfoRepository userDetailsRepository;
	
	public UserInfo saveUserDetails(UserInfo userLoginDetails) {
		userLoginDetails.setPassword(new BCryptPasswordEncoder().encode(userLoginDetails.getPassword()));
		return userDetailsRepository.save(userLoginDetails);
	}
	
	public List<UserInfo> viewAllUserDetails(){
		return userDetailsRepository.findAll();
	}
	
	public void deleteUserDetails(UserInfo userLoginDetails) {
		userDetailsRepository.delete(userLoginDetails);
	}

}
