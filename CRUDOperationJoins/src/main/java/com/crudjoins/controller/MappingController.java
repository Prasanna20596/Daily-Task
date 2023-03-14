package com.crudjoins.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import com.crudjoins.model.BatchDetails;
import com.crudjoins.model.PersonalDetails;
import com.crudjoins.service.StudentService;

@Controller
public class MappingController {

	@Autowired
	StudentService studentService;
	
	@GetMapping("/")
	public String hompage() {
		return "NewFile";
	}
	
	@PostMapping("/addstudent")
	public void insertStudentDetails(BatchDetails batchdetails, PersonalDetails personaldetails) {
		studentService.insertStudentDetails(batchdetails, personaldetails);
	}

	@GetMapping("/viewstudents")
	public List getStudenList() {
		return studentService.getStudentDetails();
	}
	
	@PutMapping("/updatestudent")
	public void updateStudentDetails(BatchDetails batchdetails,PersonalDetails personaldetails) {
		studentService.updateStudentDetails(batchdetails, personaldetails);
	}
	
	@DeleteMapping("/deletestudent/{studentId}")
	public void deleteStudentDetails(@PathVariable int studentId) {
		studentService.deleteStudentDetails(studentId);
	}
}