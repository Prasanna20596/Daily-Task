package com.crudjoins.service;

import java.util.List;

import com.crudjoins.model.BatchDetails;
import com.crudjoins.model.PersonalDetails;

public interface StudentService {

	void insertStudentDetails(BatchDetails batchdetails,PersonalDetails personalDetails);
	void updateStudentDetails(BatchDetails batchdetails,PersonalDetails personalDetails);
	public List getStudentDetails();
	void deleteStudentDetails(int studentId);

}