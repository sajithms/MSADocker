package com.zcare.api.customer.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zcare.api.customer.domain.Enrollment;
import com.zcare.api.customer.repository.EnrollmentRepository;

@Service
public class EnrollmentService {
	 @Autowired
	 EnrollmentRepository enrollmentRpo;
	 
	

	 public Enrollment getEnrollmentsByUserId(String studentId) {
	       return enrollmentRpo.findCurrentEnrollmentByStudentId(new Integer(studentId));
	    }


}
