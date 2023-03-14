package com.swagger.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.swagger.entity.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, Integer> {

	
}
