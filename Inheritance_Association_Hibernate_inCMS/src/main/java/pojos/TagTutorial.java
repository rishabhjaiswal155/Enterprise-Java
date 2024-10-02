package pojos;
import java.time.LocalDate;
import javax.persistence.*;
@Entity
@Table(name="tags_tutorials",uniqueConstraints = @UniqueConstraint(columnNames = {"tutorial_id","tag_id"}))
public class TagTutorial extends BaseEntity{
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name="tutorial_id")
	private Tutorial tutorial;
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name="tag_id")
	private Tag tag;
	@Column(name="creation_date")
	private LocalDate creationDate;
	public TagTutorial() {
		// TODO Auto-generated constructor stub
	}
	public Tutorial getTutorial() {
		return tutorial;
	}
	public void setTutorial(Tutorial tutorial) {
		this.tutorial = tutorial;
	}
	public Tag getTag() {
		return tag;
	}
	public void setTag(Tag tag) {
		this.tag = tag;
	}
	public LocalDate getCreationDate() {
		return creationDate;
	}
	public void setCreationDate(LocalDate creationDate) {
		this.creationDate = creationDate;
	}
	@Override
	public String toString() {
		return "TagTutorial [creationDate=" + creationDate + ", getId()=" + getId() + "]";
	}
	

}
