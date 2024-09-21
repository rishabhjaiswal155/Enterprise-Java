package utils;
import org.hibernate.*;
import org.hibernate.cfg.Configuration;
public class HibernateUtils {
	private static SessionFactory sf;
	static {
		System.out.println("in static initializer block");
		sf=new Configuration().configure().buildSessionFactory();
	}
	public static SessionFactory getSf() {
		return sf;
	}
}
