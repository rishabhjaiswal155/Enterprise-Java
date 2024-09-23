package tester;
import static utils.HibernateUtils.getSf;
import static java.time.LocalDate.parse;
import static pojos.Role.valueOf;
import java.util.Scanner;

import org.hibernate.SessionFactory;

import dao.UserDaoImpl;
public class getAllUserDetailsByDateAndRole {

	public static void main(String[] args) {
		try(SessionFactory sf=getSf();Scanner sc=new Scanner(System.in)){
			UserDaoImpl userDao=new UserDaoImpl();
			System.out.println("Enter start date,end date[yr-mon-day] and role");
			userDao.getAllUserDetailsByDateAndRole(parse(sc.next()),parse(sc.next().toUpperCase()),valueOf(sc.next())).forEach(System.out::println);
		}catch(RuntimeException e) {
			e.printStackTrace();
		}

	}

}
