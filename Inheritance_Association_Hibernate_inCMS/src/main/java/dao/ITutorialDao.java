package dao;

import java.util.List;

import pojos.Tutorial;

public interface ITutorialDao {
	String addNewTutorial(Tutorial tutorial,Long authorId,Long topicId);
	List<Tutorial> getAllTutorials();

}