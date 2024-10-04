package com.app.pojos;
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
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((roleName == null) ? 0 : roleName.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!(obj instanceof Role))
			return false;
		Role other = (Role) obj;
		if (roleName != other.roleName)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "RoleId="+getId()+",roleName=" + roleName;
	}
	
}
