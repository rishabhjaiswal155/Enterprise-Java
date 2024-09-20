package dao;
import static utils.DbUtils.getCn;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import pojos.User;

public class UserDaoImpl implements IUserDao {
	private Connection cn;
	private PreparedStatement pst1,pst2;
	public UserDaoImpl() throws SQLException {
		cn=getCn();
		pst1=cn.prepareStatement("select * from user where email=? and password=?");
		pst2=cn.prepareStatement("update user set status=? where id=?");
		System.out.println("UserDao created....");
	}

	@Override
	public User authenticateUser(String email, String password) throws SQLException {
		pst1.setString(1, email);
		pst1.setString(2, password);
		try(ResultSet rst=pst1.executeQuery()){
			if(rst.next())
				return new User(rst.getInt(1), rst.getString(2),rst.getString(3),email, password,rst.getDate(6), rst.getBoolean(7), rst.getString(8));
		}
		return null;
	}
	
	public void cleanUp() throws SQLException {
		if(pst1!=null)
			pst1.close();
		System.out.println("UserDao cleaned up....");
	}

	@Override
	public String updateVotingStatus(int id) throws SQLException {
		pst2.setBoolean(1,true);
		pst2.setInt(2, id);
		int updatedCnt=pst2.executeUpdate();
		if(updatedCnt==1)
			return "You have Voted Successfully";
		return "status Updation failed!!!";
	}

}
