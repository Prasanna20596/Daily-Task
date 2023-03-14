package com.oauth2.service;

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
import com.oauth2.dao.UserInfoRepository;
import com.oauth2.entity.UserInfo;

@Service
public class UserDetailsServiceImple implements UserDetailsService{

	@Autowired
	UserInfoRepository userDetailsRepository;
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {	
		 UserInfo userInfo= userDetailsRepository.findByUsername(username);
		 if(userInfo==null) {
			   throw new UsernameNotFoundException("Invalid username and password");
		   }
			return new User(userInfo.getUsername(),userInfo.getPassword(),
					getAuthorities(userInfo));
		}

	private Collection<? extends GrantedAuthority> getAuthorities(UserInfo userLoginDetails) {
		List<SimpleGrantedAuthority> authorities = new ArrayList<>();
		authorities = Arrays.stream(userLoginDetails.getRoles().split(","))
        .map(SimpleGrantedAuthority::new)
        .collect(Collectors.toList());
		return authorities;
	}
}