package com.mongo.service;

import java.util.List;
import com.mongo.entity.StudentDetails;

public interface StudentService {
	
	public int getNextSequence(String seqName);
	List<StudentDetails> getStudentDetails();
	StudentDetails updateStudentDetails(StudentDetails studentDetails);
	void deleteStudentDetail(StudentDetails studentDetails);
	void deleteStudentDetailById(int studentId);
	
	
}
