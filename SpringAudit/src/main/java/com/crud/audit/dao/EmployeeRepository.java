package com.crud.audit.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import com.crud.audit.entity.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, Integer> {

}
