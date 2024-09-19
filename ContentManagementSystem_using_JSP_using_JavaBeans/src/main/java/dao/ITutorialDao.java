package dao;

import java.sql.SQLException;
import java.util.List;

import pojos.Tutorial;

public interface ITutorialDao {
	List<String> getTutorialNameByTopicId(int topicId) throws SQLException;
	Tutorial getTutorialDetailsByTutorialName(String tutorialName) throws SQLException; 
	String getUpdatedVisits(String tutorialName) throws SQLException;
	String addNewTutorial(Tutorial tutorial) throws SQLException;
}
