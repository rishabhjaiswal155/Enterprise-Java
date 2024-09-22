package tester;
import static utils.HibernateUtils.getSf;

import org.hibernate.SessionFactory;

import dao.UserDaoImpl;
public class FetchAllUserDetails {

	public static void main(String[] args) {
		try(SessionFactory sf=getSf()){
			UserDaoImpl userDao=new UserDaoImpl();
			userDao.getAllUserDetails().forEach(System.out::println);
		}catch(RuntimeException e) {
			e.printStackTrace();
		}
	}
}
