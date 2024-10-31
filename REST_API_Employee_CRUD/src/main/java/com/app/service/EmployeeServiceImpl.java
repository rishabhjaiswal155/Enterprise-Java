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
	public EmployeeDto addEmployeeDetails(EmployeeDto empDto) {
		Employee employee=mapper.map(empDto,Employee.class);
		Employee employee1= empRep.save(employee);
		return mapper.map(employee1,EmployeeDto.class);
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
	public EmployeeDto updateEmployeeDetails(EmployeeDto empDto) {
		Employee employee=mapper.map(empDto,Employee.class);
		if(empRep.existsById(employee.getId())) {
		   Employee employee1= empRep.save(employee);
		   return mapper.map(employee1,EmployeeDto.class);
		}
		throw new ResourceNotFoundException("Invalid EmpID "+employee.getId()+"Updation failed!!!");
	}

}
