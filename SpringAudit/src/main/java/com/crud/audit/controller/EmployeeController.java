package com.crud.audit.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.crud.audit.entity.Employee;
import com.crud.audit.service.EmployeeService;

@RestController
public class EmployeeController {

	@Autowired
	private EmployeeService employeeService;
	
	@PostMapping("/addemployee")
	public Employee addEmployeeDetails(@RequestBody Employee employee) {
		return employeeService.addEmployeeDetails(employee);
	}
	
	@GetMapping("/viewemployee")
	public List<Employee> viewEmployeeDetails(){
		return employeeService.getEmployeeDetails();
	}
	
	@PutMapping("/updateemployee/{empId}")
	public Employee updateEmployeeDetails(@PathVariable(value = "empId") int empId,
			                 @RequestBody Employee employee) {
		return employeeService.updateEmployeeDetails(empId, employee);
	}
	
	@DeleteMapping("/deleteemployee")
	public void deleteEmployeeDetails(@RequestBody Employee employee) {
		employeeService.deleteEmployee(employee);
	}

}
