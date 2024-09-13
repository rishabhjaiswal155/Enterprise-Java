package dao;

import static utils.DbUtils.getCn;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import pojos.Topic;public class TopicDaoImpl implements ITopicDao {
    private Connection cn;
    private PreparedStatement pst1;
	public TopicDaoImpl() throws SQLException {
      cn=getCn();
      pst1=cn.prepareStatement("select name from topics");
      System.out.println("TopicDao created....");
	}
	@Override
	public List<Topic> getAllTopicNames() throws SQLException {
		List<Topic> names=new ArrayList<>();
		try(ResultSet rst=pst1.executeQuery()){
			while(rst.next())
				names.add(new Topic(rst.getInt(1),rst.getString(2)));
			return names;
		}
	}
	
	public void cleanUp() throws SQLException {
		if(pst1!=null)
			pst1.close();
		System.out.println("TopicDao cleanedUp....");
	}

}
