package dao;

import pojos.User;

public interface IUserDao {
	String addNewUser(User user);
	String assignUserRoleByUserIdAndRoleId(long userId, long roleId);
	
	

}
