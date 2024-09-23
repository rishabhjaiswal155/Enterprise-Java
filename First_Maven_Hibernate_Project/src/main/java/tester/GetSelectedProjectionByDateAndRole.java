package tester;
import static utils.HibernateUtils.getSf;
import static java.time.LocalDate.parse;
import static pojos.Role.valueOf;

import java.util.Scanner;

import org.hibernate.SessionFactory;

import dao.UserDaoImpl;
public class GetSelectedProjectionByDateAndRole {

	public static void main(String[] args) {
		try(SessionFactory sf=getSf();Scanner sc=new Scanner(System.in)){
			UserDaoImpl userDao=new UserDaoImpl();
			System.out.println("Enter start Date[yr-mon-day],end date and role");
			userDao.getSelectedProjectionByDateAndRole(parse(sc.next()),parse(sc.next()),valueOf(sc.next().toUpperCase())).forEach(i->System.out.println(i.getLastName()+" "+i.getRegAmount()+" "+i.getRegDate()));
			}catch(RuntimeException e) {
			e.printStackTrace();
		}

	}

}
