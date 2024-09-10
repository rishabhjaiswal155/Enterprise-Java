package dao;
import static utils.DbUtils.getCn;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import pojos.User;

public class UserDaoImpl implements IUserDao {
	private Connection cn;
	private PreparedStatement pst1;
	public UserDaoImpl() throws SQLException {
	cn=getCn();
	pst1=cn.prepareStatement("select * from users where email=? and password=?");
	System.out.println("UserDao created....");
	}

	@Override
	public User authenticateUser(String email, String password) throws SQLException {
		pst1.setString(1, email);
		pst1.setString(2, password);
		try(ResultSet rst=pst1.executeQuery()){
			if(rst.next())
				return new User(rst.getInt(1), rst.getString(2), email, password, rst.getDouble(5), rst.getDate(6), rst.getString(7));
		}
		return null;
	}
	
	public void cleanUp() throws SQLException {
		if(pst1!=null)
			pst1.close();
		System.out.println("UserDao cleanUp....");
	}
}
