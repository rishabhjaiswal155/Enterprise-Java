package pojos;

import java.sql.Date;

//| id | name    | email | password    | reg_amt | reg_date   | role
public class User {
private int userId;
private String userName;
private String email;
private String password;
private double regAmt;
private Date regDate;
private String role;
public User() {
	// TODO Auto-generated constructor stub
}
public User(int userId, String userName, String email, String password, double regAmt, Date regDate, String role) {
	super();
	this.userId = userId;
	this.userName = userName;
	this.email = email;
	this.password = password;
	this.regAmt = regAmt;
	this.regDate = regDate;
	this.role = role;
}
public int getUserId() {
	return userId;
}
public void setUserId(int userId) {
	this.userId = userId;
}
public String getUserName() {
	return userName;
}
public void setUserName(String userName) {
	this.userName = userName;
}
public String getEmail() {
	return email;
}
public void setEmail(String email) {
	this.email = email;
}
public String getPassword() {
	return password;
}
public void setPassword(String password) {
	this.password = password;
}
public double getRegAmt() {
	return regAmt;
}
public void setRegAmt(double regAmt) {
	this.regAmt = regAmt;
}
public Date getRegDate() {
	return regDate;
}
public void setRegDate(Date regDate) {
	this.regDate = regDate;
}
public String getRole() {
	return role;
}
public void setRole(String role) {
	this.role = role;
}
@Override
public String toString() {
	return "User [userId=" + userId + ", userName=" + userName + ", email=" + email + ", regAmt=" + regAmt
			+ ", regDate=" + regDate + ", role=" + role + "]";
}

}
