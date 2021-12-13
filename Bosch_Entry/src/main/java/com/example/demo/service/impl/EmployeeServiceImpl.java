package com.example.demo.service.impl;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.exception.ResourceNotFoundException;
import com.example.demo.model.Person;
import com.example.demo.repository.EmployeeRepository;
import com.example.demo.service.EmployeeService;

@Service
public class EmployeeServiceImpl implements EmployeeService{
	
	private EmployeeRepository employeeRepo;  
	
	@Autowired
	public EmployeeServiceImpl(EmployeeRepository employeeRepo) {
		super();
		this.employeeRepo = employeeRepo;
	}

	@Override
	public Person savePerson(Person person) {
		System.out.println(person.toString());
		return employeeRepo.save(person);
	}

	@Override
	public List<Person> getAllEmployees() {
		return employeeRepo.findAll();
	}

	@Override
	public Person getEmployeeById(long id) {
		Optional<Person> employee = employeeRepo.findById(id);
		if(employee.isPresent()) {
			return employee.get();
		}
		else {
			throw new ResourceNotFoundException("Person", "Id", id);
		}
	}

	@Override
	public Person updateEmployee(Person person, long id) {
		Person existingPerson = employeeRepo.findById(id).orElseThrow(() -> new ResourceNotFoundException("Person", "Id", id));
		
		existingPerson.setBday(person.getBday());
		existingPerson.setJob(person.getJob());
		existingPerson.setName(person.getName());
		existingPerson.setNationality(person.getNationality());
		existingPerson.setPersonal_number(person.getPersonal_number());
		existingPerson.setSsn(person.getSsn());
		
		employeeRepo.save(existingPerson);
		return existingPerson;
	}

	@Override
	public void deleteEmployee(long id) {
		employeeRepo.findById(id).orElseThrow(() -> new ResourceNotFoundException("Person", "Id", id));
		employeeRepo.deleteById(id);
	}

	@Override
	public String get_minimum_age_difference_in_days(long id1, long id2) {
		Person existingPerson_one = employeeRepo.findById(id1).orElseThrow(() -> new ResourceNotFoundException("Person", "Id", id1));
		Person existingPerson_two = employeeRepo.findById(id2).orElseThrow(() -> new ResourceNotFoundException("Person", "Id", id2));

		List<Person> both_persons = new ArrayList<Person>();
		both_persons.add(existingPerson_one);
		both_persons.add(existingPerson_two);
		
		String[] date_one = existingPerson_one.getBday().split("/");
		String[] date_two = existingPerson_two.getBday().split("/");
		
		if(date_one[0].length()==1) date_one[0] = "0"+date_one[0]; 
		if(date_one[1].length()==1) date_one[1] = "0"+date_one[1];
		if(date_two[0].length()==1) date_two[0] = "0"+date_two[0];
		if(date_two[1].length()==1) date_two[1] = "0"+date_two[1];
		
		LocalDate first_date = LocalDate.parse(date_one[2]+"-"+date_one[0]+"-"+date_one[1]);
		LocalDate second_date = LocalDate.parse(date_two[2]+"-"+date_two[0]+"-"+date_two[1]);
		
		long number_of_days;
		
		if(first_date.compareTo(second_date) > 0)
			number_of_days = ChronoUnit.DAYS.between(second_date, first_date);
		else
			number_of_days = ChronoUnit.DAYS.between(first_date, second_date);
		
		return "[{\"Age_Difference_in_days\": \"" + String.valueOf(number_of_days) +"\",\"Persons\": [{\"id\": "+existingPerson_one.getId()+",\"name\": \""+existingPerson_one.getName()+"\",\"personal_number\": \""+existingPerson_one.getPersonal_number()+"\",\"ssn\": \""+existingPerson_one.getSsn()+"\",\"job\": \""+existingPerson_one.getJob()+"\",\"nationality\": \""+existingPerson_one.getNationality()+"\",\"bday\": \""+existingPerson_one.getBday()+"\"},{\"id\": "+existingPerson_two.getId()+",\"name\": \""+existingPerson_two.getName()+"\",\"personal_number\": \""+existingPerson_two.getPersonal_number()+"\",\"ssn\": \""+existingPerson_two.getSsn()+"\",\"job\": \""+existingPerson_two.getJob()+"\",\"nationality\": \""+existingPerson_two.getNationality()+"\",\"bday\": \""+existingPerson_two.getBday()+"\"}]}]";
	}
}
