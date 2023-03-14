package com.oauth2.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HomeController {

	@GetMapping("/admin")
	public String forAdmin() {
		return "This page only access for admin";
	}
	
	@GetMapping("/user")
	public String forUser() {
		return "This page only access for user";
	}
}
