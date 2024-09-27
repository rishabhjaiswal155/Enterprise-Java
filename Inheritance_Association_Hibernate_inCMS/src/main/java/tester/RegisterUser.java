package tester;
import org.hibernate.*;

import dao.UserDaoImpl;
import pojos.User;

import static utils.HibernateUtils.*;

import java.util.Scanner;
public class RegisterUser {

	public static void main(String[] args) {
		try(SessionFactory sf=getSf();Scanner sc=new Scanner(System.in)){
			UserDaoImpl userDao=new UserDaoImpl();
			System.out.println("Enter User details: firstName,lastName,email,Password");
			System.out.println(userDao.addNewUser(new User(sc.next(), sc.next(), sc.next(), sc.next())));
		}catch(RuntimeException e) {
			e.printStackTrace();
		}

	}

}
