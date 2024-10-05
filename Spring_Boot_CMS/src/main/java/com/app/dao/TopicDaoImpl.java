package com.app.dao;

import java.util.List;

import javax.persistence.EntityManager;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.app.pojos.Topic;
@Repository
@Transactional
public class TopicDaoImpl implements ITopicDao {

	@Autowired
	private EntityManager manager;
	
	@Override
	public List<Topic> getAllTopicName() {
		String JPQL="select t from Topic t";
		return manager.createQuery(JPQL,Topic.class).getResultList();
	}

}
