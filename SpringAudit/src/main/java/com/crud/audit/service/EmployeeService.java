package com.crud.audit.service;

import java.util.List;

import com.crud.audit.entity.Employee;

public interface EmployeeService {

	Employee addEmployeeDetails(Employee employee);
	List<Employee> getEmployeeDetails();
	Employee updateEmployeeDetails(int empId, Employee employee);
	void deleteEmployee(Employee employee);
	
}
