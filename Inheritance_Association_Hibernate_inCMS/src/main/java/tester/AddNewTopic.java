package tester;
import static utils.HibernateUtils.getSf;

import java.util.Scanner;

import org.hibernate.SessionFactory;

import dao.TopicDaoImpl;
import pojos.Topic;
public class AddNewTopic {

	public static void main(String[] args) {
		try(SessionFactory sf=getSf();Scanner sc=new Scanner(System.in)){
			TopicDaoImpl topicDao=new TopicDaoImpl();
			System.out.println("Enter Topic details: topicName");
			System.out.println(topicDao.addNewTopic(new Topic(sc.nextLine())));
		}catch(RuntimeException e) {
			e.printStackTrace();
		}

	}

}
