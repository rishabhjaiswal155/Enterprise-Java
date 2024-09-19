package dao;

import static utils.DbUtils.getCn;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import pojos.Tutorial;

public class TutorialDaoImpl implements ITutorialDao {
	private Connection cn;
	private PreparedStatement pst1, pst2, pst3,pst4;

	public TutorialDaoImpl() throws SQLException {
		cn = getCn();
		pst1 = cn.prepareStatement("select name from tutorials where topic_id=?");
		pst2 = cn.prepareStatement("select * from tutorials where name=?");
		pst3 = cn.prepareStatement("update tutorials set visits=visits+1 where name=?");
		pst4=cn.prepareStatement("insert into tutorials values (default,?,?,?,?,?,?)");
		System.out.println("TutorialDao created....");
	}

	@Override
	public List<String> getTutorialNameByTopicId(int topicId) throws SQLException {
		List<String> names = new ArrayList<>();
		pst1.setInt(1, topicId);
		try (ResultSet rst = pst1.executeQuery()) {
			while (rst.next())
				names.add(rst.getString(1));
		}
		return names;
	}

	@Override
	public Tutorial getTutorialDetailsByTutorialName(String tutorialName) throws SQLException {
		pst2.setString(1, tutorialName);
		try (ResultSet rst = pst2.executeQuery()) {
			if (rst.next())
				// id | name | author | publish_date | visits | contents | topic_id
				return new Tutorial(rst.getInt(1), tutorialName, rst.getString(3), rst.getDate(4), rst.getInt(5),
						rst.getString(6), rst.getInt(7));
		}
		return null;
	}

	@Override
	public String getUpdatedVisits(String tutorialName) throws SQLException {
		pst3.setString(1, tutorialName);
		int updatedcnt = pst3.executeUpdate();
		if (updatedcnt == 1)
			return "Visits updated successfully!!!";
		return "Visits Updation failed....";
	}

	public void cleanUp() throws SQLException {
		if (pst1 != null)
			pst1.close();
		if (pst2 != null)
			pst2.close();
		if (pst3 != null)
			pst3.close();
		System.out.println("TutorialDao cleaned Up....");
	}

	@Override
	public String addNewTutorial(Tutorial tutorial) throws SQLException {
		pst4.setString(1,tutorial.getTutorialName());
		pst4.setString(2,tutorial.getAuthor());
		pst4.setDate(3, tutorial.getPublishDate());
		pst4.setInt(4, 0);
		pst4.setString(5, tutorial.getContents());
		pst4.setInt(6, tutorial.getTopicId());
		int updatedCnt=pst4.executeUpdate();
		if(updatedCnt==1)
			return "Tutorial Added SuccessFully";
		return "Tutorial insertion failed!!!";
		}

}
