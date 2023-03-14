package com.jwt.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import com.jwt.entity.User;

public interface UserDao extends JpaRepository<User, Integer> {
	
	User findByUserName(String userName);
	
}
