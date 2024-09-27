package dao;

import static utils.HibernateUtils.getSf;

import org.hibernate.Session;
import org.hibernate.Transaction;

import pojos.Topic;
import pojos.Tutorial;
import pojos.User;
public class TutorialDaoImpl implements ITutorialDao {

	@Override
	public String addNewTutorial(Tutorial tutorial,Long authorId,Long topicId) {
		String msg="Adding New Tutorial failed!!!";
		Session session=getSf().getCurrentSession();
		Transaction tx=session.beginTransaction();
		try {
			User author=session.get(User.class,authorId);
			Topic topic=session.get(Topic.class, topicId);
			if(author!=null && topic!=null) {
				System.out.println(tutorial.getAuthor()+" "+tutorial.getTopic());//null null
				//establish the unidirectional link between tutorial and user
				tutorial.setAuthor(author);
				//establish the unidirectional link between tutorial and topic
				tutorial.setTopic(topic);
				System.out.println(tutorial.getAuthor()+" "+tutorial.getTopic());
				session.persist(tutorial);
				msg="Tutorial added successfully! with authorId="+authorId+"and topicId="+topicId;
			}
			tx.commit();
		}catch(RuntimeException e) {
			if(tx!=null)
				tx.rollback();
			throw e;
		}
		return msg;
	}

}
