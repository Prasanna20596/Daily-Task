package com.crud.mangodb.service;

import com.crud.mangodb.model.StudentDetails;

public interface StudentService {
	
	void updateStudentDetails(StudentDetails studentDetails);
	void deleteStudentDetailById(int studentId);
	StudentDetails findStudentDetailsById(int studentId);
	public int getNextSequence(String seqName);
	
}
