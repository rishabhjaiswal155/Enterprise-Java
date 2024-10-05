package com.app.dao;

import java.util.List;

import com.app.pojos.Tutorial;

public interface ITutorialDao {
List<String> getAllTutorialTitle(Long topicId);
Tutorial getTutorialDetails(Long tutorialId);
}
