package dao;

import java.sql.Date;
import java.sql.SQLException;
import java.util.List;

import pojo.Employee;

public interface IEmployeeDao {
	
	List<Employee> getEmpDetails(String deptName,Date joinDate) throws SQLException;
	
	String insertEmpDetails(Employee employee) throws SQLException;
	
	String updateEmpDetails(double increment,String deptName,int empId) throws SQLException;

	String removeEmpDetails(int empId) throws SQLException;
}
