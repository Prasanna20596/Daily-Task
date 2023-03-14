package com.crud.mysql.valid.serviceImplem;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.crud.mysql.valid.model.StudentDetails;
import com.crud.mysql.valid.repository.StudentRepository;
import com.crud.mysql.valid.service.StudentService;


@Service
public class StudentServiceImple implements StudentService {
	
	@Autowired
	private StudentRepository studentRepos;

	public List<StudentDetails> viewStudentDetails() {
		return studentRepos.findAll();
	}

	public void updateStudentDetails(StudentDetails studentDetails) {
		studentRepos.save(studentDetails);	
	}

	public void deleteStudentDetailsById(StudentDetails studentDetails) { /*id passed to json body to delete data*/
		studentRepos.delete(studentDetails);	
	}

	public void deleteStudentDetails(int studentId) { /*id passed to url to delete data*/
		studentRepos.deleteById(studentId);
	}

	@Override
	public StudentDetails insertStudents(StudentDetails studentDetails) {
		return studentRepos.save(studentDetails);
	}

	@Override
	public void insertStudentDetails(StudentDetails studentDetails) {
		studentRepos.save(studentDetails);	
	}

}