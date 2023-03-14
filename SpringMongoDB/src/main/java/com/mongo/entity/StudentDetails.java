package com.mongo.entity;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "studentdetails")
public class StudentDetails {
	
	@Id
	private int studentId;
	@NotBlank(message = "Name cannot be blank")
	private String studentName;
	@NotBlank
	@Size(max = 2, message = "Degree cannot blank and Type this format: 'BE'")
	private String degree;
	@NotBlank
	@Size(min = 3, max = 5, message = "Department cannot blank and Type this dept format: 'EIE,ECE,MECH,CSE,EEE,CIVIL'")
	private String department;
	@NotNull(message = "Starting year cannot null & Type this year format Ex:'2013' ")
	private Integer startingYear;
	@Size(min = 4, message = "Ending year cannot blank, only accept mimimum 4 or above letters")
	private String endingYear;

	public int getStudentId() {
		return studentId;
	}

	public void setStudentId(int studentId) {
		this.studentId = studentId;
	}

	public String getStudentName() {
		return studentName;
	}

	public void setStudentName(String studentName) {
		this.studentName = studentName;
	}

	public String getDegree() {
		return degree;
	}

	public void setDegree(String degree) {
		this.degree = degree;
	}

	public String getDepartment() {
		return department;
	}

	public void setDepartment(String department) {
		this.department = department;
	}

	public Integer getStartingYear() {
		return startingYear;
	}

	public void setStartingYear(Integer startingYear) {
		this.startingYear = startingYear;
	}

	public String getEndingYear() {
		return endingYear;
	}

	public void setEndingYear(String endingYear) {
		this.endingYear = endingYear;
	}

}
