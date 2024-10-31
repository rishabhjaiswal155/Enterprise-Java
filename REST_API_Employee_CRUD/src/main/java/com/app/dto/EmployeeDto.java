package com.app.dto;

import java.time.LocalDate;
import javax.validation.constraints.Email;
import javax.validation.constraints.Future;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

import org.hibernate.validator.constraints.Range;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonProperty.Access;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@NoArgsConstructor
@Getter
@Setter
@ToString
public class EmployeeDto{
	private Long id;
	@NotBlank(message = "firstName is required")
	private String name;
	@NotBlank(message="lastName is required")
	//@Min(value=4,message="lastName minimun chars must be 4")
	//@Max(value=20,message="lastName mximum chars must be 20")
	private String lastName;
	@Email(message="Email must be in required format")
	private String email;
	@Pattern(regexp="((?=.*\\d)(?=.*[a-z])(?=.*[#@$*]).{5,20})")
	@JsonProperty(access=Access.WRITE_ONLY)
	private String password;
	@NotBlank(message="location is required")
	private String location;
	@JsonProperty(value = "department")
	private String dept;
	@NotNull
	@Range(min=10000,max=90000)
	private double salary;
	@Future(message = "joinDate must be a future date")
	private LocalDate joinDate;
}
