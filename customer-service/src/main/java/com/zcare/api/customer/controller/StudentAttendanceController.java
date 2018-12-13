package com.zcare.api.customer.controller;


import java.util.List;
import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.zcare.api.customer.domain.CommunityAttendance;
import com.zcare.api.customer.domain.StudentAttendance;
import com.zcare.api.customer.service.CommunityAttendanceService;
import com.zcare.api.customer.service.StudentAttendanceService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;



@RestController
@RequestMapping("/v1")
@Api(description = "Set of endpoints for  Retrieving the attendence details.")
public class StudentAttendanceController {
	public static final Logger log = Logger.getLogger(StudentAttendanceController.class.getName());
	

	@Autowired
	private StudentAttendanceService studentAttendanceService;
	
	@Autowired
	private CommunityAttendanceService communityAttendanceService;



	
	@ApiOperation("Returns the student attendecne details for a student. 404 if invalid student.")
	@RequestMapping(value = "/studentattendances", method = RequestMethod.GET)
	public List<StudentAttendance> getStudentAttendances(@RequestParam("studentId") String studentId){
		
		return studentAttendanceService.getStudentAttendanceByUserId(studentId);

	}
	
	@ApiOperation("Returns the community attendecne details for a student. 404 if invalid student.")
	@RequestMapping(value = "/communityattendances", method = RequestMethod.GET)
	public List<CommunityAttendance> getCommunityAttendances(@RequestParam("studentId") String studentId,@RequestParam("startDate")String startDate){
		
		return communityAttendanceService.getStudentAttendanceByUserId(studentId,startDate);

	}
	

	
}