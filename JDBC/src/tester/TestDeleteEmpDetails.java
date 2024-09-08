package tester;

import static utils.DbUtils.openConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.Scanner;
public class TestDeleteEmpDetails {

	public static void main(String[] args) {
		String sql="delete from my_emp where empid=?";
	try(Connection cn=openConnection();
			PreparedStatement pst=cn.prepareStatement(sql);
			Scanner sc=new Scanner(System.in)){
		System.out.println("Enter empid to delete the Employee details");
		pst.setInt(1, sc.nextInt());
		int updatedRow=pst.executeUpdate();
		if(updatedRow==1)
			System.out.println("Employee details deleted successfully!!!");
		else
			System.out.println("Deletion failed!!");
	}catch(Exception e) {
		e.printStackTrace();
	}
	}
}
