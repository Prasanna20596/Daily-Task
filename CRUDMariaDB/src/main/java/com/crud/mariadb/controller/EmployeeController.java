package com.crud.mariadb.controller;

import java.util.List;

import javax.persistence.GeneratedValue;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.crud.mariadb.entity.Employee;
import com.crud.mariadb.service.EmployeeService;

@RestController
public class EmployeeController {

	@Autowired
	private EmployeeService employeeService;
	
	@PostMapping("/addemployee")
	public Employee addEmployeeDetails(@RequestBody Employee employee) {
		return employeeService.addEmployeeDetails(employee);
	}
	
	@GetMapping("/viewemployee")
	public List<Employee> viewEmployees(){
		return employeeService.viewEmployees();
	}
	
	@PutMapping("/updateemployee")
	public Employee updateEmployeeDetails(@RequestBody Employee employee) {
		return employeeService.updateEmployeeDetails(employee);
	}
	
	@DeleteMapping("/deleteemployee")
	public void deleteEmployeeDetails(@RequestBody Employee employee) {
		employeeService.deleteEmployeeDetails(employee);
	}
	
}
