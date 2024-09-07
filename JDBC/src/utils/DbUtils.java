package utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DbUtils {
private static Connection cn;
	//add a static method to open a Database connection
	public static Connection openConnection() throws /*ClassNotFoundException*/ SQLException {
	   //Load type-4 Driver (Not required in Modern JDBC API's)
		//Class.forName("com.mysql.cj.jdbc.Driver");
		String url="jdbc:mysql://localhost:3306/rishabh_data?createDatabaseIfNotExist=true&useSSL=false&allowpublicKeyRetrieval=true";	
		//get the connection
		cn=DriverManager.getConnection(url, "root", "root123");
		return cn;
	}
	public static Connection getCn() {
		return cn;
	}
	//add a static method to close the Database connection
	public static void closeConnection() throws SQLException {
		if(cn!=null)
			cn.close();
	}
}
