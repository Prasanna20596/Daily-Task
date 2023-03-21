package com.security.multi.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.security.multi.model.User;

public interface UserRepository extends JpaRepository<User, Integer>{
	
	User findByUsername(String username);
	
}