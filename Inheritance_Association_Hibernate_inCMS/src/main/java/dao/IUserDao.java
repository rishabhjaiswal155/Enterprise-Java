package dao;

import java.util.Set;

import pojos.Role;
import pojos.User;

public interface IUserDao {
	String addNewUser(User user);
	String assignUserRoleByUserIdAndRoleId(long userId, long roleId);
	String registerUserWithSetOfRoles(User user,Set<Role> roles);
	
	

}
