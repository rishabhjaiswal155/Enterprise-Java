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
	private PreparedStatement pst1;
	public EmployeeDaoImplementation() throws SQLException {
		cn=openConnection();
		String sql="select * from my_emp where deptid=? and join_date > ?";
		pst1=cn.prepareStatement(sql);
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
	
	public void cleanUp() throws SQLException {
		if(pst1!=null) {
			pst1.close();
			System.out.println("EmpDao destroyed.....");
		}
		closeConnection();
	}
}
