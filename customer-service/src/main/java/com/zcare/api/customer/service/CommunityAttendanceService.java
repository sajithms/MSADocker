package com.zcare.api.customer.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zcare.api.customer.domain.CommunityAttendance;
import com.zcare.api.customer.repository.CommunityAttendanceRepository;

@Service
public class CommunityAttendanceService {
	 @Autowired
	 CommunityAttendanceRepository communityAttendanceRepository;
	 
	

	 public List<CommunityAttendance> getStudentAttendanceByUserId(String studentId,String startDate) {
	       return communityAttendanceRepository.findCommunityAttendanceByStudentId(new Integer(studentId), startDate);
	    }


}
