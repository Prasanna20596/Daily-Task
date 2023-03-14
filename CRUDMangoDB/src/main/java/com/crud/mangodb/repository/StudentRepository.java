package com.crud.mangodb.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import com.crud.mangodb.model.StudentDetails;

public interface StudentRepository extends MongoRepository<StudentDetails, Integer> {

	
}
