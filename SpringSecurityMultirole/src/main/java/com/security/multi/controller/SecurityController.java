package com.security.multi.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import com.security.multi.model.User;
import com.security.multi.pojo.RequestPojo;
import com.security.multi.service.UserService;
import com.security.multi.userdetserv.MyUserDetailsService;

@RestController
@CrossOrigin(origins = "http://localhost:3000", allowedHeaders = "*",methods = {RequestMethod.GET,RequestMethod.POST})
public class SecurityController {

	@Autowired
	private UserService userService;
	
	@Autowired
	MyUserDetailsService myUserDetailsService;
	
	@RequestMapping("/signin")
	public String getRoleBasedHome(@RequestBody User user) throws Exception {
		return myUserDetailsService.getRoleBasedURL(user);
	}
	
	
	@GetMapping("/superadmin")
	public String getSuperAdminHome() {
		return "Welcome Super Admin";
	}
	
	@GetMapping("/tenantadmin")
	public String getTenantAdminHome() {
		return "Welcome Tenant Admin";
	}
	
	@GetMapping("/deptadmin")
	public String getDeptAdminHome() {
		return "Welcome Dept Admin";
	}
	
	@GetMapping("/employee")
	public String getEmployeeHome() {
		return "Welcome Employee";
	}

	@PostMapping("/addtenant")
	public String addTenantDetails(@RequestBody RequestPojo requestPojo) {
		return userService.saveTenantDetails(requestPojo);
	}
	
	@PostMapping("/adddeptmaster")
	public String addDeptMasterDetails(@RequestBody RequestPojo requestPojo) {
		return userService.saveDeptMaster(requestPojo);
	}
	
	@PostMapping("/addemployee")
	public String addEmployeeDetails(@RequestBody RequestPojo requestPojo) {
		return userService.saveEmployeeDetails(requestPojo);
	}
	
	@PostMapping("/addleave")
	public String requestLeave(@RequestBody RequestPojo requestPojo) {
		return userService.requestLeave(requestPojo);
	}
	
	@PostMapping("/addattendance")
	public String addAttendance(@RequestBody RequestPojo requestPojo) {
		return userService.addAttendance(requestPojo);
	}
	
	@GetMapping("/viewleave")
	public List<Object> viewLeaveList(){
		return userService.getLeaveList();
	}

	@GetMapping("/viewattendance")
	public List<Object> viewattendanceList(){
		return userService.getAttendanceList();
	}
	
}
