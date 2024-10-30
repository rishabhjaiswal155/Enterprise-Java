package com.app.entities;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name="employees")
@NoArgsConstructor
@Getter
@Setter
@ToString
public class Employee extends BaseEntity {
	@Column(length=20)
	private String name;
	@Column(length=20,unique=true)
	private String lastName;
	private String email;
	private String password;
	@Column(length=20)
	private String location;

	@JsonProperty(value = "department")
	@Column(length=20,name="department_name")
	private String dept;
    private double salary;
	private LocalDate joinDate;
}
