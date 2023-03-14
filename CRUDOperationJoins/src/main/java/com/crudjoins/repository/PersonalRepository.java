package com.crudjoins.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.crudjoins.model.PersonalDetails;

public interface PersonalRepository extends JpaRepository<PersonalDetails, Integer>{

}