package dao;

import static utils.HibernateUtils.getSf;

import java.util.List;

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
				msg="Tutorial added successfully! with authorId="+authorId+" and topicId="+topicId;
			}
			tx.commit();
		}catch(RuntimeException e) {
			if(tx!=null)
				tx.rollback();
			throw e;
		}
		return msg;
	}

	@Override
	public List<Tutorial> getAllTutorials() {
		List<Tutorial> tutorial;
		Session session=getSf().getCurrentSession();
		Transaction tx=session.beginTransaction();
		try {
			String jpql="select t from Tutorial t";
			tutorial=session.createQuery(jpql, Tutorial.class).getResultList();
		   tx.commit();
		}catch(RuntimeException e) {
			if(tx!=null)
				tx.rollback();
			throw e;
		}
		return tutorial;
	}

	@Override
	public List<Tutorial> getCompleteDetailsWithAuthorTopic() {
		List<Tutorial> tutorial;
		Session session=getSf().getCurrentSession();
		Transaction tx=session.beginTransaction();
		try {
			String jpql="select t from Tutorial t join fetch t.topic join fetch t.author";
			tutorial=session.createQuery(jpql, Tutorial.class).getResultList();
		   tx.commit();
		}catch(RuntimeException e) {
			if(tx!=null)
				tx.rollback();
			throw e;
		}
		return tutorial;	
	}

	@Override
	public List<Tutorial> FetchTutorialByName(String topicName) {
		List<Tutorial> tutorial;
		Session session=getSf().getCurrentSession();
		Transaction tx=session.beginTransaction();
		try {
		       //String jpql="select t from Tutorial t where t.topic.topicName=:tname";
		    String jpql="select t from Tutorial t join t.topic tp where tp.topicName=:tname";  
			tutorial = session.createQuery(jpql, Tutorial.class).setParameter("tname", topicName).getResultList();
		       tx.commit();
		}catch(RuntimeException e) {
			if(tx!=null)
				tx.rollback();
			throw e;
		}
		return tutorial;	
	}
}
