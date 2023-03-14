package com.crudjoins.serviceimplem;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.crudjoins.model.BatchDetails;
import com.crudjoins.model.PersonalDetails;
import com.crudjoins.repository.BatchRepository;
import com.crudjoins.repository.PersonalRepository;
import com.crudjoins.service.StudentService;

@Service
public class StudentServiceImplem implements StudentService {

	@Autowired
	private BatchRepository batchRepository;
	
	@Autowired
	private PersonalRepository personalRepository;

	public void insertStudentDetails(BatchDetails batchdetails, PersonalDetails personalDetails) {
		personalDetails.setBatchdetails(batchdetails);
		personalRepository.save(personalDetails);	
	}

	public void updateStudentDetails(BatchDetails batchdetails, PersonalDetails personalDetails) {
		personalDetails.setBatchdetails(batchdetails);
		personalRepository.save(personalDetails);	
	}

	public List getStudentDetails() {
		return batchRepository.getStudentDetails();
	}

	public void deleteStudentDetails(int studentId) {
		personalRepository.deleteById(studentId);
	}
	
}