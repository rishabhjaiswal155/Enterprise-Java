package tester;
import static utils.HibernateUtils.*;
import org.hibernate.*;
public class TestHibernate {

	public static void main(String[] args) {
		try(SessionFactory sf=getSf()){
			System.out.println("Hibernate Up and Running");
		}//sf.close(); database connection pooled out
		catch(Exception e) {
			e.printStackTrace();
		}

	}

}
