package com.example.demo.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name="employees")
public class Person {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	@Column(name = "name", nullable = false)
	private String name;
	
	@Column(name = "id_number")
	private String personal_number;
	
	@Column(name = "socialsecuritynumber")
	private String ssn;

	@Column(name = "job")
	private String job;
	
	@Column(name = "nationality")
	private String nationality;
	
	@Column(name = "birthday")
	private String bday;
	
	public Person() {}
	
	public Person(long id, String name, String personal_number, String ssn, String job, String nationality,
			String bday) {
		super();
		this.id = id;
		this.name = name;
		this.personal_number = personal_number;
		this.ssn = ssn;
		this.job = job;
		this.nationality = nationality;
		this.bday = bday;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPersonal_number() {
		return personal_number;
	}

	public void setPersonal_number(String personal_number) {
		this.personal_number = personal_number;
	}

	public String getSsn() {
		return ssn;
	}

	public void setSsn(String ssn) {
		this.ssn = ssn;
	}

	public String getJob() {
		return job;
	}

	public void setJob(String job) {
		this.job = job;
	}

	public String getNationality() {
		return nationality;
	}

	public void setNationality(String nationality) {
		this.nationality = nationality;
	}

	public String getBday() {
		return bday;
	}

	public void setBday(String bday) {
		this.bday = bday;
	}

	@Override
	public String toString() {
		return "Person [id=" + id + ", name=" + name + ", personal_number=" + personal_number + ", ssn=" + ssn
				+ ", job=" + job + ", nationality=" + nationality + ", bday=" + bday + "]";
	}
}
