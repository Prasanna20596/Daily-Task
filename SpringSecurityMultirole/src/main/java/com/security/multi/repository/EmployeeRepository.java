package com.security.multi.repository;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import com.security.multi.model.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, Integer> {

	@Query("Select e.empId,e.firstName,l.leaveType,l.reason,l.leaveStart,l.leaveEnd,l.dayType,l.status "
			+ "from Employee e join Leave l on e.empId=l.employee.empId")
	public List<Object> viewLeaveDetails();
	
	@Query("Select e.empId,e.firstName,a.date,a.status from Employee e join Attendance a on e.empId=a.employee.empId")
	public List<Object> viewAttendanceDetails();
	
}
