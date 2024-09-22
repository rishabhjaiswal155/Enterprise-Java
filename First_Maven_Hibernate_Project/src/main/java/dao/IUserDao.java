package dao;

import pojos.User;

public interface IUserDao {
	String addNewUser(User user);
	String addNewUserwithgetCurrentSession(User user);

}
