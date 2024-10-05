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
	public Tutorial getTutorialDetails(String tutorialTitle) {
		String JPQL="select t from Tutorial t join fetch t.topic tp join fetch t.author a where t.title=:title";
		return manager.createQuery(JPQL,Tutorial.class).setParameter("title",tutorialTitle).getSingleResult();
	}

}
