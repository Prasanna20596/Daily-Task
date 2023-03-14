package com.tcm.springsecurity.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.tcm.springsecurity.model.UserLoginDetails;
import com.tcm.springsecurity.service.UserLoginService;

@CrossOrigin(origins = "http://localhost:3001")
@RestController
public class PageSecurityController {

	@Autowired
	private UserLoginService userLoginService;

	@GetMapping("/user")
	public String user() {
		return "Welcome User";
	}
	
	@GetMapping("/admin")
	public String admin() {
		return "Welcome Admin";
	}
	
	@PostMapping("/addlogin")
	public UserLoginDetails addLoginDerails(@RequestBody UserLoginDetails userLoginDetails) {
		return userLoginService.saveUserLoginDetails(userLoginDetails);
	}
	
}
