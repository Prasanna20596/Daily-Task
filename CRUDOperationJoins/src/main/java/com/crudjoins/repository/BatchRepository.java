package com.crudjoins.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import com.crudjoins.model.BatchDetails;

@Repository
public interface BatchRepository extends JpaRepository<BatchDetails, Integer>{
	
	@Query("select s.studentId,s.studentName,s.degree,s.department,s.startingYear,s.endingYear,t.mobileNo,t.email,t.fatherName,t.fatherNumber,t.address,t.city,t.state from BatchDetails s join PersonalDetails t on s.studentId=t.personalId")
	public List getStudentDetails();
	
}