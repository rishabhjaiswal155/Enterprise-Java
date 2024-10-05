package com.app.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;

import com.app.pojos.User;

@Repository
public class UserDaoImpl implements IUserDao {

	@Autowired // OR @PersistenceContext
	private EntityManager manager;

	@Override
	public User authenticateUser(String email, String password) {
		String JPQL = "select u from User u join fetch u.roles where u.email=:em and u.password=:pass";
		return manager.createQuery(JPQL, User.class).setParameter("em", email)
				.setParameter("pass", password).getSingleResult();
	}

}
