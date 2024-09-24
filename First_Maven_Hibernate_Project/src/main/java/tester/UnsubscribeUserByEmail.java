package tester;
import static utils.HibernateUtils.getSf;
import java.util.Scanner;
import org.hibernate.SessionFactory;

import dao.UserDaoImpl;
public class UnsubscribeUserByEmail {

	public static void main(String[] args) {
		try(SessionFactory sf=getSf();Scanner sc=new Scanner(System.in)){
			UserDaoImpl userDao=new UserDaoImpl();
			System.out.println("Enter Email");
			System.out.println(userDao.unsubscribeUser(sc.next()));
			}catch(RuntimeException e) {
			e.printStackTrace();
		}

	}

}
