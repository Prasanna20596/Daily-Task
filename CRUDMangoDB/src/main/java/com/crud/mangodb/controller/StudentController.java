package com.crud.mangodb.controller;

import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import com.crud.mangodb.model.StudentDetails;
import com.crud.mangodb.repository.StudentRepository;
import com.crud.mangodb.service.StudentService;

@RestController
public class StudentController {

	@Autowired
	StudentRepository studentRepository;
	
	@Autowired
	StudentService studentService;
	
	@PostMapping("/addstudent")
	public void addStudentDetails(@RequestBody @Valid StudentDetails studentDetails) {
		studentDetails.setStudentId(studentService.getNextSequence("idsequence"));
		studentRepository.save(studentDetails);
	}
	
	@PutMapping("/updatestudent")
	public void updateStudentDetails(@RequestBody StudentDetails studentDetails) {
		studentService.updateStudentDetails(studentDetails);
	}
	
	@DeleteMapping("/deletestudent/{studentId}")
	public void deleteStudentDetailsById(@PathVariable int studentId) {
		studentService.deleteStudentDetailById(studentId);	
	}
	
	@GetMapping("/studendetails/{studentId}")
	public StudentDetails findStudentDetailsById(@PathVariable int studentId) {
		return studentService.findStudentDetailsById(studentId);
	}
}
