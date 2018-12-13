package com.zcare.api.customer.controller;


import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.zcare.api.customer.domain.Person;
import com.zcare.api.customer.service.PersonService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;



@Api(description = "Set of endpoints for Creating, Retrieving, Updating and Deleting of Persons.")
@RestController
@RequestMapping("/v1")
public class PersonController {
	public static final Logger log = Logger.getLogger(PersonController.class.getName());
	

	@Autowired
	private PersonService personService;



	
	@ApiOperation("Returns a specific person by their identifier. 404 if does not exist.")
	@RequestMapping(value = "/persons", method = RequestMethod.GET)
	public Person getPerson(@RequestParam("userId") String id){
		return personService.getPersonByUserId(id);

	}

	
}