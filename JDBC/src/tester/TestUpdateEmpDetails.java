package tester;

import static utils.DbUtils.openConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.Scanner;
public class TestUpdateEmpDetails {

	public static void main(String[] args) {
		String sql="update my_emp set salary=salary+?,deptid=? where empid=?";
	try(Connection cn=openConnection();
			PreparedStatement pst=cn.prepareStatement(sql);
			Scanner sc=new Scanner(System.in)){
		System.out.println("Enter increment in salary,deptid and empid to update the Employee details");
		pst.setDouble(1,sc.nextDouble());
		pst.setString(2, sc.next());
		pst.setInt(3, sc.nextInt());
		int updatedRow=pst.executeUpdate();
		if(updatedRow==1)
			System.out.println("Employee details updated successfully!!!");
		else
			System.out.println("Updation failed!!");
	}catch(Exception e) {
		e.printStackTrace();
	}
	}
}
