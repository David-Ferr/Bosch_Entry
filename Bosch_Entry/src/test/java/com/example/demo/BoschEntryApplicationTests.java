package com.example.demo;

import java.util.List;
import javax.transaction.Transactional;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import com.example.demo.model.Person;
import com.example.demo.service.EmployeeService;

@SpringBootTest
@Transactional
class BoschEntryApplicationTests {

	@Autowired
	private EmployeeService service;
	
	@Test
	public void adding_person_test() 
	{
		List<Person> persons = service.getAllEmployees();
		Person p = new Person(54,"David","934635092","234045230","Computer Engineer","Portuguese", "24/08/94");
		service.savePerson(p);
		List<Person> newListOfPersons = service.getAllEmployees();
		assert(persons.size()<newListOfPersons.size());
	}
	
	@Test
	public void assert_database_loaded() 
	{
		List<Person> persons = service.getAllEmployees();
		assert(persons.size() >= 50);	
	}
}
