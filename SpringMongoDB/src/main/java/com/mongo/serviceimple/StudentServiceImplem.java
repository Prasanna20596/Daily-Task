package com.mongo.serviceimple;

import static org.springframework.data.mongodb.core.FindAndModifyOptions.options;
import static org.springframework.data.mongodb.core.query.Criteria.where;
import static org.springframework.data.mongodb.core.query.Query.query;
import java.util.List;
import java.util.Objects;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Service;
import com.mongo.entity.IDSequence;
import com.mongo.entity.StudentDetails;
import com.mongo.repository.StudentRepository;
import com.mongo.service.StudentService;


@Service
public class StudentServiceImplem implements StudentService{
	
	@Autowired
	StudentRepository studentRepository;

    @Autowired
    MongoOperations mongoOperations;

    @Override
	public int getNextSequence(String seqName) {
		IDSequence counter = mongoOperations.findAndModify(query(where("id").is(seqName)),
		               new Update().inc("sequence",1), options().returnNew(true).upsert(true),
		               IDSequence.class);
		       return !Objects.isNull(counter) ? counter.getSequence(): 1;	      
	}
    
	public List<StudentDetails> getStudentDetails() {
		return studentRepository.findAll();
	}
	
	public StudentDetails updateStudentDetails(StudentDetails studentDetails) {
		return studentRepository.save(studentDetails);
	}

	public void deleteStudentDetail(StudentDetails studentDetails) { /*Using Request Body*/
		studentRepository.delete(studentDetails);
	}

	public void deleteStudentDetailById(int studentId) {  /**Using path variable */
		studentRepository.deleteById(studentId);
	}

}
