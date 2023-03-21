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
@Table(name = "leaves")
public class Leave {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int leaveId;
	private String leaveType;
	private String reason;
	private Date leaveStart;
	private Date leaveEnd;
	private String dayType;
	private String status;

	@OneToOne
	@JoinColumn(name = "empId")
	private Employee employee;

	@OneToOne
	@JoinColumn(name = "tenantId")
	private TenantMaster tenantMaster;

	public int getLeaveId() {
		return leaveId;
	}

	public void setLeaveId(int leaveId) {
		this.leaveId = leaveId;
	}

	public String getLeaveType() {
		return leaveType;
	}

	public void setLeaveType(String leaveType) {
		this.leaveType = leaveType;
	}

	public String getReason() {
		return reason;
	}

	public void setReason(String reason) {
		this.reason = reason;
	}

	public Date getLeaveStart() {
		return leaveStart;
	}

	public void setLeaveStart(Date leaveStart) {
		this.leaveStart = leaveStart;
	}

	public Date getLeaveEnd() {
		return leaveEnd;
	}

	public void setLeaveEnd(Date leaveEnd) {
		this.leaveEnd = leaveEnd;
	}

	public String getDayType() {
		return dayType;
	}

	public void setDayType(String dayType) {
		this.dayType = dayType;
	}

	public Employee getEmployee() {
		return employee;
	}

	public void setEmployee(Employee employee) {
		this.employee = employee;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public TenantMaster getTenantMaster() {
		return tenantMaster;
	}

	public void setTenantMaster(TenantMaster tenantMaster) {
		this.tenantMaster = tenantMaster;
	}
}
