package tester;

import java.sql.Date;
import java.util.Scanner;
import dao.EmployeeDaoImplementation;
public class TestGetEmpDetails {
	public static void main(String[] args) {
		try(Scanner sc=new Scanner(System.in)){
			EmployeeDaoImplementation empDao=new EmployeeDaoImplementation();
			System.out.println("Enter deptName and joinDate[yr-mon-day] to get Employee details");
			empDao.getEmpDetails(sc.next(),Date.valueOf(sc.next())).forEach(System.out::println);
			empDao.cleanUp();
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
}
