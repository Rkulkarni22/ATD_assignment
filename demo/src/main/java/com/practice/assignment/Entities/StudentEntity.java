package com.practice.assignment.Entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name="student")
public class StudentEntity {

	@Id
	@Column(nullable = false)
    private Long id;
	
	@Column(nullable = false)
	private String first_name;
	
	@Column(nullable =false)
	private String last_name;
	
	@Column(nullable = false)
	private Long age;
	
	@Column(nullable = false)
	private Long phone_number;
	
	public StudentEntity() {
		// TODO Auto-generated constructor stub
	}

	public StudentEntity(Long id, String first_name, String last_name, Long age, Long phone_number) {
		super();
		this.id = id;
		this.first_name = first_name;
		this.last_name = last_name;
		this.age = age;
		this.phone_number = phone_number;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getFirst_name() {
		return first_name;
	}

	public void setFirst_name(String first_name) {
		this.first_name = first_name;
	}

	public String getLast_name() {
		return last_name;
	}

	public void setLast_name(String last_name) {
		this.last_name = last_name;
	}

	public Long getAge() {
		return age;
	}

	public void setAge(Long age) {
		this.age = age;
	}

	public Long getPhone_number() {
		return phone_number;
	}

	public void setPhone_number(Long phone_number) {
		this.phone_number = phone_number;
	}

	
	
}
