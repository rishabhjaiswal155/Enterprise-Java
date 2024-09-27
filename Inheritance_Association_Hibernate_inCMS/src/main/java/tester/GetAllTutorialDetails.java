package tester;
import static utils.HibernateUtils.getSf;


import java.util.Scanner;

import org.hibernate.SessionFactory;

import dao.TutorialDaoImpl;
public class GetAllTutorialDetails {

	public static void main(String[] args) {
		try(SessionFactory sf=getSf();Scanner sc=new Scanner(System.in)){
		TutorialDaoImpl tutorialDao=new TutorialDaoImpl();
			tutorialDao.getAllTutorials().forEach(t->{
				System.out.println("Tutorial Details:"+t);
				System.out.println("Author detail:"+t.getAuthor());
				System.out.println("Topic Details:"+t.getTopic());
				});
					}catch(RuntimeException e) {
			e.printStackTrace();
		}

	}

}
