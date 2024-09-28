package tester;
import static utils.HibernateUtils.getSf;


import java.util.Scanner;

import org.hibernate.SessionFactory;

import dao.TutorialDaoImpl;
public class FetchTutorailDetailsByTopicName {

	public static void main(String[] args) {
		try(SessionFactory sf=getSf();Scanner sc=new Scanner(System.in)){
		TutorialDaoImpl tutorialDao=new TutorialDaoImpl();
		System.out.println("Enter topicName");
		String topicName=sc.nextLine();
			tutorialDao.FetchTutorialByName(topicName).forEach(t->{
				System.out.println("TutorialDetails:"+t);
				System.out.println("Topic Details:"+t.getTopic());
				System.out.println("Author Details:"+t.getAuthor());
			});
					}catch(RuntimeException e) {
			e.printStackTrace();
		}

	}

}
