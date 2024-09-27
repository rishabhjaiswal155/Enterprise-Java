package tester;
import org.hibernate.*;
import static utils.HibernateUtils.*;
public class TestHibernate {

	public static void main(String[] args) {
		try(SessionFactory sf=getSf()){
			System.out.println("Hibernate up and running "+sf);
		}catch(RuntimeException e) {
			e.printStackTrace();
		}

	}

}
