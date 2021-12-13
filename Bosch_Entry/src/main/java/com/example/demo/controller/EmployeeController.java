package com.example.demo.controller;

import java.util.Arrays;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.Person;
import com.example.demo.service.EmployeeService;

@RestController
@RequestMapping("/api/employees")
public class EmployeeController {

	private EmployeeService employeeService;

	public EmployeeController(EmployeeService employeeService) {
		super();
		this.employeeService = employeeService;
	}
	 
	//Get all employees
	@GetMapping
	public List<Person> get_all_people(){
		return employeeService.getAllEmployees();
	}
	
	//Get employee by Unique Identifier (ID)
	@GetMapping("{id}")
	public ResponseEntity<Person> get_person(@PathVariable("id") long employeeId){
		return new ResponseEntity<Person>(employeeService.getEmployeeById(employeeId), HttpStatus.OK);
	}
	
	//Update employee by Unique Identifier (ID)
	@PutMapping("{id}")
	public ResponseEntity<Person> edit_person(@PathVariable("id") long employeeId, @RequestBody Person person){
		return new ResponseEntity<Person>(employeeService.updateEmployee(person, employeeId), HttpStatus.OK);
	}
	
	//Create new employee
	@PostMapping()
	public ResponseEntity<Person> add_person(@RequestBody Person person){
		return new ResponseEntity<Person>(employeeService.savePerson(person), HttpStatus.CREATED);
	}
	
	//Delete employee by Unique Identifier (ID)
	@DeleteMapping("{id}")
	public ResponseEntity<String> deleteEmployee(@PathVariable("id") long employeeId){
		employeeService.deleteEmployee(employeeId);
		return new ResponseEntity<String>("Employee Successfully Deleted!", HttpStatus.OK);
	}
	
	//Compare Employees Age Difference
	@GetMapping("/ages/{employeeIds}")
	public String get_minimum_age_difference_in_days(@PathVariable String employeeIds) {
		List<String> ids = Arrays.asList(employeeIds.split(","));
		return employeeService.get_minimum_age_difference_in_days(Long.parseLong(ids.get(0)), Long.parseLong(ids.get(1)));
	  }
}
