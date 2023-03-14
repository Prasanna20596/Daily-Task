package com.tcm.springsecurity.service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import com.tcm.springsecurity.model.UserLoginDetails;
import com.tcm.springsecurity.repository.UserDetailsRepository;

@Service
public class MyUserDetailsService implements UserDetailsService{

	@Autowired
	UserDetailsRepository userDetailsRepository;
	
	@Override
	public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException {	
		UserLoginDetails userLoginDetails= userDetailsRepository.findByUserName(userName);
		if (userLoginDetails == null) {
			throw new UsernameNotFoundException("Invalid username and password");
		}
		return new User(userLoginDetails.getUserName(), userLoginDetails.getUserPassword(), 
				   getAuthorities(userLoginDetails));
	}

	private Collection<? extends GrantedAuthority> getAuthorities(UserLoginDetails userLoginDetails) {
		List<SimpleGrantedAuthority> authorities = new ArrayList<>();
		authorities = Arrays.stream(userLoginDetails.getRoles().split(",")).map(SimpleGrantedAuthority::new)
				.collect(Collectors.toList());
		return authorities;

	}

}