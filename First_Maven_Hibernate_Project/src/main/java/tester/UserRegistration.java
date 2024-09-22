package tester;
import static utils.HibernateUtils.getSf;

import java.time.LocalDate;
import java.util.Scanner;

import org.hibernate.SessionFactory;

import dao.UserDaoImpl;
import pojos.Role;
import pojos.User;

public class UserRegistration {

	public static void main(String[] args) {
		try(SessionFactory sf=getSf();Scanner sc=new Scanner(System.in)){
			UserDaoImpl userDao=new UserDaoImpl();
			System.out.println("Enter User Details: firstName,lastName,email,password,confirm password,userRole,regAmount,regDate(yr-mon-day)");
			System.out.println(userDao.addNewUser(new User(sc.next(), sc.next(), sc.next(), sc.next(), sc.next(), Role.valueOf(sc.next().toUpperCase()), sc.nextDouble(),LocalDate.parse(sc.next()))));
		}catch(RuntimeException e) {
			e.printStackTrace();
		}

	}

}
