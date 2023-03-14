package com.tcm.springsecurity.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.tcm.springsecurity.model.UserLoginDetails;

public interface UserDetailsRepository extends JpaRepository<UserLoginDetails, Integer>{
	
	UserLoginDetails findByUserName(String userName);
	
}