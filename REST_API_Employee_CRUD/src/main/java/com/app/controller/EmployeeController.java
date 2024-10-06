package com.app.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.app.entities.Employee;
import com.app.service.IEmployeeService;

@RestController
@RequestMapping("/api/employees")

@CrossOrigin(origins = "http://localhost:3000")
public class EmployeeController {
	
	@Autowired
	private IEmployeeService empService;
	
	public EmployeeController() {
	System.out.println("in ctor of "+getClass());
	}
	
	//provide end point
	@GetMapping
	public List<Employee> getAllEmployeeDetails(){
		System.out.println("in getAllEmployeesDetails() of "+getClass());
		return empService.getAllEmployeeDetails();
	}

}
