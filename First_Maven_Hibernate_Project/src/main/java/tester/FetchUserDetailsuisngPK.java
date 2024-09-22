package tester;
import static utils.HibernateUtils.getSf;

import java.util.Scanner;

import org.hibernate.SessionFactory;

import dao.UserDaoImpl;
public class FetchUserDetailsuisngPK {

	public static void main(String[] args) {
		try(SessionFactory sf=getSf();Scanner sc=new Scanner(System.in)){
			UserDaoImpl userDao=new UserDaoImpl();
			System.out.println("Enter userId to fetch userDetails ");
			System.out.println(userDao.getUserDetailsbyId(sc.nextInt()));
		}catch(RuntimeException e) {
			e.printStackTrace();
		}
	}
}
