package com.zcare.api.customer.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.zcare.api.customer.domain.StudentAttendance;

public interface StudentAttendanceRepository extends JpaRepository<StudentAttendance, Integer> {
	
	@Query
	List<StudentAttendance> findByStudentId(Integer studentId);
	

}
