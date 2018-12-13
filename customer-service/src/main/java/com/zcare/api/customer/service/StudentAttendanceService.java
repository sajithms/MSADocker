package com.zcare.api.customer.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zcare.api.customer.domain.StudentAttendance;
import com.zcare.api.customer.repository.StudentAttendanceRepository;

@Service
public class StudentAttendanceService {
	 @Autowired
	 StudentAttendanceRepository StudentAttendanceRpo;
	 
	

	 public List<StudentAttendance> getStudentAttendanceByUserId(String studentId) {
	       return StudentAttendanceRpo.findByStudentId(new Integer(studentId));
	    }


}
