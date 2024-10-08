package tester;
import static utils.HibernateUtils.getSf;

import java.time.LocalDate;
import java.util.Scanner;

import org.hibernate.*;

import dao.UserDaoImpl;
import pojos.Role;
import pojos.User;

public class UserRegistrationusinggetCurrentSession {
	public static void main(String[] args) {
		try(SessionFactory sf=getSf();Scanner sc=new Scanner(System.in)){
			UserDaoImpl userDao=new UserDaoImpl();
			System.out.println("Enter User Details: firstName,lastName,email,password,confirm password,userRole,regAmount,regDate(yr-mon-day)");
			User transientUser=new User(sc.next(), sc.next(), sc.next(), sc.next(), sc.next(), Role.valueOf(sc.next().toUpperCase()), sc.nextDouble(),LocalDate.parse(sc.next()));
			System.out.println("userId of transientUser:"+transientUser.getUserId());
			transientUser.setUserId(199);
			System.out.println(userDao.addNewUserwithgetCurrentSession(transientUser));
		}catch(RuntimeException e) {
			e.printStackTrace();
		}

	}

}
