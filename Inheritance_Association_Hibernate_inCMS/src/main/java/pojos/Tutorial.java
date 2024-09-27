package pojos;
import java.time.LocalDate;
import javax.persistence.*;
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
@ManyToOne
@JoinColumn(name="topic_id",nullable=false)
private Topic topic;
@ManyToOne
@JoinColumn(name="author_id",nullable=false)
private User author;
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
@Override
public String toString() {
	return "TutorialId="+getId()+"title=" + title + ", visits=" + visits + ", publishDate=" + publishDate + ", contents=" + contents
			+ ", topic=" + topic + ", author=" + author;
}

}
