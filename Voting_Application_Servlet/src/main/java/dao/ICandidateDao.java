package dao;

import java.sql.SQLException;
import java.util.List;

import pojos.Candidate;

public interface ICandidateDao {
	List<Candidate> getCandidateList() throws SQLException;
	String incrementVoteCount(int id) throws SQLException;
	List<Candidate> displayTopTwo() throws SQLException;

}
