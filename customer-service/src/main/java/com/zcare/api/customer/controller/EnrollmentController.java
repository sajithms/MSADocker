package com.zcare.api.customer.controller;


import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.zcare.api.customer.domain.Enrollment;
import com.zcare.api.customer.service.EnrollmentService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;



@RestController
@RequestMapping("/v1")
@Api(description = "Set of endpoints for  Retrieving the enrollment details.")
public class EnrollmentController {
	public static final Logger log = Logger.getLogger(EnrollmentController.class.getName());
	

	@Autowired
	private EnrollmentService enrollmentService;



	
	@ApiOperation("Returns a specific student enrollment  by their student identifier. 404 if does not exist.")
	@RequestMapping(value = "/enrollments", method = RequestMethod.GET)
	public Enrollment getEnrollments(@RequestParam("studentId") String studentId){
		
		return enrollmentService.getEnrollmentsByUserId(studentId);

	}

	
}