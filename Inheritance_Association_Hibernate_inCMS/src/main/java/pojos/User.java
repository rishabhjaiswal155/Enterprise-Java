package pojos;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.CollectionTable;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;
@Entity
@Table(name="users")
public class User extends BaseEntity{
	@Column(name="first_name",length=30)
	private String firstName;
	@Column(name = "last_name",length = 30)
	private String lastName;
	@Column(length=30,unique = true)
	private String email;
	@Column(length=20,nullable = false)
	private String password;
	@ManyToMany
	@JoinTable(name="users_role",joinColumns =@JoinColumn(name="user_id"),inverseJoinColumns = @JoinColumn(name="role_id"))
	private Set<Role> roles=new HashSet<>();//reccommended by Gavin King(initialization)
	@OneToMany(fetch = FetchType.EAGER,mappedBy = "customer",cascade = CascadeType.ALL)
	private List<Comment> comments=new ArrayList<>();
	@Embedded
	private Passport passport;
	@ElementCollection
	@CollectionTable(name="users_cards",joinColumns = @JoinColumn(name="user_id"))
	private List<Card> cards=new ArrayList<>();
	
	public User() {
		// TODO Auto-generated constructor stub
	}
	
	public User(String firstName, String lastName, String email, String password) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.password = password;
	}

	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
	public Set<Role> getRoles() {
		return roles;
	}

	public void setRoles(Set<Role> roles) {
		this.roles = roles;
	}
	
	
	public List<Comment> getComments() {
		return comments;
	}

	public void setComments(List<Comment> comments) {
		this.comments = comments;
	}

	//Gavin King recommends to add Helper methods
	public void addRole(Role role) {
		roles.add(role);
	}
	public void removeRole(Role role) {
		roles.remove(role);
	}

	@Override
	public String toString() {
		return "UserId="+getId()+",firstName=" + firstName + ", lastName=" + lastName + ", email=" + email;
	}
	

}
