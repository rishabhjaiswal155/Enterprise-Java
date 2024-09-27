package tester;
import static utils.HibernateUtils.getSf;


import java.util.Scanner;

import org.hibernate.SessionFactory;

import dao.TutorialDaoImpl;
public class FetchCompleteTutorialDetailswithAuthorTopic {

	public static void main(String[] args) {
		try(SessionFactory sf=getSf();Scanner sc=new Scanner(System.in)){
		TutorialDaoImpl tutorialDao=new TutorialDaoImpl();
			tutorialDao.getCompleteDetailsWithAuthorTopic().forEach(t->{
				System.out.println("Tutorial Details:"+t);
				System.out.println("Topic Details:"+t.getTopic());
				System.out.println("Author details:"+t.getAuthor());
			});
					}catch(RuntimeException e) {
			e.printStackTrace();
		}

	}

}
