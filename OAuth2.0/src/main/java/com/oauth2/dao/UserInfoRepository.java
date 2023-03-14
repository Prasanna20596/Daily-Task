package com.oauth2.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import com.oauth2.entity.UserInfo;

public interface UserInfoRepository extends JpaRepository<UserInfo, Integer>{
	
	UserInfo findByUsername(String username);
	
}