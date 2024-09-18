package beans;

import java.sql.SQLException;

import dao.UserDaoImpl;
import pojos.User;

public class UserBean {
private String email;
private String password;
private UserDaoImpl userdao;
private User validatedUser;
private String message;
public UserBean() throws SQLException {
	userdao=new UserDaoImpl();
	System.out.println("userBean created....");
}
public String getEmail() {
	return email;
}
public String getPassword() {
	return password;
}
public UserDaoImpl getUserdao() {
	return userdao;
}
public User getValidatedUser() {
	return validatedUser;
}
public String getMessage() {
	return message;
}
public String validateUser() throws SQLException {
	System.out.println("in authenticatedUser() "+email+" "+password);
	validatedUser=userdao.authenticateUser(email, password);
	if(validatedUser==null) {
		message="Invalid login details!!!please retry";
		return "login";
	}
	message="Login successfull!!";
	if(validatedUser.getRole().equals("ADMIN"))
		return "admin";
	return "topics";
}
public void setEmail(String email) {
	this.email = email;
}
public void setPassword(String password) {
	this.password = password;
}
public void setUserdao(UserDaoImpl userdao) {
	this.userdao = userdao;
}
public void setValidatedUser(User validatedUser) {
	this.validatedUser = validatedUser;
}
}
