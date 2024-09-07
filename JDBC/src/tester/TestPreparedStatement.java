package tester;

import static utils.DbUtils.openConnection;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Scanner;
public class TestPreparedStatement {

	public static void main(String[] args) {
		String sql="select empid,name,salary,deptid,join_date from my_emp where deptid=? and join_date between ? and ?";
	try( Connection cn=openConnection();
			Scanner sc=new Scanner(System.in);
		   PreparedStatement st=cn.prepareStatement(sql)){
		System.out.println("Enter deptid,begin date and end date");
		st.setString(1,sc.next());
		st.setDate(2, Date.valueOf(sc.next()));
		st.setDate(3, Date.valueOf(sc.next()));
		
		try(ResultSet rst=st.executeQuery()){
		  	while(rst.next())
		{
			System.out.printf("EmpId %d name %s salary %.2f DeptId %s joining on %s %n"
					,rst.getInt(1),rst.getString(2),rst.getDouble(3),rst.getString(4),rst.getDate(5));
		}	
		}//rst.close()
	}//st.close()  cn.close()
	catch(Exception e) {
		e.printStackTrace();
	}
	}
}
