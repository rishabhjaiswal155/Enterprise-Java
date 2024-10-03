package com.app.pojos;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
@Entity
@Table(name="tutorials")
public class Tutorial extends BaseEntity {
@Column(length=30)
	private String title;
private int visits;
@Column(name="publish_date")
private LocalDate publishDate;
@Column(length = 100)
private String contents;
@ManyToOne(fetch = FetchType.LAZY)
@JoinColumn(name="topic_id",nullable=false)
private Topic topic;
@ManyToOne(fetch = FetchType.LAZY)
@JoinColumn(name="author_id",nullable=false)
private User author;
@OneToMany(fetch = FetchType.EAGER,mappedBy = "tutorial",cascade = CascadeType.ALL)
private List<Comment> comments=new ArrayList<>();
public Tutorial() {
	// TODO Auto-generated constructor stub
}

public Tutorial(String title, LocalDate publishDate, String contents) {
	super();
	this.title = title;
	this.publishDate = publishDate;
	this.contents = contents;
}

public String getTitle() {
	return title;
}
public void setTitle(String title) {
	this.title = title;
}
public int getVisits() {
	return visits;
}
public void setVisits(int visits) {
	this.visits = visits;
}
public LocalDate getPublishDate() {
	return publishDate;
}
public void setPublishDate(LocalDate publishDate) {
	this.publishDate = publishDate;
}
public String getContents() {
	return contents;
}
public void setContents(String contents) {
	this.contents = contents;
}

public Topic getTopic() {
	return topic;
}

public void setTopic(Topic topic) {
	this.topic = topic;
}

public User getAuthor() {
	return author;
}

public void setAuthor(User author) {
	this.author = author;
}


public List<Comment> getComments() {
	return comments;
}

public void setComments(List<Comment> comments) {
	this.comments = comments;
}

@Override
public String toString() {
	return "TutorialId="+getId()+",title=" + title + ", visits=" + visits + ", publishDate=" + publishDate + ", contents=" + contents;
}
}
