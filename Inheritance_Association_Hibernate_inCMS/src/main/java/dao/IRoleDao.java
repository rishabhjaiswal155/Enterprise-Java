package dao;

import pojos.Role;
import pojos.UserRole;

public interface IRoleDao {
	String addNewRole(Role role);
	Role findRoleByroleName(UserRole roleName);

}
