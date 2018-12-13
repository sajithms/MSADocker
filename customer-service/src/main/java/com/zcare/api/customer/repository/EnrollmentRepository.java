package com.zcare.api.customer.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.zcare.api.customer.domain.Enrollment;

public interface EnrollmentRepository extends JpaRepository<Enrollment, Integer> {
	
	@Query("SELECT e FROM Enrollment e WHERE e.studentId = :studentId and exitDate is null")
	Enrollment findCurrentEnrollmentByStudentId(@Param("studentId")Integer studentId);
	

}
