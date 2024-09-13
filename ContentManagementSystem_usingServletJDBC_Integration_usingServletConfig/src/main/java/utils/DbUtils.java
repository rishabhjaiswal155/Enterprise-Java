package utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DbUtils {
	private static Connection cn;
	public static Connection openConnection(String url,String userName,String password) throws SQLException {
		//String url="jdbc:mysql://localhost:3306/rishabh_data?createDatabaseIfNotExist=true&useSSL=false&allowPublicKeyRetrieval=true";
		cn=DriverManager.getConnection(url,userName,password);
		System.out.println("Database Connection established");
		return cn;
	}
	public static Connection getCn() {
		return cn;
	}
	
	public static void closeConnection() throws SQLException {
		if(cn!=null)
			cn.close();
		System.out.println("Database Connection Closed");
	}
}
