package dao;

import static utils.DbUtils.*;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import pojo.Employee;
public class EmployeeDaoImplementation implements IEmployeeDao {
	private Connection cn;
	private PreparedStatement pst1,pst2,pst3;
	public EmployeeDaoImplementation() throws SQLException {
		cn=openConnection();
		String sql1="select * from my_emp where deptid=? and join_date > ?";
		String sql2="insert into my_emp values(default,?,?,?,?,?)";
		String sql3="update my_emp set salary=salary+?,deptid=? where empid=?";
		pst1=cn.prepareStatement(sql1);
		pst2=cn.prepareStatement(sql2);
		pst3=cn.prepareStatement(sql3);
		System.out.println("EmpDao created.....");
	}
	
	@Override
	public List<Employee> getEmpDetails(String deptName,Date joinDate) throws SQLException{
		List<Employee> emps=new ArrayList<>();
		pst1.setString(1,deptName);
		pst1.setDate(2,joinDate);
		try(ResultSet rst=pst1.executeQuery()){
			while(rst.next())
				emps.add(new Employee(rst.getInt(1),rst.getString(2),rst.getString(3),rst.getDouble(4),rst.getString(5),rst.getDate(6)));
		}
		return emps;
	}
	
	@Override
	public String insertEmpDetails(Employee employee) throws SQLException {
		pst2.setString(1,employee.getName());
		pst2.setString(2,employee.getAddress());
		pst2.setDouble(3, employee.getSalary());
		pst2.setString(4, employee.getDeptName());
		pst2.setDate(5, employee.getJoinDate());
		int updatedRows=pst2.executeUpdate();
		if(updatedRows==1)	
		   return "EmpDetails Insertion successfull!";
		return "EmpDetails Insertion failed!";
	}

	@Override
	public String updateEmpDetails(double increment, String deptName, int empId) throws SQLException {
	    pst3.setDouble(1, increment);
	    pst3.setString(2, deptName);
	    pst3.setInt(3, empId);
	    int updatedcnt=pst3.executeUpdate();
	    if(updatedcnt==1)
	    	return "Updating EmpDetails Successfull!";
		return "Updation failed!!!";
	}
	
	public void cleanUp() throws SQLException {
		if(pst1!=null) 
			pst1.close();
		if(pst2!=null) 
			pst2.close();
		if(pst3!=null)
			pst3.close();
		System.out.println("EmpDao destroyed.....");	
		closeConnection();
	}

	

}
