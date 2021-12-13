package com.example.demo.service;

import java.util.List;

import com.example.demo.model.Person;

public interface EmployeeService {
	Person savePerson(Person person);
	List<Person> getAllEmployees();
	Person getEmployeeById(long id);
	Person updateEmployee(Person person, long id);
	void deleteEmployee(long id);
	String get_minimum_age_difference_in_days(long id1, long id2);
}
