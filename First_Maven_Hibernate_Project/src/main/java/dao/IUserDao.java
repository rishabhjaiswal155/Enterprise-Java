package dao;

import java.time.LocalDate;
import java.util.List;

import pojos.Role;
import pojos.User;

public interface IUserDao {
	String addNewUser(User user);
	String addNewUserwithgetCurrentSession(User user);
	User getUserDetailsbyId(int userId);
	List<User> getAllUserDetails();
	List<User> getAllUserDetailsByDateAndRole(LocalDate start,LocalDate end,Role role);
    User userLogin(String email,String password);
}
