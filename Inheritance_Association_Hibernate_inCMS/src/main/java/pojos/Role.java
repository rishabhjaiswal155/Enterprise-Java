package pojos;
import javax.persistence.*;
@Entity
@Table(name="role")
public class Role extends BaseEntity{
	@Enumerated(EnumType.STRING)
	@Column(name="role_name",length=35,nullable=false)
private UserRole roleName;
	public Role() {
		// TODO Auto-generated constructor stub
	}
	
	public Role(UserRole roleName) {
		super();
		this.roleName = roleName;
	}

	public UserRole getRoleName() {
		return roleName;
	}
	public void setRoleName(UserRole roleName) {
		this.roleName = roleName;
	}
	@Override
	public String toString() {
		return "RoleId="+getId()+",roleName=" + roleName;
	}
	
}
