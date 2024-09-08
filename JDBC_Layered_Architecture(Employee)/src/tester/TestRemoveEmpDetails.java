package tester;

import java.util.Scanner;

import dao.EmployeeDaoImplementation;

public class TestRemoveEmpDetails {

	public static void main(String[] args) {
		try(Scanner sc=new Scanner(System.in)){
			EmployeeDaoImplementation empDao=new EmployeeDaoImplementation();
			System.out.println("Enter empId to remove EmpDetails");
			System.out.println(empDao.removeEmpDetails(sc.nextInt()));
			empDao.cleanUp();
		}catch(Exception e) {
			e.printStackTrace();
		}
	}

}
