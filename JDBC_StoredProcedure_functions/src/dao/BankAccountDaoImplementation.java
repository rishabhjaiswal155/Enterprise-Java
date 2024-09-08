package dao;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Types;

import static utils.DbUtils.*;
public class BankAccountDaoImplementation implements BankAccountDao {
	private Connection cn;
	private CallableStatement cst1;
	
	public BankAccountDaoImplementation() throws SQLException {
		cn=openConnection();
		cst1=cn.prepareCall("{call transfer_funds_proc(?,?,?,?,?)}");
		System.out.println("BankAccountDao created.....");
		//register out params
		cst1.registerOutParameter(4, Types.DOUBLE);
		cst1.registerOutParameter(5, Types.DOUBLE);
	}
	
	@Override
	public String transferFunds(int srcId, int destId, double balance) throws SQLException {
	    cst1.setInt(1, srcId);
	    cst1.setInt(2, destId);
	    cst1.setDouble(3, balance);
	    cst1.execute();//returns boolean which is ignored.
		return "src Account balance="+cst1.getDouble(4)+" dest Account balance="+cst1.getDouble(5);
	}
	
	public void cleanUp() throws SQLException {
		if(cst1!=null)
			cst1.close();
		System.out.println("BankAccountDao destroyed....");
		closeConnection();
	}

}
