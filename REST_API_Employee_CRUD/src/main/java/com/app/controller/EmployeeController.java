package com.app.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.app.dto.ApiResponse;
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
	
	@PostMapping
	public ResponseEntity<?> addEmployeeDetails(@RequestBody @Valid Employee emp) {
		System.out.println("in addEmployeeDetails() of "+getClass());
		try {
		return new ResponseEntity<>(empService.addEmployeeDetails(emp),HttpStatus.CREATED);
		}catch(RuntimeException e) {
			System.out.println("got exception in addEmployeeDetails() of "+getClass());
			return new ResponseEntity<>(new ApiResponse(e.getMessage()),HttpStatus.BAD_REQUEST);
		}
		}
	
	@DeleteMapping("/{empId}")
	public ResponseEntity<?> deleteEmployeeDetails(@PathVariable Long empId){
		System.out.println("in deleteEmployeeDetails() of "+getClass());
		try {
			return ResponseEntity.ok(empService.deleteEmployeeDetails(empId));
		}catch(RuntimeException e) {
			System.out.println("got exception in deleteEmployeeDetails() of "+getClass());
			return new ResponseEntity<>(new ApiResponse("Invalid EmployeeId!!!!"+empId),HttpStatus.NOT_FOUND);
		}
		
	}
	
	@GetMapping("/{empId}")
	public ResponseEntity<?> getEmployeeDetails(@PathVariable Long empId){
		System.out.println("in getEmployeeDetails() of "+getClass());
		try {
			return ResponseEntity.ok(empService.getEmployeeDetails(empId));
		}catch(RuntimeException e) {
			System.out.println("got exception in getEmployeeDetails() of "+getClass());
			return new ResponseEntity<>(new ApiResponse("Invalid EmployeeId!!! id "+empId),HttpStatus.NOT_FOUND);
		}
		
	}
	
	@PutMapping
	public ResponseEntity<?> updateEmployeeDetails(@RequestBody @Valid Employee emp){
		System.out.println("in updateEmployeeDetails() of "+getClass());
		try {
			return ResponseEntity.ok(empService.updateEmployeeDetails(emp));
		}catch(RuntimeException e) {
			System.out.println("got exception in updateEmployeeDetails() of "+getClass());
			return new ResponseEntity<>(new ApiResponse(e.getMessage()),HttpStatus.NOT_FOUND);
		}
	}
	
	

}
