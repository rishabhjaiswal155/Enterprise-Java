package utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DbUtils {
private static Connection cn;

public static Connection openConnection() throws SQLException {
	String url="jdbc:mysql://localhost:3306/rishabh_data?createDatabaseIfNotExist=true&useSSL=false&allowPublicKeyRetrieval=true";
	cn=DriverManager.getConnection(url,"root","root123");
	System.out.println("Database connection established Successfully");
	return cn;
}

public static Connection getCn() {
	return cn;
}

public static void closeConnection() throws SQLException {
	if(cn!=null)
		cn.close();
	System.out.println("DataBase Connection closed Successfully");
}
}
