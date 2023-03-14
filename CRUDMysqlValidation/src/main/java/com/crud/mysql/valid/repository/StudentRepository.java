package com.crud.mysql.valid.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.crud.mysql.valid.model.StudentDetails;

public interface StudentRepository extends JpaRepository<StudentDetails, Integer>{

}
