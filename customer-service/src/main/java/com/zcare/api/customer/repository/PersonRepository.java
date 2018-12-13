package com.zcare.api.customer.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.zcare.api.customer.domain.Person;

public interface PersonRepository extends JpaRepository<Person, Integer> {
	
	@Query("SELECT p FROM Person p WHERE p.userId = :userId")
	Person findByUserId(@Param("userId")Integer userId);
	

}
