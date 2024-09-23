package tester;
import static utils.HibernateUtils.getSf;
import java.util.Scanner;

import org.hibernate.SessionFactory;

import dao.UserDaoImpl;
public class ChangepasswordByUserId {

	public static void main(String[] args) {
		try(SessionFactory sf=getSf();Scanner sc=new Scanner(System.in)){
			UserDaoImpl userDao=new UserDaoImpl();
			System.out.println("Enter userId and newPassword ");
			System.out.println(userDao.changePasswordByUserId(sc.nextInt(), sc.next()));
		}catch(RuntimeException e) {
			e.printStackTrace();
		}

	}

}
