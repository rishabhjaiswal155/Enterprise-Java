package tester;

import java.sql.Date;
import java.util.Scanner;

import dao.EmployeeDaoImplementation;
import pojo.Employee;

public class TestInsertEmpDetails {

	public static void main(String[] args) {
		try(Scanner sc=new Scanner(System.in)){
			EmployeeDaoImplementation empDao=new EmployeeDaoImplementation();
			System.out.println("enter Employee details: name,address,salary,deptName,joinDate[yr-mon-day]");
			System.out.println(empDao.insertEmpDetails(new Employee(sc.next(), sc.next(), sc.nextDouble(), sc.next(), Date.valueOf(sc.next()))));
			empDao.cleanUp();
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
}
