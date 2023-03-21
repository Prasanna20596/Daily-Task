package com.security.multi.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.security.multi.model.Attendance;

public interface AttendanceRepository extends JpaRepository<Attendance, Integer> {

}
