package com.crudjoins.model;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

@Entity
@Table(name = "personaldetails")
public class PersonalDetails {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int personalId;
	private Long mobileNo;
	private String email;
	private String fatherName;
	private Long fatherNumber;
	private String address;
	private String city;
	private String state;

	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "studentId")
	@OnDelete(action = OnDeleteAction.CASCADE)
	private BatchDetails batchdetails;
	
	public int getPersonalId() {
		return personalId;
	}

	public void setPersonalId(int personalId) {
		this.personalId = personalId;
	}

	public Long getMobileNo() {
		return mobileNo;
	}

	public void setMobileNo(Long mobileNo) {
		this.mobileNo = mobileNo;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getFatherName() {
		return fatherName;
	}

	public void setFatherName(String fatherName) {
		this.fatherName = fatherName;
	}

	public Long getFatherNumber() {
		return fatherNumber;
	}

	public void setFatherNumber(Long fatherNumber) {
		this.fatherNumber = fatherNumber;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}
	
	public BatchDetails getBatchdetails() {
		return batchdetails;
	}

	public void setBatchdetails(BatchDetails batchdetails) {
		this.batchdetails = batchdetails;
	}
}
