package beans;

import java.sql.Date;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.Period;

import dao.TutorialDaoImpl;
import pojos.Tutorial;

public class TutorialBean {
private String tutorialName;
private String author;
private String pubDate;
private String contents;
private int topicId;
private TutorialDaoImpl tutDao;
private String message;

public TutorialBean() throws SQLException {
	tutDao=new TutorialDaoImpl();
	System.out.println("TutorialBean created....");
	}
public String getTutorialName() {
	return tutorialName;
}
public void setTutorialName(String tutorialName) {
	this.tutorialName = tutorialName;
}
public String getAuthor() {
	return author;
}
public void setAuthor(String author) {
	this.author = author;
}
public String getPubDate() {
	return pubDate;
}
public void setPubDate(String pubDate) {
	this.pubDate = pubDate;
}
public String getContents() {
	return contents;
}
public void setContents(String contents) {
	this.contents = contents;
}
public int getTopicId() {
	return topicId;
}
public void setTopicId(int topicId) {
	this.topicId = topicId;
}
public TutorialDaoImpl getTutDao() {
	return tutDao;
}
public void setTutDao(TutorialDaoImpl tutDao) {
	this.tutDao = tutDao;
}

public String getMessage() {
	return message;
}
public String validateAndInsertTutorial() throws SQLException {
	System.out.println("In validateAndInsertTutorial "+topicId+" "+tutorialName);
	long periodInMonths=Period.between(LocalDate.parse(pubDate),LocalDate.now()).toTotalMonths();
	if(contents.length()>255 || periodInMonths>6) {
		message="Invalid contents or publishDate"; 
		return "add_New_Tutorial";
	}
	message=tutDao.addNewTutorial(new Tutorial(tutorialName, author,Date.valueOf(pubDate),contents, topicId));
  return "admin";
}
}
