package com.mongo.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import com.mongo.entity.StudentDetails;

public interface StudentRepository extends MongoRepository<StudentDetails, Integer> {

	
}
