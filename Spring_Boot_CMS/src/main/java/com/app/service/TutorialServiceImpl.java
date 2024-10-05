package com.app.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.app.dao.ITutorialDao;
import com.app.pojos.Tutorial;
@Service
@Transactional
public class TutorialServiceImpl implements ITutorialService {

	@Autowired
	private ITutorialDao tutorialDao;
	
	@Override
	public List<String> getAllTutorialTitle(Long topicId) {
		return tutorialDao.getAllTutorialTitle(topicId);
	}

	@Override
	public Tutorial getTutorialDetails(String tutorialTitle) {
		Tutorial tutorial=tutorialDao.getTutorialDetails(tutorialTitle);
		tutorial.setVisits(tutorial.getVisits()+1);
		return tutorial;
	}

}
