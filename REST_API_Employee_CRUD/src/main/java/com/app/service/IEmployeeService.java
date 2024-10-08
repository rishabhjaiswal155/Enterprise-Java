package com.app.service;

import java.util.List;

import com.app.entities.Employee;

public interface IEmployeeService {
	List<Employee> getAllEmployeeDetails();
	Employee addEmployeeDetails(Employee emp);
	String deleteEmployeeDetails(Long empId);
	Employee getEmployeeDetails(Long empId);
	Employee updateEmployeeDetails(Employee emp);

}
