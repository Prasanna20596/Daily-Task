package com.crud.mangodb.serviceimplem;

import static org.springframework.data.mongodb.core.FindAndModifyOptions.options;
import static org.springframework.data.mongodb.core.query.Criteria.where;
import static org.springframework.data.mongodb.core.query.Query.query;

import java.util.Objects;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Service;

import com.crud.mangodb.model.IDSequence;
import com.crud.mangodb.model.StudentDetails;
import com.crud.mangodb.repository.StudentRepository;
import com.crud.mangodb.service.StudentService;

@Service
public class StudentServiceImplem implements StudentService{
	
	@Autowired
	StudentRepository studentRepository;

    @Autowired
    MongoOperations mongoOperations;

	@Override
	public void updateStudentDetails(StudentDetails studentDetails) {
		studentRepository.save(studentDetails);
	}

	@Override
	public void deleteStudentDetailById(int studentId) {
		studentRepository.deleteById(studentId);
	}

	public StudentDetails findStudentDetailsById(int studentId) {
		return studentRepository.findById(studentId).get();
	}

	@Override
	public int getNextSequence(String seqName) {
		IDSequence counter = mongoOperations.findAndModify(query(where("id").is(seqName)),
		               new Update().inc("sequence",1), options().returnNew(true).upsert(true),
		               IDSequence.class);
		       return !Objects.isNull(counter) ? counter.getSequence(): 1;	      
	}

	

}