package com.example.keycloak.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class EmployeeController {

	@GetMapping("/login")
	public String index() {
		return "Welcome to login Screen";
	}

	@GetMapping("/homepage")
	public String homepage() {
		return "Welcome to homepage";
	}

}
