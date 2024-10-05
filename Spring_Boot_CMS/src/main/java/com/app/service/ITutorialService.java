package com.app.service;

import java.util.List;

import com.app.pojos.Tutorial;

public interface ITutorialService {

List<String> getAllTutorialTitle(Long topicId);
Tutorial getTutorialDetails(Long tutorialId);
}
