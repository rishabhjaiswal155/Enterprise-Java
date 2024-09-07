package tester;
import static utils.DbUtils.openConnection;
import java.sql.Connection;
public class TestDBConnection {

	public static void main(String[] args) {
	try(Connection cn=openConnection()){
		System.out.println("Database connection is successfull!!!!! "+cn);
	}//cn.close()
	catch(Exception e) {
		e.printStackTrace();
	}
	}
}
