package tester;

import java.util.Scanner;

import dao.EmployeeDaoImplementation;

public class TestUpdateEmpDetails {

	public static void main(String[] args) {
		try(Scanner sc=new Scanner(System.in)){
			EmployeeDaoImplementation empDao=new EmployeeDaoImplementation();
			System.out.println("Enter increment in salary,deptName and empId to update EmpDetails");
			System.out.println(empDao.updateEmpDetails(sc.nextDouble(), sc.next(), sc.nextInt()));
			empDao.cleanUp();
		}catch(Exception e) {
			e.printStackTrace();
		}
	}

}
