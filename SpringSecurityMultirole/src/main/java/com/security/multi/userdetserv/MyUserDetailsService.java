package com.security.multi.userdetserv;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.DisabledException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import com.security.multi.model.User;
import com.security.multi.repository.UserRepository;

@Service
public class MyUserDetailsService implements UserDetailsService{

	@Autowired
	UserRepository userDetailsRepository;
	
	@Autowired
	AuthenticationManager authenticationManager;

	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		User user = userDetailsRepository.findByUsername(username);
		if (user != null) {
			return new org.springframework.security.core.userdetails.User(user.getUsername(), 
					user.getPassword(),getAuthorities(user));
		} else {
			throw new UsernameNotFoundException("User not found with username: " + username);
		}
	}

	private Collection<? extends GrantedAuthority> getAuthorities(User user) {
		List<SimpleGrantedAuthority> authorities = new ArrayList<>();
		authorities = Arrays.stream(user.getRole().split(",")).map(SimpleGrantedAuthority::new)
				.collect(Collectors.toList());
		return authorities;
	}
	
	private void authenticate(String username,String password) throws Exception {
		try {
			authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(username,password));
		} catch (DisabledException e) {
			throw new Exception("USER DISABLED", e);
		}catch (BadCredentialsException e) {
			throw new Exception("INVALID CRETENTIAL",e);
		}
	}

	public String getRoleBasedURL(User user) throws Exception {
		String username=user.getUsername();
		String password=user.getPassword();
		authenticate(username, password);
		user=userDetailsRepository.findByUsername(username);
		String role=user.getRole();
		return role;
	}
	
//	public String getRoleBasedURL(User user) throws Exception {
//		String username = user.getUsername();
//		String password = user.getPassword();
//		user = userDetailsRepository.findByUsername(username);
//		String role = user.getRole();
//		return role;
//	}

}