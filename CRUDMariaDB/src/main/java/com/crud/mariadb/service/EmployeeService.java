package com.crud.mariadb.service;

import java.util.List;

import com.crud.mariadb.entity.Employee;

public interface EmployeeService {

	Employee addEmployeeDetails(Employee employee);
	List<Employee> viewEmployees();
	Employee updateEmployeeDetails(Employee employee);
	void deleteEmployeeDetails(Employee employee);
	
}
