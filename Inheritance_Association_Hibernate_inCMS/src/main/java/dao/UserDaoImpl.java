package dao;

import static utils.HibernateUtils.getSf;

import java.util.Set;

import org.hibernate.Session;
import org.hibernate.Transaction;

import pojos.Role;
import pojos.User;
public class UserDaoImpl implements IUserDao {

	@Override
	public String addNewUser(User user) {
		String msg="New User insertion failed!!";
		Session session=getSf().getCurrentSession();
		Transaction tx=session.beginTransaction();
		try {
			session.persist(user);
			msg="New User added successfully!!! with userId "+user.getId();
			tx.commit();
		}catch(RuntimeException e) {
			if(tx!=null)
				tx.rollback();
			throw e;
		}
		return msg;
	}

	@Override
	public String assignUserRoleByUserIdAndRoleId(long userId, long roleId) {
		String msg="Assigning UserRole Failed!!!";
		Session session=getSf().getCurrentSession();
		Transaction tx=session.beginTransaction();
		try {
			User user=session.get(User.class, userId);
			Role role=session.get(Role.class, roleId);
			if(user!=null & role!=null) {
				user.addRole(role);
				session.persist(user);
				msg="UserRole assigning SuccessFull! for User:"+user.getId()+" to Role:"+role.getRoleName();
			}			
			tx.commit();
		}catch(RuntimeException e) {
			if(tx!=null)
				tx.rollback();
			throw e;
		}
		return msg;
	}

	@Override
	public String registerUserWithSetOfRoles(User user, Set<Role> roles) {
		String msg="Registering User with Collection of Roles failed!!!";
		Session session=getSf().getCurrentSession();
		Transaction tx=session.beginTransaction();
		try {
			roles.forEach(r->user.addRole(r));
			System.out.println("Roles:"+user.getRoles());
			session.persist(user);
		    msg="Registering User with Collection of Roles SuccessFull!! with userId:"+user.getId()+" and Roles:"+roles;
			tx.commit();
		}catch(RuntimeException e) {
			if(tx!=null)
				tx.rollback();
			throw e;
		}
		return msg;
	}

}
