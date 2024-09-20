package dao;

import static utils.DbUtils.getCn;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import pojos.Candidate;

public class CandidateDaoImpl implements ICandidateDao {
private Connection cn;
private PreparedStatement pst1,pst2,pst3;
public CandidateDaoImpl() throws SQLException {
	cn=getCn();
	pst1=cn.prepareStatement("select * from candidates");
	pst2=cn.prepareStatement("update candidates set votes=votes+1 where id=?");
	pst3=cn.prepareStatement("select * from candidates order by votes desc limit 2");
	System.out.println("CandidateDao created....");
}
	@Override
	public List<Candidate> getCandidateList() throws SQLException {
		List<Candidate> names=new ArrayList<>();
		try(ResultSet rst=pst1.executeQuery()){
			while(rst.next())
				 names.add(new Candidate(rst.getInt(1),rst.getString(2), rst.getString(3), rst.getInt(4)));
		}
		return names;
	}
	
	
	
	public void cleanUp() throws SQLException {
		if(pst1!=null)
			pst1.close();
		System.out.println("CandidateDao cleaned up....");
	}
	@Override
	public String incrementVoteCount(int id) throws SQLException {
	       pst2.setInt(1, id);
	       int updatedCnt=pst2.executeUpdate();
	       if(updatedCnt==1)
	    	   return "increment success!";
	       return "failed!!";
	}
	@Override
	public List<Candidate> displayTopTwo() throws SQLException {
		List<Candidate> candidate=new ArrayList<>();
		try(ResultSet rst=pst3.executeQuery()){
			while(rst.next())
				candidate.add(new Candidate(rst.getInt(1),rst.getString(2), rst.getString(3),rst.getInt(4)));
		}
		return candidate;
	}


}
