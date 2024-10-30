package com.app.service;

import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.app.custom_exception.ResourceNotFoundException;
import com.app.dao.EmployeeRepository;
import com.app.dto.EmployeeDto;
import com.app.entities.Employee;
@Service
@Transactional
public class EmployeeServiceImpl implements IEmployeeService {

	@Autowired
	private EmployeeRepository empRep;
	
	@Autowired
	private ModelMapper mapper;
	@Override
	public List<Employee> getAllEmployeeDetails() {
		return empRep.findAll();
	}
	@Override
	public EmployeeDto addEmployeeDetails(Employee emp) {
		Employee employee= empRep.save(emp);
		return mapper.map(employee,EmployeeDto.class);
	}
	@Override
	public String deleteEmployeeDetails(Long empId) {
		empRep.deleteById(empId);
		return "Employee details deleted successfully! for Id "+empId;
	}
	@Override
	public EmployeeDto getEmployeeDetails(Long empId) {
		Employee emp=empRep.findById(empId).orElseThrow(()->new ResourceNotFoundException("Invalid Employee id!!"+empId));
		return mapper.map(emp, EmployeeDto.class);
		}
	@Override
	public EmployeeDto updateEmployeeDetails(Employee emp) {
		if(empRep.existsById(emp.getId())) {
		   Employee employee= empRep.save(emp);
		   return mapper.map(employee,EmployeeDto.class);
		}
		throw new ResourceNotFoundException("Invalid EmpID "+emp.getId()+"Updation failed!!!");
	}

}
