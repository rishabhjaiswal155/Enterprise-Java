package com.app.service;

import java.util.List;

import com.app.dto.EmployeeDto;
import com.app.entities.Employee;

public interface IEmployeeService {
	List<Employee> getAllEmployeeDetails();
	EmployeeDto addEmployeeDetails(EmployeeDto empDto);
	String deleteEmployeeDetails(Long empId);
	EmployeeDto getEmployeeDetails(Long empId);
	EmployeeDto updateEmployeeDetails(EmployeeDto empDto);

}
