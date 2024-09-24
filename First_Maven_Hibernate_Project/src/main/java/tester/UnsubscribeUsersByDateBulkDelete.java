package tester;
import static utils.HibernateUtils.getSf;
import java.util.Scanner;
import org.hibernate.SessionFactory;
import static java.time.LocalDate.parse;
import dao.UserDaoImpl;
public class UnsubscribeUsersByDateBulkDelete {

	public static void main(String[] args) {
		try(SessionFactory sf=getSf();Scanner sc=new Scanner(System.in)){
			UserDaoImpl userDao=new UserDaoImpl();
			System.out.println("Enter Date[yyyy-mm-dd]");
			System.out.println(userDao.deleteAllUsersByDate(parse(sc.next())));
			}catch(RuntimeException e) {
			e.printStackTrace();
		}

	}

}
