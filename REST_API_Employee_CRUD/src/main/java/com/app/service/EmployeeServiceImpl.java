package com.app.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.app.dao.EmployeeRepository;
import com.app.entities.Employee;
@Service
@Transactional
public class EmployeeServiceImpl implements IEmployeeService {

	@Autowired
	private EmployeeRepository empRep;
	@Override
	public List<Employee> getAllEmployeeDetails() {
		return empRep.findAll();
	}
	@Override
	public Employee addEmployeeDetails(Employee emp) {
		return empRep.save(emp);
	}
	@Override
	public String deleteEmployeeDetails(Long empId) {
		empRep.deleteById(empId);
		return "Employee details deleted successfully! for Id "+empId;
	}

}
