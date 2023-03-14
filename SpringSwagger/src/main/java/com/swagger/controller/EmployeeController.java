package com.swagger.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.swagger.entity.Employee;
import com.swagger.service.EmployeeService;
import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("/employee")
public class EmployeeController {

	@Autowired
	private EmployeeService employeeService;
	
	@PostMapping("/save")
	@ApiOperation(value = "It is saving new Employee")
	public String addEmployee(Employee employee) {
		return employeeService.addEmployee(employee);
	}
	
	@GetMapping("/view")
	@ApiOperation(value = "It is view all employee")
	public List<Employee> viewEmployees(){
		return employeeService.viewEmployee();
	}
	
	@PutMapping("/update")
	@ApiOperation(value = "It is update the details on old employee")
	public Employee updateEmployeeById(Employee employee) {
		return employeeService.updateEmployeeById(employee);
	}
	
	@DeleteMapping("/delete")
	@ApiOperation(value="It is deleting the employee")
	public String deleteEmployeeById(int id) {
		return employeeService.deleteEmployeeById(id);
	}
}
