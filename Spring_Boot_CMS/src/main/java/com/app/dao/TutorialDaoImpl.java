package com.app.dao;

import java.util.List;

import javax.persistence.EntityManager;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.app.pojos.Tutorial;
@Repository
public class TutorialDaoImpl implements ITutorialDao {

	@Autowired
	private EntityManager manager;
	@Override
	public List<String> getAllTutorialTitle(Long topicId) {
		String JPQL="select t.title from Tutorial t join t.topic tp where tp.id=:tid";
		return manager.createQuery(JPQL,String.class).setParameter("tid", topicId).getResultList();
	}
	@Override
	public Tutorial getTutorialDetails(Long tutorialId) {
		String JPQL="select t from Tutorial t where t.id=:id";
		return manager.createQuery(JPQL,Tutorial.class).setParameter("id",tutorialId).getSingleResult();
	}

}
