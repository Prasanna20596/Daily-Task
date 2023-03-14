package com.crud.mysql.valid.service;

import java.util.List;
import com.crud.mysql.valid.model.StudentDetails;

public interface StudentService {
	
	StudentDetails insertStudents(StudentDetails studentDetails);
	void insertStudentDetails(StudentDetails studentDetails);
	List<StudentDetails> viewStudentDetails();
    void updateStudentDetails(StudentDetails studentDetails);
    void deleteStudentDetailsById(StudentDetails studentDetails);/*id passed to json body to delete data*/
    void deleteStudentDetails(int studentId);/*id passed to url to delete data*/

}
