package com.app.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonProperty;

@Entity
@Table(name="employees")
public class Employee extends BaseEntity {
	@Column(length=20)
	private String name;
	@Column(length=20)
	private String location;
	@Column(length=20,name="department_name")
	@JsonProperty(value = "department")
	private String dept;
	public Employee() {
		System.out.println("in ctor of "+getClass());
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getLocation() {
		return location;
	}
	public void setLocation(String location) {
		this.location = location;
	}
	public String getDept() {
		return dept;
	}
	public void setDept(String dept) {
		this.dept = dept;
	}
	@Override
	public String toString() {
		return "Employee [name=" + name + ", location=" + location + ", dept=" + dept + ", getId()=" + getId() + "]";
	}
	

}
