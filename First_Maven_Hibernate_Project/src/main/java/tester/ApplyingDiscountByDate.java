package tester;
import static utils.HibernateUtils.getSf;
import java.util.Scanner;
import static java.time.LocalDate.parse;
import org.hibernate.SessionFactory;

import dao.UserDaoImpl;
public class ApplyingDiscountByDate {

	public static void main(String[] args) {
		try(SessionFactory sf=getSf();Scanner sc=new Scanner(System.in)){
			UserDaoImpl userDao=new UserDaoImpl();
			System.out.println("Enter DiscountAmount and Date[yr-mon-day]");
			System.out.println(userDao.applyDiscountByDate(sc.nextDouble(), parse(sc.next())));
		}catch(RuntimeException e) {
			e.printStackTrace();
		}

	}

}
