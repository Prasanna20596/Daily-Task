package com.security.multi.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.security.multi.model.Leave;

public interface LeaveRepository extends JpaRepository<Leave, Integer>{

}
