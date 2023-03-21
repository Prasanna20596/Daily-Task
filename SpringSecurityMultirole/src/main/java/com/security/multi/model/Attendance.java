package com.security.multi.model;

import java.sql.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "attendance")
public class Attendance {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int attendanceId;
	private String status;
	private Date date;

	@OneToOne
	@JoinColumn(name="empId")
	private Employee employee;
	
	@OneToOne
	@JoinColumn(name = "tenantId")
	private TenantMaster tenantMaster;
	
	public Employee getEmployee() {
		return employee;
	}

	public void setEmployee(Employee employee) {
		this.employee = employee;
	}

	public int getAttendanceId() {
		return attendanceId;
	}

	public void setAttendanceId(int attendanceId) {
		this.attendanceId = attendanceId;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public TenantMaster getTenantMaster() {
		return tenantMaster;
	}

	public void setTenantMaster(TenantMaster tenantMaster) {
		this.tenantMaster = tenantMaster;
	}

}
