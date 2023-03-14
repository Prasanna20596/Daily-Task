package com.mongo.controller;

import java.util.List;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import com.mongo.entity.StudentDetails;
import com.mongo.repository.StudentRepository;
import com.mongo.service.StudentService;


@RestController
public class StudentController {

	@Autowired
	StudentRepository studentRepository;
	
	@Autowired
	StudentService studentService;
	
	@PostMapping("/addstudent")
	public StudentDetails addStudentDetails(@RequestBody @Valid StudentDetails studentDetails) {
		studentDetails.setStudentId(studentService.getNextSequence("idsequence"));
		return studentRepository.save(studentDetails);
	}
	
	@GetMapping("/studentdetails")
	List<StudentDetails> getStudentDetails() {
		return studentService.getStudentDetails();
	}
	
	@PutMapping("/updatestudent")
	public StudentDetails updateStudentDetails(@RequestBody @Valid StudentDetails studentDetails) {
		return studentService.updateStudentDetails(studentDetails);
	}
	
	@DeleteMapping("/deletestudent")
	public void deleteStudentDetail(@RequestBody StudentDetails studentDetails) { /**Using Request Body*/
		studentService.deleteStudentDetail(studentDetails);
	}
	
	@DeleteMapping("/deletestudent/{studentId}")
	public void deleteStudentDetailsById(@PathVariable int studentId) { /**Using path variable*/
		studentService.deleteStudentDetailById(studentId);	
	}
	
}
