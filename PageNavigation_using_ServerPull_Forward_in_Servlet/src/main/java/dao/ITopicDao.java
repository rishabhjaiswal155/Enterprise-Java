package dao;

import java.sql.SQLException;
import java.util.List;

import pojos.Topic;

public interface ITopicDao {
	List<Topic> getAllTopicNames() throws SQLException; 
}
