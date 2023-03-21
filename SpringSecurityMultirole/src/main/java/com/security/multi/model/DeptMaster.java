package com.security.multi.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "deptmasters")
public class DeptMaster {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int deptId;
	private String deptName;

	@OneToOne
	@JoinColumn(name = "tenantId")
	private TenantMaster tenantMaster;

	public int getDeptId() {
		return deptId;
	}

	public void setDeptId(int deptId) {
		this.deptId = deptId;
	}

	public String getDeptName() {
		return deptName;
	}

	public void setDeptName(String deptName) {
		this.deptName = deptName;
	}

	public TenantMaster getTenantMaster() {
		return tenantMaster;
	}

	public void setTenantMaster(TenantMaster tenantMaster) {
		this.tenantMaster = tenantMaster;
	}

}