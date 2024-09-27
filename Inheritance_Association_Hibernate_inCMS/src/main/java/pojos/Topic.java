package pojos;

import javax.persistence.*;

@Entity
@Table(name="topics")
public class Topic extends BaseEntity{
	@Column(name = "topic_name",length=30)
	private String topicName;
	public Topic() {
		// TODO Auto-generated constructor stub
	}
	public String getTopicName() {
		return topicName;
	}
	public void setTopicName(String topicName) {
		this.topicName = topicName;
	}
	@Override
	public String toString() {
		return "Topicid="+getId()+"topicName=" + topicName;
	}
	
	

}
