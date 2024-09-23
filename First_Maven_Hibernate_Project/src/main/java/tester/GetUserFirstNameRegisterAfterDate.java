package tester;
import static utils.HibernateUtils.getSf;
import static java.time.LocalDate.parse;
import java.util.Scanner;

import org.hibernate.SessionFactory;

import dao.UserDaoImpl;
public class GetUserFirstNameRegisterAfterDate {

	public static void main(String[] args) {
		try(SessionFactory sf=getSf();Scanner sc=new Scanner(System.in)){
			UserDaoImpl userDao=new UserDaoImpl();
			System.out.println("Enter Date[yr-mon-day]");
			userDao.getAllUserFirstNameRegisterAfterDate(parse(sc.next())).forEach(System.out::println);
			}catch(RuntimeException e) {
			e.printStackTrace();
		}

	}

}
