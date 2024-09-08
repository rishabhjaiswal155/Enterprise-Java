package dao;

import java.sql.SQLException;

public interface BankAccountDao {
	
	String transferFunds(int srcId,int destId,double balance) throws SQLException;

}
