package pojos;
import javax.persistence.*;
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
	public User() {
		// TODO Auto-generated constructor stub
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
	@Override
	public String toString() {
		return "UserId="+getId()+"firstName=" + firstName + ", lastName=" + lastName + ", email=" + email;
	}
	

}
