package dao;

import java.util.List;

import pojos.User;

public interface IUserDao {
	String addNewUser(User user);
	String addNewUserwithgetCurrentSession(User user);
	User getUserDetailsbyId(int userId);
	List<User> getAllUserDetails();

}
