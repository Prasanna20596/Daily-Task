package com.oauth2.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import com.oauth2.entity.UserInfo;
import com.oauth2.service.UserInfoService;

@RestController
public class UserController {

	@Autowired
	private UserInfoService userInfoService;
	
	@PostMapping("/adduser")
	public String addUserDetails(@RequestBody UserInfo userLoginDetails) {
		userInfoService.saveUserDetails(userLoginDetails);
		return "User added";
	}
	
	@GetMapping("/viewusers")
	public List<UserInfo> viewAllUserDetails(){
		List<UserInfo> userInfo=userInfoService.viewAllUserDetails();
		return userInfo;
	}
	
	@PutMapping("/updateuser")
	public String updateUserDerails(@RequestBody UserInfo userLoginDetails) {
		userInfoService.saveUserDetails(userLoginDetails);
		return "User details is updated";
	}
	
	@DeleteMapping("/deleteuser")
	public String deleteUserDetails(@RequestBody UserInfo userLoginDetails) {
		userInfoService.deleteUserDetails(userLoginDetails);
		return "User details is updated";
	}
		
}
