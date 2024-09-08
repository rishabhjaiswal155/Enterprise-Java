package tester;

import static utils.DbUtils.openConnection;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.util.Scanner;
public class TestInsetNewEmpDetails {

	public static void main(String[] args) {
		String sql="insert into my_emp values(default,?,?,?,?,?)";
	try(Connection cn=openConnection();
			PreparedStatement pst=cn.prepareStatement(sql);
			Scanner sc=new Scanner(System.in)){
		System.out.println("Enter Employee details: name,address,salary,deptid,join date");
		pst.setString(1, sc.next());
		pst.setString(2, sc.next());
		pst.setDouble(3,sc.nextDouble());
		pst.setString(4, sc.next());
		pst.setDate(5, Date.valueOf(sc.next()));
		int updatedRow=pst.executeUpdate();
		if(updatedRow==1)
			System.out.println("Employee details inserted successfully!!!");
		else
			System.out.println("Insertion failed!!");
	}catch(Exception e) {
		e.printStackTrace();
	}
	}
}
