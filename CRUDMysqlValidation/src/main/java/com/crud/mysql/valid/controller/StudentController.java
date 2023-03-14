package com.crud.mysql.valid.controller;

import java.util.List;
import javax.validation.Valid;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import com.crud.mysql.valid.model.StudentDetails;
import com.crud.mysql.valid.service.StudentService;

@RestController
public class StudentController {
	
	@Autowired
	private StudentService studentService;
	
	Logger logger = LogManager.getLogger(StudentController.class);
	
	@PostMapping("/addstudentdetails")
	public String insertStudent(@RequestBody @Valid  StudentDetails studentDetails) {
		studentService.insertStudentDetails(studentDetails);
		return "Student Details Inserted";
	}
 
	@GetMapping("/viewstudents")
	public List<StudentDetails> viewStudentDetails() {
		return studentService.viewStudentDetails();
	}
	
	@PutMapping("/updatestudent") 
	public void updateStudentDetails(@RequestBody StudentDetails studentDetails) {
		studentService.updateStudentDetails(studentDetails);
		logger.info("Student Detail are updated");
	}

	@DeleteMapping("/deletestudent") /*id passed to json body to delete data*/
	public void deleteById(@RequestBody StudentDetails studentDetails) {
		studentService.deleteStudentDetailsById(studentDetails);
	}	
	
//	@DeleteMapping("/deletestudent/{studentId}")  /*id passed to url to delete data*/
//	public void deletestudentDetailsById(@PathVariable int studentId) {
//		studentService.deleteStudentDetails(studentId);
//	}	
	
}
