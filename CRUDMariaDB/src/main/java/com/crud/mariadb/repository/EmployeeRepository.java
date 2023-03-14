package com.crud.mariadb.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.crud.mariadb.entity.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, Integer>{

}
