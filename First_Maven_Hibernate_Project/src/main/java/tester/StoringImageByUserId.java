package tester;
import static utils.HibernateUtils.*;
import java.util.Scanner;
import org.hibernate.*;
import dao.UserDaoImpl;
public class StoringImageByUserId {

	public static void main(String[] args) {
		try(SessionFactory sf=getSf();Scanner sc=new Scanner(System.in)){
			UserDaoImpl userDao=new UserDaoImpl();
			System.out.println("Enter userId");
			int userId=sc.nextInt();
			sc.nextLine();
			System.out.println("Enter image path for storing the image into DB");
			System.out.println(userDao.storeImageByUserid(userId, sc.next()));
		}catch(Exception e) {
			e.printStackTrace();
		}

	}

}
