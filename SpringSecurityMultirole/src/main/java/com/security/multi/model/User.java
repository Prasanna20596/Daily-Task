package com.security.multi.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "users")
public class User {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int userId;
	private String username;
	private String password;
	private boolean active;
	private String role;

	@OneToOne
	@JoinColumn(name = "tenantId")
	private TenantMaster tenantMaster;

	@OneToOne
	@JoinColumn(name = "deptId")
	private DeptMaster deptMaster;

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public boolean isActive() {
		return active;
	}

	public void setActive(boolean active) {
		this.active = active;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public DeptMaster getDeptMaster() {
		return deptMaster;
	}

	public void setDeptMaster(DeptMaster deptMaster) {
		this.deptMaster = deptMaster;
	}

	public TenantMaster getTenantMaster() {
		return tenantMaster;
	}

	public void setTenantMaster(TenantMaster tenantMaster) {
		this.tenantMaster = tenantMaster;
	}

}