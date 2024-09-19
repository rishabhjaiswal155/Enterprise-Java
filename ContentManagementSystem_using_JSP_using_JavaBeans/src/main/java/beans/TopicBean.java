package beans;

import java.sql.SQLException;
import java.util.List;

import dao.TopicDaoImpl;
import pojos.Topic;

public class TopicBean {
private TopicDaoImpl topicDao;
public TopicBean() throws SQLException {
	topicDao=new TopicDaoImpl();
	System.out.println("TopicBean created....");
}
public TopicDaoImpl getTopicDao() {
	return topicDao;
}
public void setTopicDao(TopicDaoImpl topicDao) {
	this.topicDao = topicDao;
}

public List<Topic> getAllTopics() throws SQLException{
	return topicDao.getAllTopics();
}
}
