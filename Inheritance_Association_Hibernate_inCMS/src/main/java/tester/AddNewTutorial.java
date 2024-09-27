package tester;
import static utils.HibernateUtils.getSf;

import java.time.LocalDate;
import java.util.Scanner;

import org.hibernate.SessionFactory;
import dao.TutorialDaoImpl;
import pojos.Tutorial;
public class AddNewTutorial {

	public static void main(String[] args) {
		try(SessionFactory sf=getSf();Scanner sc=new Scanner(System.in)){
		TutorialDaoImpl tutorialDao=new TutorialDaoImpl();
			System.out.println("Enter Tutorial details:title,publishDate[yr-mon-day]");
			String title=sc.nextLine();
			LocalDate pubDate=LocalDate.parse(sc.next());
			System.out.println("Enter contents");
			sc.nextLine();
			String contents=sc.nextLine();
			System.out.println("Enter authorId and TopicId");
			System.out.println(tutorialDao.addNewTutorial(new Tutorial(title, pubDate,contents), sc.nextLong(), sc.nextLong()));
		}catch(RuntimeException e) {
			e.printStackTrace();
		}

	}

}
