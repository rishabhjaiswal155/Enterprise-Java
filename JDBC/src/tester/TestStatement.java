package tester;
import static utils.DbUtils.openConnection;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
public class TestStatement {

	public static void main(String[] args) {
	try( Connection cn=openConnection();
		   Statement st=cn.createStatement();
		   ResultSet rst=st.executeQuery("select * from my_emp")){
		while(rst.next())
		{
			System.out.printf("EmpId %d name %s address %s salary %.2f DeptId %s joining on %s %n"
					,rst.getInt(1),rst.getString(2),rst.getString(3),rst.getDouble(4),rst.getString(5),rst.getDate(6));
		}	
	}//cn.close()
	catch(Exception e) {
		e.printStackTrace();
	}
	}
}
