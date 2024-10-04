package com.app.pojos;
import javax.persistence.*;
@Entity
@Table(name="comments",uniqueConstraints = @UniqueConstraint(columnNames = { "tutorial_id","customer_id" }))
public class Comment extends BaseEntity{
	@Column(name = "comment_text",length=100)
	private String commentText;
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name="tutorial_id",nullable=false)
	private Tutorial tutorial;
	@ManyToOne(fetch =FetchType.LAZY)
	@JoinColumn(name="customer_id",nullable = false)
	private User customer;
	public Comment() {
		// TODO Auto-generated constructor stub
	}
	public Comment(String commentText) {
		super();
		this.commentText = commentText;
	}
	public String getCommentText() {
		return commentText;
	}
	public void setCommentText(String commentText) {
		this.commentText = commentText;
	}
	public Tutorial getTutorial() {
		return tutorial;
	}
	public void setTutorial(Tutorial tutorial) {
		this.tutorial = tutorial;
	}
	public User getCustomer() {
		return customer;
	}
	public void setCustomer(User customer) {
		this.customer = customer;
	}
	
	@Override
	public String toString() {
		return "Comment [commentText=" + commentText + ", getId()=" + getId() + "]";
	}
	

}
