package dao;

import pojos.Tutorial;

public interface ITutorialDao {
	String addNewTutorial(Tutorial tutorial,Long authorId,Long topicId);

}
