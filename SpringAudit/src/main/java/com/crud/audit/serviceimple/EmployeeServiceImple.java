package com.crud.audit.serviceimple;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.crud.audit.dao.EmployeeRepository;
import com.crud.audit.entity.Employee;
import com.crud.audit.service.EmployeeService;

@Service
public class EmployeeServiceImple implements EmployeeService {

	@Autowired
	private EmployeeRepository empRepo;
	
	public Employee addEmployeeDetails(Employee employee) {
	    return empRepo.save(employee);	
	}

	public List<Employee> getEmployeeDetails() {
		return empRepo.findAll();
	}

	public Employee updateEmployeeDetails(int empId, Employee employee) {
		Employee findEmployee=empRepo.findById(empId).get();
		findEmployee.setName(employee.getName());
		findEmployee.setMobileNo(employee.getMobileNo());
		findEmployee.setEmail(employee.getEmail());
		findEmployee.setSalary(employee.getSalary());
		Employee updateEmployee=empRepo.save(findEmployee);
		return updateEmployee;
	}

	public void deleteEmployee(Employee employee) {
		empRepo.delete(employee);
	}

}
