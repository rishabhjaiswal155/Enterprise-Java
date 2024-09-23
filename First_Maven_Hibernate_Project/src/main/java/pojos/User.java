package pojos;
import java.time.LocalDate;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.Table;
import javax.persistence.Transient;

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
	private LocalDate regDate;
	@Lob //tell hibernates that it is large object
	private byte[] image;
	public User() {
	System.out.println("in User default ctr");
	}
	
	public User(String firstName, String lastName, String email, String password, String confirmPassword, Role userRole,
			double regAmount, LocalDate regDate) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.password = password;
		this.confirmPassword = confirmPassword;
		this.userRole = userRole;
		this.regAmount = regAmount;
		this.regDate = regDate;
	}

	public Integer getUserId() {
		return userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
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
	public LocalDate getRegDate() {
		return regDate;
	}
	public void setRegDate(LocalDate regDate) {
		this.regDate = regDate;
	}
	
	
	public User(String lastName, double regAmount, LocalDate regDate) {
		super();
		this.lastName = lastName;
		this.regAmount = regAmount;
		this.regDate = regDate;
	}

	@Override
	public String toString() {
		return "User [userId=" + userId + ", firstName=" + firstName + ", lastName=" + lastName + ", email=" + email
				+ ", userRole=" + userRole + ", regAmount=" + regAmount + ", regDate=" + regDate + "]";
	}
	

}
