package com.security.multi.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import com.security.multi.model.Attendance;
import com.security.multi.model.DeptMaster;
import com.security.multi.model.Employee;
import com.security.multi.model.Leave;
import com.security.multi.model.TenantMaster;
import com.security.multi.model.User;
import com.security.multi.pojo.RequestPojo;
import com.security.multi.repository.AttendanceRepository;
import com.security.multi.repository.DeptMasterRepository;
import com.security.multi.repository.EmployeeRepository;
import com.security.multi.repository.LeaveRepository;
import com.security.multi.repository.TenantRepository;
import com.security.multi.repository.UserRepository;

@Service
public class UserService {

	@Autowired
	TenantRepository tenantRepository;

	@Autowired
	DeptMasterRepository deptMasterRepository;
	
	@Autowired
	EmployeeRepository employeeRepository;
	
	@Autowired
	UserRepository userDetailsRepository;
	
	@Autowired
	LeaveRepository leaveRepository;

	@Autowired
	AttendanceRepository attendanceRepository;
	
	@Autowired
    private PasswordEncoder passwordEncoder;
	
	public String getEncodedPassword(String password) {
		return passwordEncoder.encode(password);
	}
    
    public String saveTenantDetails(RequestPojo requestPojo) {
		
		TenantMaster tenantMaster=new TenantMaster();
		DeptMaster deptMaster=new DeptMaster();
		User user=new User();
		
		tenantMaster.setTenantId(requestPojo.getTenantId());
		tenantMaster.setTenantName(requestPojo.getTenantName());
		
		deptMaster.setDeptId(requestPojo.getDeptId());
		deptMaster.setDeptName(requestPojo.getDeptName());
		deptMaster.setTenantMaster(tenantMaster);
		
		user.setActive(requestPojo.isActive());
		user.setUsername(requestPojo.getUsername());
        user.setPassword(getEncodedPassword(requestPojo.getPassword()));
        user.setRole(requestPojo.getRole());
        
        user.setTenantMaster(tenantMaster);
        user.setDeptMaster(deptMaster);
        
        tenantRepository.save(tenantMaster);	
        deptMasterRepository.save(deptMaster);
        userDetailsRepository.save(user);
        
		return "Tenant Added";	
    }
    
    public String saveDeptMaster(RequestPojo requestPojo) {
    	
    	TenantMaster tenantMaster=new TenantMaster();
    	DeptMaster deptMaster=new DeptMaster();
		User user=new User();
		
		tenantMaster.setTenantId(requestPojo.getTenantId());
		
		deptMaster.setDeptId(requestPojo.getDeptId());
		deptMaster.setDeptName(requestPojo.getDeptName());
		deptMaster.setTenantMaster(tenantMaster);
		
		user.setActive(requestPojo.isActive());
		user.setUsername(requestPojo.getUsername());
        user.setPassword(getEncodedPassword(requestPojo.getPassword()));
        user.setRole(requestPojo.getRole());
        
        user.setTenantMaster(tenantMaster);
        user.setDeptMaster(deptMaster);
        
        deptMasterRepository.save(deptMaster);
        userDetailsRepository.save(user);
        
        return "DeptMaster Added";
        
    }
    
    public String saveEmployeeDetails(RequestPojo requestPojo) {
    	
    	TenantMaster tenantMaster=new TenantMaster();
    	DeptMaster deptMaster=new DeptMaster();
		User user=new User();
		Employee employee=new Employee();

		tenantMaster.setTenantId(requestPojo.getTenantId());
		
		employee.setFirstName(requestPojo.getFirstName());
	    employee.setLastName(requestPojo.getLastName());
	    employee.setMobile(requestPojo.getMobile());
	    employee.setEmail(requestPojo.getEmail());
		
	    deptMaster.setDeptId(requestPojo.getDeptId());
		user.setUserId(requestPojo.getUserId());
		user.setActive(requestPojo.isActive());
		user.setUsername(requestPojo.getUsername());
        user.setPassword(getEncodedPassword(requestPojo.getPassword()));
        user.setRole(requestPojo.getRole());
       
        
        employee.setTenantMaster(tenantMaster);
        employee.setUser(user);
        
        user.setTenantMaster(tenantMaster);
        user.setDeptMaster(deptMaster);
        
        userDetailsRepository.save(user);
        employeeRepository.save(employee);
        
		return "Employee Added";
    }
    
    public String requestLeave(RequestPojo requestPojo) {
    	
    	TenantMaster tenantMaster=new TenantMaster();
    	Employee employee=new Employee();
    	Leave leave=new Leave();
    	
    	tenantMaster.setTenantId(requestPojo.getTenantId());
    	employee.setEmpId(requestPojo.getEmpId());
    	
    	leave.setDayType(requestPojo.getDayType());
    	leave.setLeaveStart(requestPojo.getLeaveStart());
    	leave.setLeaveEnd(requestPojo.getLeaveEnd());
    	leave.setLeaveType(requestPojo.getLeaveType());
    	leave.setReason(requestPojo.getReason());
    	leave.setStatus(requestPojo.getStatus());
    	leave.setTenantMaster(tenantMaster);
    	leave.setEmployee(employee);
    	
    	leaveRepository.save(leave);
    	
    	return "Leave Request Send";
    }
	
    public String addAttendance(RequestPojo requestPojo) {
    	
    	TenantMaster tenantMaster=new TenantMaster();
    	Employee employee=new Employee();
    	Attendance attendance=new Attendance();
    	
    	tenantMaster.setTenantId(requestPojo.getTenantId());
    	employee.setEmpId(requestPojo.getEmpId());
    	
    	attendance.setDate(requestPojo.getDate());
    	attendance.setStatus(requestPojo.getStatus());
    	attendance.setEmployee(employee);
    	attendance.setTenantMaster(tenantMaster);
    	
    	attendanceRepository.save(attendance);
    	
		return "Attendance Details added";	
	}
    
    public List<Object> getLeaveList(){
    	return employeeRepository.viewLeaveDetails();
    }

    public List<Object> getAttendanceList(){
    	return employeeRepository.viewAttendanceDetails();
    }
}
