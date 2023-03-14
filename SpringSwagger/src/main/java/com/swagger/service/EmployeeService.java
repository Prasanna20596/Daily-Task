package com.swagger.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.swagger.entity.Employee;
import com.swagger.repository.EmployeeRepository;

@Service
public class EmployeeService {

	@Autowired
	private EmployeeRepository employeeRepository;
	
	public String addEmployee(Employee employee) {
		employeeRepository.save(employee);
		return "Saved Employee with id: "+employee.getId();
	}
	
	public List<Employee> viewEmployee(){
		return employeeRepository.findAll();
	}
	
	public Employee updateEmployeeById(Employee employee) {
		return employeeRepository.save(employee);
	}
	
	public String deleteEmployeeById(int id) {
	   employeeRepository.deleteById(id);
	   return "delete with id: "+id;
	}
}
