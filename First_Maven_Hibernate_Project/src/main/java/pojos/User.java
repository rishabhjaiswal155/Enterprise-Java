package pojos;
import javax.persistence.*;
import java.util.Date;
@Entity//Mandatory class level
@Table(name="users_tbl") //optional but recommended
public class User {
	@Id//Mandatory field level or property level i.e getter
	@GeneratedValue(strategy = GenerationType.IDENTITY) //for Auto increment //default GenerationType.Auto
	@Column(name = "user_id") //optional but recommended
	private Integer userId;//pk must be serializable to obtain persistence
	@Column(name = "first_name",length=30) //optional but recommended
	private String firstName;
	@Column(name = "last_name",length = 30)
	private String lastName;
	@Column(length = 20,unique = true)
	private String email;
	@Column(length = 15,nullable = false)
	private String password;
	@Transient
	private String confirmPassword;
	@Column(name = "user_role",length = 20)
	@Enumerated(EnumType.STRING)
	private Role userRole;
	@Column(name = "reg_amt")
	private double regAmount;
	@Column(name = "reg_date")
	private Date regDate;
	@Lob //tell hibernates that it is large object
	private byte[] image;
	public User() {
	System.out.println("in User default ctr");
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
	public String getConfirmPassword() {
		return confirmPassword;
	}
	public void setConfirmPassword(String confirmPassword) {
		this.confirmPassword = confirmPassword;
	}
	public Role getUserRole() {
		return userRole;
	}
	public void setUserRole(Role userRole) {
		this.userRole = userRole;
	}
	public double getRegAmount() {
		return regAmount;
	}
	public void setRegAmount(double regAmount) {
		this.regAmount = regAmount;
	}
	public Date getRegDate() {
		return regDate;
	}
	public void setRegDate(Date regDate) {
		this.regDate = regDate;
	}
	@Override
	public String toString() {
		return "User [userId=" + userId + ", firstName=" + firstName + ", lastName=" + lastName + ", email=" + email
				+ ", userRole=" + userRole + ", regAmount=" + regAmount + ", regDate=" + regDate + "]";
	}
	

}
