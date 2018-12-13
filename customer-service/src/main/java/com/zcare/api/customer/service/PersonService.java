package com.zcare.api.customer.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zcare.api.customer.domain.Person;
import com.zcare.api.customer.repository.PersonRepository;

@Service
public class PersonService {
	 @Autowired
	 PersonRepository personRepo;
	 
	 public Person savePerson(Person person) {
	       return personRepo.save(person);
	    }
	 
	 public Optional<Person> getPersonById(Person person) {
	       return personRepo.findById(person.getPersonId());
	    }

	 public Person getPersonByUserId(String userId) {
	       return personRepo.findByUserId(new Integer(userId));
	    }


}
