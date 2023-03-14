package com.crud.mariadb.serviceimple;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.crud.mariadb.entity.Employee;
import com.crud.mariadb.repository.EmployeeRepository;
import com.crud.mariadb.service.EmployeeService;

@Service
public class EmployeeServiceImplem implements EmployeeService{

	@Autowired
	private EmployeeRepository employeeRepository;
	
	public Employee addEmployeeDetails(Employee employee) {
		return employeeRepository.save(employee);
	}

	public List<Employee> viewEmployees() {
		return employeeRepository.findAll();
	}

	public Employee updateEmployeeDetails(Employee employee) {
		return employeeRepository.save(employee);
	}

	public void deleteEmployeeDetails(Employee employee) {
		employeeRepository.delete(employee);
	}

}
