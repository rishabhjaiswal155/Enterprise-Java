package tester;
import org.hibernate.*;

import dao.UserDaoImpl;

import static utils.HibernateUtils.*;

import java.util.Scanner;
public class AssignUserRole {
	public static void main(String[] args) {
		try(SessionFactory sf=getSf();Scanner sc=new Scanner(System.in)){
			UserDaoImpl userDao=new UserDaoImpl();
			System.out.println("Enter userId and roleId");
			System.out.println(userDao.assignUserRoleByUserIdAndRoleId(sc.nextLong(), sc.nextLong()));
	}catch(RuntimeException e) {
		e.printStackTrace();
	}
	}

}
