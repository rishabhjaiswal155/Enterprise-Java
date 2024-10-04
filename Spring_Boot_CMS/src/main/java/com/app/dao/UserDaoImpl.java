package com.app.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.hibernate.*;
import com.app.pojos.User;

@Repository
public class UserDaoImpl implements IUserDao {

	@Autowired
	private SessionFactory sf;

	@Override
	public User authenticateUser(String email, String password) {
		String JPQL = "select u from User u join fetch u.roles where u.email=:em and u.password=:pass";
		return sf.getCurrentSession().createQuery(JPQL, User.class).setParameter("em", email)
				.setParameter("pass", password).getSingleResult();
	}

}
