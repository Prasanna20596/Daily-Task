package com.security.multi.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.security.multi.model.DeptMaster;

public interface DeptMasterRepository extends JpaRepository<DeptMaster, Integer> {

}
