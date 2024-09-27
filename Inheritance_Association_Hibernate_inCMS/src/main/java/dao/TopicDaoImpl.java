package dao;

import pojos.Topic;
import org.hibernate.*;
import static utils.HibernateUtils.*;

public class TopicDaoImpl implements ITopicDao {

	@Override
	public String addNewTopic(Topic topic) {
		String msg="Addition of New Topic failed!!!";
		Session session=getSf().getCurrentSession();
		Transaction tx=session.beginTransaction();
		try {
			session.persist(topic);
			msg="New Topic Added successfully with TopicId:"+topic.getId();
			tx.commit();
		}catch(RuntimeException e) {
			if(tx!=null)
				tx.rollback();
			throw e;
		}
		return msg;
	}

}
