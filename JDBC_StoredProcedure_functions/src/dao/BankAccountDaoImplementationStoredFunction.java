package dao;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Types;

import static utils.DbUtils.*;
public class BankAccountDaoImplementationStoredFunction implements BankAccountDao {
	private Connection cn;
	private CallableStatement cst2;
	
	public BankAccountDaoImplementationStoredFunction() throws SQLException {
		cn=openConnection();
		cst2=cn.prepareCall("{?=call transfer_funds_func(?,?,?)}");
		System.out.println("BankAccountDao created.....");
		//register out params
        cst2.registerOutParameter(1, Types.DOUBLE);
		}
	
	@Override
	public String transferFunds(int srcId, int destId, double amount) throws SQLException {
        cst2.setInt(2, srcId);
	    cst2.setInt(3, destId);
	    cst2.setDouble(4, amount);
	    cst2.execute();//returns boolean which is ignored.
		return "dest Account balance="+cst2.getDouble(1);
	}
	
	public void cleanUp() throws SQLException {
		if(cst2!=null)
			cst2.close();
		System.out.println("BankAccountDao destroyed....");
		closeConnection();
	}
}
